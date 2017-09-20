package com.xinxiong.androidutilsdemo.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhangxin on 17/8/4.
 */

public class AnimatorActivity extends Activity {
    private final int RADIUS=200;
    private String TAG = "AnimatorActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initPoint();
        initAnimatorTest1();
        Log.e(TAG,"-------");
    }

    void initPoint(){
        Point startP = new Point(RADIUS,RADIUS);
        Point endP = new Point(800 - RADIUS,800- RADIUS);
        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointSinEvaluator(),startP,endP);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
            }
        });
    }

    void initAnimatorTest1(){
        ValueAnimator animator = ValueAnimator.ofFloat(0f,1f);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float current = (float)animation.getAnimatedValue();
                Log.e(TAG,"current----->"+current);
            }
        });
        animator.start();
    }
}
