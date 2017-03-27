package com.xinxiong.androidutilsdemo.EditTextActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.xinxiong.androidutilsdemo.R;

/**
 * Created by zhangxin on 17/1/14.
 */

public class EditTestActivity extends Activity {
    private EditText et_test;
    private String TAG="EditTestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittest);
        et_test.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               // Log.e(TAG,"s--->"+s+"start--->"+start+"count--->"+count+"after"+after);
                //Log.e(TAG,"sss--");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
