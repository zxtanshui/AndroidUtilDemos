package com.xinxiong.androidutilsdemo.moreprocess;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhangxin on 17/7/19.
 */

public class TestActivity1 extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserManager.userId=2;
        Log.e("process",UserManager.userId+"");
    }
}
