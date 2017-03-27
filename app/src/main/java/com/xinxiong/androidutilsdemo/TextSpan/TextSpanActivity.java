package com.xinxiong.androidutilsdemo.textspan;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.Toast;

import com.xinxiong.androidutilsdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangxin on 16/12/6.
 */

public class TextSpanActivity extends AppCompatActivity {
    @BindView(R.id.tv_text)
     TextView tv_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textspan);
        ButterKnife.bind(this);
        initView();
    }
    public void initView(){
        //tv_text.setText("lsdfljsdlfjdlsfjlsdkfjdlsjflsdfjldksfjklsdjfdklsjfkldsfjldsfjlsdjflsfjlsdjflsdjfsldfjlsdkfjlskfjksdlfjdksljfdlskjfklsdfjskldfjklsdfjlsjklf");

        SpannableString  spanText = new SpannableString("萝卜白菜的博客 -- http://orgcent.com");
        spanText.setSpan(new ForegroundColorSpan(Color.BLUE), 6,7,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_text.append(spanText);

        Toast.makeText(TextSpanActivity.this,TextSpanActivity.this.getPackageName()+"",Toast.LENGTH_SHORT).show();
    }
}
