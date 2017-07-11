package com.xinxiong.androidutilsdemo.EditTextActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.ClipboardManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 自定义的textview，用来处理复制粘贴的消息
 * 
 */
public class PasteEditText extends AppCompatEditText {
	private Context context;

	public PasteEditText(Context context) {
		super(context);
		this.context = context;
	}

	public PasteEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	public PasteEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onTextContextMenuItem(int id) {
		if (id == android.R.id.paste) {
			ClipboardManager clip = (ClipboardManager) getContext()
					.getSystemService(Context.CLIPBOARD_SERVICE);
			if (clip == null || clip.getText() == null) {
				return false;
			}
			String text = clip.getText().toString();
			if (text.startsWith(Constants.Chat.COPY_IMAGE)) {
				// intent.setDataAndType(Uri.fromFile(new
				// File("/sdcard/mn1.jpg")), "image/*");
				text = text.replace(Constants.Chat.COPY_IMAGE, "");
				Intent intent = new Intent(context, AlertDialog.class);
				String str = "发送以下图片？";
				intent.putExtra("title", str);
				intent.putExtra("forwardImage", text);
				intent.putExtra("cancel", true);
				((Activity) context).startActivityForResult(intent,
						Constants.Chat.REQUEST_CODE_COPY_AND_PASTE);
				// clip.setText("");
			}
		}
		return super.onTextContextMenuItem(id);
	}

	@Override
	protected void onTextChanged(CharSequence text, int start,
								 int lengthBefore, int lengthAfter) {
		if (!TextUtils.isEmpty(text)
				&& text.toString().startsWith(Constants.Chat.COPY_IMAGE)) {
			setText("");
		}
		// else if(!TextUtils.isEmpty(text)){
		// setText(SmileUtils.getSmiledText(getContext(),
		// text),BufferType.SPANNABLE);
		// }
		super.onTextChanged(text, start, lengthBefore, lengthAfter);
	}
	@Override
	public void setText(CharSequence text, BufferType type) {
		if (!TextUtils.isEmpty(text)) {
			super.setText(replace(text.toString()), type);
		} else {
			super.setText(text, type);
		}
	}

	private Pattern buildPattern() {
		return Pattern.compile("\\\\ue[a-z0-9]{3}", Pattern.CASE_INSENSITIVE);
	}

	private CharSequence replace(String text) {
		try {
			SpannableString spannableString = new SpannableString(text);
			int start = 0;
			Pattern pattern = buildPattern();
			Matcher matcher = pattern.matcher(text);
			while (matcher.find()) {
				String faceText = matcher.group();
				String key = faceText.substring(1);
				BitmapFactory.Options options = new BitmapFactory.Options();
				Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(),
						getContext().getResources().getIdentifier(key, "drawable", getContext().getPackageName()), options);
				ImageSpan imageSpan = new ImageSpan(getContext(), bitmap);
				int startIndex = text.indexOf(faceText, start);
				int endIndex = startIndex + faceText.length();
				if (startIndex >= 0)
					spannableString.setSpan(imageSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				start = (endIndex - 1);
			}
			return spannableString;
		} catch (Exception e) {
			return text;
		}
	}
}
