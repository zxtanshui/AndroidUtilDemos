package com.xinxiong.androidutilsdemo.morewidow;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.xinxiong.androidutilsdemo.R;

public class MoreWindow extends PopupWindow implements OnClickListener {

	private String TAG = MoreWindow.class.getSimpleName();
	Activity mContext;
	private int mWidth;
	private int mHeight;
	private int statusBarHeight;
	private Bitmap mBitmap = null;
	private Bitmap overlay = null;

	private Handler mHandler = new Handler();

	public MoreWindow(Activity context) {
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
				R.layout.center_music_more_window, null);
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
					closeAnimation(layout);
				}
			}

		});

		showAnimation(layout);
		// setBackgroundDrawable(new BitmapDrawable(mContext.getResources(),
		// blur()));
		setOutsideTouchable(true);
		setFocusable(true);
		showAtLocation(anchor, Gravity.BOTTOM, 0, statusBarHeight);
	}

	private void showAnimation(ViewGroup layout) {
		for (int i = 0; i < layout.getChildCount(); i++) {
			final View child = layout.getChildAt(i);
			if (child.getId() == R.id.center_music_window_close) {
				continue;
			}
			child.setOnClickListener(this);
			child.setVisibility(View.INVISIBLE);
			mHandler.postDelayed(new Runnable() {

				@Override
				public void run() {
					child.setVisibility(View.VISIBLE);
					ValueAnimator fadeAnim = ObjectAnimator.ofFloat(child,
							"translationY", 600, 0);
					fadeAnim.setDuration(300);
					KickBackAnimator kickAnimator = new KickBackAnimator();
					kickAnimator.setDuration(150);
					fadeAnim.setEvaluator(kickAnimator);
					fadeAnim.start();
				}
			}, i * 50);
		}

	}

	private void closeAnimation(ViewGroup layout) {
		for (int i = 0; i < layout.getChildCount(); i++) {
			final View child = layout.getChildAt(i);
			/*
			 * if(child.getId() == R.id.center_music_window_close){ continue; }
			 */
			//child.setOnClickListener(this);
			mHandler.postDelayed(new Runnable() {

				@Override
				public void run() {
					child.setVisibility(View.VISIBLE);
					ValueAnimator fadeAnim = ObjectAnimator.ofFloat(child,
							"translationY", 0, mHeight/2+75);
					fadeAnim.setDuration(300);
					KickBackAnimator kickAnimator = new KickBackAnimator();
					kickAnimator.setDuration(100);
					fadeAnim.setEvaluator(kickAnimator);
					fadeAnim.start();
					fadeAnim.addListener(new AnimatorListener() {

						@Override
						public void onAnimationStart(Animator animation) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onAnimationRepeat(Animator animation) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onAnimationEnd(Animator animation) {
							child.setVisibility(View.INVISIBLE);
							dismiss();
						}

						@Override
						public void onAnimationCancel(Animator animation) {
							// TODO Auto-generated method stub

						}
					});
				}
			}, (layout.getChildCount() - i - 1) * 50);

			/*if (child.getId() == R.id.center_music_window_close) {
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						dismiss();
					}
				}, (layout.getChildCount() - i) * 30 + 80);
			}*/
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.rl_daiban:

			closeAnimation(layout);
			break;
		case R.id.rl_index_kehu:

			closeAnimation(layout);
			break;
		case R.id.rl_index_zhifu:

			closeAnimation(layout);
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
