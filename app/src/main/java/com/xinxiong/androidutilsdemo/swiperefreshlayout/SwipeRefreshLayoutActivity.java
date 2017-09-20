package com.xinxiong.androidutilsdemo.swiperefreshlayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.xinxiong.androidutilsdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangxin on 17/9/8.
 */

public class SwipeRefreshLayoutActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.swipRefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.gridView)
    GridView gridView;
    List<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private int index = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        swipeRefreshLayout = (android.support.v4.widget.SwipeRefreshLayout) findViewById(R.id.swipRefresh);
        gridView = (GridView) findViewById(R.id.gridView);

        for (int i = 0; i < 20; i++) {
            list.add("你好");
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        gridView.setAdapter(adapter);

        //改变加载显示的颜色
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.RED);
        //设置背景颜色
        swipeRefreshLayout.setBackgroundColor(Color.YELLOW);
        //设置初始时的大小
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
        //设置监听
        swipeRefreshLayout.setOnRefreshListener(this);
        //设置向下拉多少出现刷新
        swipeRefreshLayout.setDistanceToTriggerSync(100);
        //设置刷新出现的位置
        swipeRefreshLayout.setProgressViewEndTarget(false, 200);
    }

    @Override
    public void onRefresh() {

        //设置每次刷新时需要更新的数据
        list.clear();
        index++;
        for (int i = 0; i < 20; i++) {
            list.add("我好,哈哈" + index);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //然刷新控件停留两秒后消失
                    Thread.sleep(2000);
                    handler.post(new Runnable() {//在主线程执行
                        @Override
                        public void run() {
                            //更新数据
                            adapter.notifyDataSetChanged();
                            //停止刷新
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
