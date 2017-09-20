package com.xinxiong.androidutilsdemo.animator;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by zhangxin on 17/8/4.
 */

public class PointSinEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.x + fraction * (endPoint.x - startPoint.x);
        float y = (float) (Math.sin(x * Math.PI / 180) * 100) + endPoint.y/2;
        Point point = new Point((int) x,(int) y);

        return point;
    }
}
