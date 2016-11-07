package com.xinxiong.androidutilsdemo.roundprogressbar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xinxiong.androidutilsdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangxin on 16/11/7.
 */

public class RoundRrogressBarActivity extends Activity implements View.OnClickListener{

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.roundProgressBar1)
    RoundProgressBar roundProgressBar1;
    private Context mContext;
    private boolean isTimeOver=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        ButterKnife.bind(this);
        mContext=RoundRrogressBarActivity.this;
        button1.setOnClickListener(this);

        roundProgressBar1.setOnTimeOverListener(new RoundProgressBar.OnTimeOverListenter() {
            @Override
            public void timeOver(boolean b) {
                isTimeOver=b;
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                if(isTimeOver){
                    roundProgressBar1.setProgress(100,true);
                    isTimeOver=false;
                }

                roundProgressBar1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Toast.makeText(mContext, "点击了", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
