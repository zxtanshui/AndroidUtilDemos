package com.xinxiong.androidutilsdemo.progressbardialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import com.xinxiong.androidutilsdemo.R;
import com.xinxiong.androidutilsdemo.selectpic.ShowSelectPicActivity;

import butterknife.ButterKnife;

/**
 * Created by zhangxin on 17/1/10.
 */

public class ProgressBarDialogActivity extends Activity{
    private Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        btn_click=(Button) findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(ProgressBarDialogActivity.this);
            }
        });
    }
    public void showDialog(Context context){
        ProgressDialog downloadDialog = new ProgressDialog(this);
        downloadDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        downloadDialog.setCanceledOnTouchOutside(false);
        downloadDialog.setProgressNumberFormat("%1d kb/%2d kb");
        downloadDialog.setCancelable(false);
        downloadDialog.setProgress(100);
        downloadDialog.show();

    }
}
