package com.xinxiong.androidutilsdemo.roundprogressbar;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.xinxiong.androidutilsdemo.R;


/**
 * 仿iphone带进度的进度条，线程安全的View，可直接在线程中更新进度
 * @author xiaanming
 *
 */
public class RoundProgressBar extends View {
    /**
     * 画笔对象的引用
     */
    private Paint paint;

    /**
     * 圆环的颜色
     */
    private int roundColor;

    /**
     * 圆环进度的颜色
     */
    private int roundProgressColor;

    /**
     * 中间进度百分比的字符串的颜色
     */
    private int textColor;

    /**
     * 中间进度百分比的字符串的字体
     */
    private float textSize;
    /**
     * 中间分母分子字符串的颜色
     */
    private int textColor1;
    /**
     * 中间分母分子字符串的字体
     */
    private float textSize1;
    /**
     * 圆环的宽度
     */
    private float roundWidth;

    /**
     * 最大进度
     */
    private int max;

    /**
     * 当前进度
     */
    private int progress;
    /**
     * 是否显示中间的进度
     */
    private boolean textIsDisplayable;

    /**
     * 进度的风格，实心或者空心
     */
    private int style;

    public static final int STROKE = 0;
    public static final int FILL = 1;
    public static final int TRANSLUCENT=2;
    private String tag="RoundProgressBar";

    //最开始的秒数
    private int secondCount=3;

    private boolean timeOverOne=true;
    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint = new Paint();
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,
                R.styleable.RoundProgressBar);

        //获取自定义属性和默认值
        roundColor = mTypedArray.getColor(R.styleable.RoundProgressBar_roundColor, Color.RED);
        roundProgressColor = mTypedArray.getColor(R.styleable.RoundProgressBar_roundProgressColor, Color.GREEN);
        textColor = mTypedArray.getColor(R.styleable.RoundProgressBar_textColor, Color.GREEN);
        textSize = mTypedArray.getDimension(R.styleable.RoundProgressBar_textSize, 15);

        textColor1=mTypedArray.getColor(R.styleable.RoundProgressBar_textColor1, Color.GRAY);
        textSize1=mTypedArray.getDimension(R.styleable.RoundProgressBar_textSize, 15);

        roundWidth = mTypedArray.getDimension(R.styleable.RoundProgressBar_roundWidth, 5);
        max = mTypedArray.getInteger(R.styleable.RoundProgressBar_max1, 100);
        textIsDisplayable = mTypedArray.getBoolean(R.styleable.RoundProgressBar_textIsDisplayable, true);
        style = mTypedArray.getInt(R.styleable.RoundProgressBar_style, 0);

        mTypedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 画最外层的大圆环
         */
        int centre = getWidth()/2; //获取圆心的x坐标
        int radius = (int) (centre - roundWidth/2); //圆环的半径
        paint.setColor(roundColor); //设置圆环的颜色
        paint.setStyle(Paint.Style.STROKE); //设置空心
        paint.setStrokeWidth(roundWidth); //设置圆环的宽度
        paint.setAntiAlias(true);  //消除锯齿
        canvas.drawCircle(centre, centre, radius, paint); //画出圆环
//
//		Log.e("log", centre + "");

        /**
         * 画进度百分比
         */
//		paint.setStrokeWidth(0);
//		paint.setColor(textColor);
//		paint.setTextSize(textSize);
//		paint.setTypeface(Typeface.DEFAULT_BOLD); //设置字体
//		int percent = (int)(((float)progress / (float)max) * 100);  //中间的进度百分比，先转换成float在进行除法运算，不然都为0
//		float textWidth = paint.measureText(percent + "%");   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
//
//		if(textIsDisplayable && percent != 0 && style == STROKE){
//			canvas.drawText(percent + "%", centre - textWidth / 2, centre , paint); //画出进度百分比
//		}

        /**
         * 画除率
         */
//		paint.setStrokeWidth(0);
//		paint.setColor(textColor1);
//		paint.setTextSize(textSize1);
//		paint.setTypeface(Typeface.DEFAULT_BOLD); //设置字体
//		int molecule = 10;  //分子
//		int denominator=25;//分母
//		float textWidth1 = paint.measureText(percent + "/"+denominator);   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
//
//		if(textIsDisplayable && percent != 0 && style == STROKE){
//			canvas.drawText(molecule + "/"+denominator, centre - textWidth1 / 2, centre + textSize1, paint); //画出进度百分比
//		}

        /***
         * 画秒数
         */

        paint.setStrokeWidth(0);
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        //paint.setTypeface(Typeface.DEFAULT_BOLD); //设置字体

//		int percent = (int)(((float)progress / (float)max) * 100);  //中间的进度百分比，先转换成float在进行除法运算，不然都为0
//		float textWidth = paint.measureText(percent + "%");   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
//
//		if(textIsDisplayable && percent != 0 && style == STROKE){
//			//canvas.drawText(percent + "%", centre - textWidth / 2, centre , paint); //画出进度百分比
//		}

        canvas.drawText(secondCount+" 跳过", centre / 2-centre/10, centre+centre/5 , paint);
        /**
         * 画圆弧 ，画圆环的进度
         */

        //设置进度是实心还是空心
        paint.setStrokeWidth(roundWidth+1); //设置圆环的宽度
        paint.setColor(roundProgressColor);  //设置进度的颜色
        RectF oval = new RectF(centre - radius, centre - radius, centre
                + radius, centre + radius);  //用于定义的圆弧的形状和大小的界限

        switch (style) {
            case STROKE:{
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawArc(oval, 0, 360 * progress / max, false, paint);  //根据进度画圆弧
                break;
            }
            case FILL:{
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                if(progress !=0)
                    canvas.drawArc(oval, 0, 360 * progress / max, true, paint);  //根据进度画圆弧
                break;
            }
            case TRANSLUCENT:
                int opacity = 127;
                paint.setAlpha(opacity);
                canvas.drawArc(oval, 0, 360 * progress / max, true, paint);  //根据进度画圆弧
                break;
        }

    }


    public synchronized int getMax() {
        return max;
    }

    /**
     * 设置进度的最大值
     * @param max
     */
    public synchronized void setMax(int max) {
        if(max < 0){
            throw new IllegalArgumentException("max not less than 0");
        }
        this.max = max;
    }

    /**
     * 获取进度.需要同步
     * @return
     */
    public synchronized int getProgress() {
        return progress;
    }

    /**
     * 设置进度，此为线程安全控件，由于考虑多线的问题，需要同步
     * 刷新界面调用postInvalidate()能在非UI线程刷新
     * @param progress
     */
    public synchronized void setProgress(int progress) {
        if(progress < 0){
            throw new IllegalArgumentException("progress not less than 0");
        }
        if(progress > max){
            progress = max;
        }
        if(progress <= max){
            this.progress = progress;
            postInvalidate();
        }

    }

    public synchronized void setProgress(int value,boolean b) {
        if(b){
            ValueAnimator animaator=ValueAnimator.ofInt(0,value);
            animaator.setTarget(this);
            animaator.setDuration(3000).start();
            animaator.addUpdateListener(new AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // TODO Auto-generated method stub
                    //Float value=(Float)animation.getAnimatedValue();
                    Integer value=(Integer)animation.getAnimatedValue();
                    //Log.e(tag,"value----->"+value);

                    if(value==0){
                        secondCount=3;
                    }else if(value==33){
                        secondCount=2;
                    }else if(value==66){
                        secondCount=1;
                    }else if(value==99){
                        secondCount=0;

                        if(timeOverOne){
                            timeOverListenter.timeOver(true);
                        }

                        timeOverOne=false;


                    }
                    setProgressValue(value);
                    //mRoundProgressBar1.setProgress((int)value);

                }
            });
        }else{
            setProgressValue(progress);
        }
    }

    public void setProgressValue(int pro){
        if(progress < 0){
            throw new IllegalArgumentException("progress not less than 0");
        }
        if(progress > max){
            progress = max;
        }
        if(progress <= max){
            this.progress = pro;
            postInvalidate();
        }
    }


    public int getCricleColor() {
        return roundColor;
    }

    public void setCricleColor(int cricleColor) {
        this.roundColor = cricleColor;
    }

    public int getCricleProgressColor() {
        return roundProgressColor;
    }

    public void setCricleProgressColor(int cricleProgressColor) {
        this.roundProgressColor = cricleProgressColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public float getRoundWidth() {
        return roundWidth;
    }

    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
    }

    public void setTextColor1(int textColor){
        this.textColor1=textColor;
    }
    public float getTextColor1(){
        return textColor1;
    }

    public void setTextSize1(float textSize){
        this.textSize1=textSize;
    }
    public float getTextSize1(){
        return textSize1;
    }


    public interface  OnTimeOverListenter{
        void timeOver(boolean b);
    };
    OnTimeOverListenter timeOverListenter;
    public void setOnTimeOverListener(OnTimeOverListenter timeOverListenter){
        this.timeOverListenter=timeOverListenter;
    }
}
