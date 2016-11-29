package com.xinxiong.androidutilsdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xinxiong.androidutilsdemo.morewidow.MoreWindow;
import com.xinxiong.androidutilsdemo.roundprogressbar.RoundRrogressBarActivity;
import com.xinxiong.androidutilsdemo.selectpic.imageloader.ShowSelectPicActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.tv_morewindow)
     TextView tv_morewindow;
    @BindView(R.id.tv_roundprogressbar)
     TextView tv_roundprogressbar;
     MoreWindow mMoreWindow;
    @BindView(R.id.tv_select_pictures)
    TextView tv_select_pictures;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext=MainActivity.this;
        tv_morewindow.setOnClickListener(this);
        tv_roundprogressbar.setOnClickListener(this);
        tv_select_pictures.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.tv_morewindow:
                showMoreWindow(tv_morewindow);
                break;

            case R.id.tv_roundprogressbar:
                 intent=new Intent(mContext, RoundRrogressBarActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_select_pictures:
                 intent=new Intent(mContext, ShowSelectPicActivity.class);
                 startActivity(intent);
                break;
        }
    }


    private void showMoreWindow(View view) {
        if (null == mMoreWindow) {
            mMoreWindow = new MoreWindow(this);
            mMoreWindow.init();
        }
        mMoreWindow.showMoreWindow(view, 100);
    }


}
