package com.xinxiong.androidutilsdemo.morewindow1;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.xinxiong.androidutilsdemo.R;

public class MoreWindow1 extends PopupWindow implements OnClickListener {

	private String TAG = MoreWindow1.class.getSimpleName();
	Activity mContext;
	private int mWidth;
	private int mHeight;
	private int statusBarHeight;
	private Bitmap mBitmap = null;
	private Bitmap overlay = null;

	private Handler mHandler = new Handler();

	public MoreWindow1(Activity context) {
		mContext = context;
	}

	public void init() {
		Rect frame = new Rect();
		mContext.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame); // 这里得到的是除了系统自带显示区域之外的所有区域，这里就是除了最上面的一条显示电量的状态栏之外的所有区域
		statusBarHeight = frame.top;// 这里便可以得到状态栏的高度，即最上面一条显示电量，信号等
		DisplayMetrics metrics = new DisplayMetrics();
		mContext.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		mWidth = metrics.widthPixels;
		mHeight = metrics.heightPixels;

		setWidth(mWidth);
		setHeight(mHeight);
	}

	/*
	 * private Bitmap blur() { if (null != overlay) { return overlay; } long
	 * startMs = System.currentTimeMillis();
	 * 
	 * View view = mContext.getWindow().getDecorView();
	 * view.setDrawingCacheEnabled(true); view.buildDrawingCache(true); mBitmap
	 * = view.getDrawingCache();
	 * 
	 * float scaleFactor = 8;//图片缩放比例； float radius = 10;//模糊程度 int width =
	 * mBitmap.getWidth(); int height = mBitmap.getHeight();
	 * 
	 * overlay = Bitmap.createBitmap((int) (width / scaleFactor),(int) (height /
	 * scaleFactor),Bitmap.Config.ARGB_8888); Canvas canvas = new
	 * Canvas(overlay); canvas.scale(1 / scaleFactor, 1 / scaleFactor); Paint
	 * paint = new Paint(); paint.setFlags(Paint.FILTER_BITMAP_FLAG);
	 * canvas.drawBitmap(mBitmap, 0, 0, paint);
	 * 
	 * overlay = FastBlur.doBlur(overlay, (int) radius, true); Log.i(TAG,
	 * "blur time is:"+(System.currentTimeMillis() - startMs)); return overlay;
	 * }
	 */

	/*private Animation showAnimation1(final View view, int fromY, int toY) {
		AnimationSet set = new AnimationSet(true);
		TranslateAnimation go = new TranslateAnimation(0, 0, fromY, toY);
		go.setDuration(300);
		TranslateAnimation go1 = new TranslateAnimation(0, 0, -10, 2);
		go1.setDuration(100);
		go1.setStartOffset(250);
		set.addAnimation(go1);
		set.addAnimation(go);

		set.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationStart(Animation animation) {

			}

		});
		return set;
	}*/

	public RelativeLayout layout;
	private RelativeLayout rl_daiban;
	private RelativeLayout rl_index_kehu;
	private RelativeLayout rl_index_zhifu;

	public void showMoreWindow(View anchor, int bottomMargin) {
		layout = (RelativeLayout) LayoutInflater.from(mContext).inflate(
				R.layout.center_music_more_window1, null);
		setContentView(layout);

		ImageView close = (ImageView) layout
				.findViewById(R.id.center_music_window_close);
		rl_daiban = (RelativeLayout) layout.findViewById(R.id.rl_daiban);
		rl_index_kehu = (RelativeLayout) layout.findViewById(R.id.rl_index_kehu);
		rl_index_zhifu = (RelativeLayout) layout.findViewById(R.id.rl_index_zhifu);
		
		rl_daiban.setOnClickListener(this);
		rl_index_kehu.setOnClickListener(this);
		rl_index_zhifu.setOnClickListener(this);
		
		close.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isShowing()) {
					closeAnimation1(layout);
				}
			}

		});

		showAnimation1(layout);
		// setBackgroundDrawable(new BitmapDrawable(mContext.getResources(),
		// blur()));
		setOutsideTouchable(true);
		setFocusable(true);
		showAtLocation(anchor, Gravity.BOTTOM, 0, statusBarHeight);
	}



    private void showAnimation1(final ViewGroup layout){

        ObjectAnimator animator = ObjectAnimator.ofFloat(layout, "translationY",mHeight, 0);
        animator.setDuration(500);


        ObjectAnimator  animator1 = ObjectAnimator.ofFloat(layout, "translationY", 0.0f, 20.0f, 0f);
        animator1.setRepeatCount(3);
        animator1.setDuration(500);

        AnimatorSet set = new AnimatorSet();
        set.play(animator).before(animator1);
        set.start();


    }



    private void closeAnimation1(ViewGroup layout){
        ObjectAnimator animator = ObjectAnimator.ofFloat(layout, "translationY",  0, mHeight);
        animator.setDuration(500);
        animator.start();

        animator.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                dismiss();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.rl_daiban:

			closeAnimation1(layout);
			break;
		case R.id.rl_index_kehu:

			closeAnimation1(layout);
			break;
		case R.id.rl_index_zhifu:

			closeAnimation1(layout);
			break;

		default:
			break;
		}
	}

	public void destroy() {
		if (null != overlay) {
			overlay.recycle();
			overlay = null;
			System.gc();
		}
		if (null != mBitmap) {
			mBitmap.recycle();
			mBitmap = null;
			System.gc();
		}
	}
}
