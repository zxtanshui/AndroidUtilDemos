package com.xinxiong.androidutilsdemo.selectpic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xinxiong.androidutilsdemo.R;
import com.xinxiong.androidutilsdemo.selectpic.adapter.PicturesShowAdapter;
import com.xinxiong.androidutilsdemo.selectpic.imageloader.SelectPicActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangxin on 16/11/29.
 */

public class ShowSelectPicActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.recyclerview)
     RecyclerView mRecyclerView;
    @BindView(R.id.tv_selectpic)
     TextView tv_selectpic;
    private String TAG ="ShowSelectPicActivity";
//    @BindView(R.id.viewPager)
//    ViewPager viewPager;
//    @BindView(R.id.viewGroup)
//    LinearLayout viewGroup;

    private PicturesShowAdapter mAdapter;
    private List<String> picList=new ArrayList<>();
    private static final int REQUESTCODE=11;
    private Context mContext;
    private final String tag="ShowSelectPicActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG,"oncrete0-------");
        super.onCreate(savedInstanceState);
        mContext=ShowSelectPicActivity.this;
        setContentView(R.layout.activity_showselectpic);
        ButterKnife.bind(this);
        initView();
    }

    public void initView(){

        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
        mRecyclerView.setAdapter(mAdapter = new PicturesShowAdapter(mContext));

        tv_selectpic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.tv_selectpic:
                intent=new Intent(mContext,SelectPicActivity.class);
                startActivityForResult(intent,REQUESTCODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data!=null){
            picList=data.getStringArrayListExtra("result");
            if(requestCode==REQUESTCODE){//图片选择
                mAdapter.setPicList(picList);
                mAdapter.notifyDataSetChanged();
                Log.e(tag,picList.toString());
            }
        }
    }
}
