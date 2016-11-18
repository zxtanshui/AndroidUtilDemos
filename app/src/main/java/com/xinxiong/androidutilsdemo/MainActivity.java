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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.btn_morewindow)
     Button btn_morewindow;
    @BindView(R.id.btn_roundprogressbar)
     Button btn_roundprogressbar;
     MoreWindow mMoreWindow;


    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext=MainActivity.this;
        btn_morewindow.setOnClickListener(this);
        btn_roundprogressbar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_morewindow:
                showMoreWindow(btn_morewindow);
                break;

            case R.id.btn_roundprogressbar:
                Intent intent=new Intent(mContext, RoundRrogressBarActivity.class);
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
