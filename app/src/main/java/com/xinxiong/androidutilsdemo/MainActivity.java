package com.xinxiong.androidutilsdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xinxiong.androidutilsdemo.ActionSheetDialog.DialogActivity;
import com.xinxiong.androidutilsdemo.EditTextActivity.EditTestActivity;
import com.xinxiong.androidutilsdemo.codeutils.CodeUtils;
import com.xinxiong.androidutilsdemo.linechat.SimpleLineChart;
import com.xinxiong.androidutilsdemo.mediaplay.MediaPlayDemo;
import com.xinxiong.androidutilsdemo.morewindow1.MoreWindow1;
import com.xinxiong.androidutilsdemo.progressbardialog.ProgressBarDialogActivity;
import com.xinxiong.androidutilsdemo.textspan.TextSpanActivity;
import com.xinxiong.androidutilsdemo.morewidow.MoreWindow;
import com.xinxiong.androidutilsdemo.roundprogressbar.RoundRrogressBarActivity;
import com.xinxiong.androidutilsdemo.selectpic.ShowSelectPicActivity;
import com.xinxiong.androidutilsdemo.utils.DeviceUtils;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.tv_morewindow)
     TextView tv_morewindow;
    @BindView(R.id.tv_roundprogressbar)
     TextView tv_roundprogressbar;

    @BindView(R.id.tv_select_pictures)
    TextView tv_select_pictures;
    @BindView(R.id.tv_textspan)
    TextView tv_textspan;
    @BindView(R.id.tv_morewindow1)
    TextView tv_morewindow1;
    private Context mContext;
    MoreWindow mMoreWindow;
    MoreWindow1 mMoreWindow1;
    @BindView(R.id.tv_progressbar)
    TextView tv_progressbar;
    @BindView(R.id.tv_edittext)
    TextView tv_edittext;
    @BindView(R.id.tv_mediaplay)
    TextView tv_mediaplay;
    @BindView(R.id.tv_dialogshow)
    TextView tv_dialogshow;
    @BindView(R.id.rl_click)
    RelativeLayout rl_click;
    @BindView(R.id.tv_show_man)
    TextView tv_show_man;
    @BindView(R.id.et_test)
    EditText et_test;
    @BindView(R.id.btn_clk)
    Button btn_clk;
    @BindView(R.id.iv_show)
    ImageView iv_show;
    @BindView(R.id.btn_code)
    Button btn_code;
    @BindView(R.id.btn_line)
    Button btn_line;
    @BindView(R.id.simpleLineChart)
    SimpleLineChart mSimpleLineChart;
    private String TAG="MainActivity";
    String[] xItem = {"1","2","3","4","5","6","7"};
    String[] yItem = {"10k","20k","30k","40k","50k"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext=MainActivity.this;
        initView();
        initLine();
        String s="/storage/emulated/0/upload_/jyall1484225014924.jpg";
        //Glide.with(mContext).load(s).into(iv);
//
//        Glide.with(mContext)
//                .load(s)
//                .asBitmap()
//                //.override(resultWidth, resultHeight)
//                .fitCenter()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//               // .placeholder(defDrawId)
//                .thumbnail(1f)
//              //  .error(defDrawId)
////                .transform(new BitmapTransformation(mContext, 10f))
//                .into(iv);
    }

    public void initView(){

        tv_morewindow.setOnClickListener(this);
        tv_roundprogressbar.setOnClickListener(this);
        tv_select_pictures.setOnClickListener(this);
        tv_textspan.setOnClickListener(this);
        tv_morewindow1.setOnClickListener(this);
        tv_progressbar.setOnClickListener(this);
        tv_edittext.setOnClickListener(this);
        tv_mediaplay.setOnClickListener(this);
        tv_dialogshow.setOnClickListener(this);
        btn_clk.setOnClickListener(this);
        btn_code.setOnClickListener(this);
        btn_line.setOnClickListener(this);
        rl_click.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext,"长安了",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        tv_show_man.setOnClickListener(this);
        et_test.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e(TAG,"s-->"+s+" start-->"+start+" count-->"+count+" after-->"+after);
                if(start==0){
                    return;
                }
                Log.e(TAG,"s-----"+s.toString().substring(start,start+count));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e(TAG,"s-->"+s+" start-->"+start+" before-->"+before+" count-->"+count);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void test(){
        AsyncTask asyncTask=new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                publishProgress();
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
            }

            @Override
            protected void onProgressUpdate(Object[] values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled(Object o) {
                super.onCancelled(o);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        };
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.tv_morewindow:
                showMoreWindow(tv_morewindow);
                break;

            case R.id.tv_roundprogressbar:
                 intent=new Intent(mContext, RoundRrogressBarActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_select_pictures:
                 intent=new Intent(mContext, ShowSelectPicActivity.class);
                 startActivity(intent);
                break;
            case R.id.tv_textspan:
                intent=new Intent(mContext, TextSpanActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_morewindow1:
                showMoreWindow1(tv_morewindow1);
                break;
            case R.id.tv_progressbar:
                intent=new Intent(mContext, ProgressBarDialogActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_edittext:
                intent=new Intent(mContext, EditTestActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_mediaplay:
                intent=new Intent(mContext, MediaPlayDemo.class);
                startActivity(intent);
                break;
            case R.id.tv_dialogshow:
                intent=new Intent(mContext, DialogActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_show_man:
                //Toast.makeText(mContext, DeviceUtils.getManufacturer()+"     "+DeviceUtils.getDeviceModel(),Toast.LENGTH_SHORT).show();
                Log.e(TAG,DeviceUtils.getManufacturer()+"   "+DeviceUtils.getDeviceModel());
                break;
            case R.id.btn_clk:
                SimpleDateFormat myFmt1=new SimpleDateFormat("hh:mm:ss");
                Toast.makeText(mContext, myFmt1.format(new Date()),Toast.LENGTH_SHORT).show();
                Log.e(TAG,new Date().toString());
                break;
            case R.id.btn_code:
                //iv_show.setBackground(CodeUtils.getInstance().createBitmap());
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                CodeUtils.getInstance().createBitmap().compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] bytes=baos.toByteArray();

                Glide.with(mContext)
                        .load(bytes)
                        .into(iv_show);
                Toast.makeText(mContext,CodeUtils.getInstance().getCode(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_line:
                HashMap<Integer,Integer> pointMap = new HashMap();
                for(int i = 0;i<xItem.length;i++){
                    pointMap.put(i, (int) (Math.random()*5));
                }
                mSimpleLineChart.setData(pointMap);

                break;
        }
    }


    private void showMoreWindow(View view) {
        if (null == mMoreWindow) {
            mMoreWindow = new MoreWindow(this);
            mMoreWindow.init();
        }
        mMoreWindow.showMoreWindow(view, 100);
    }
    private void showMoreWindow1(View view) {
        if (null == mMoreWindow) {
            mMoreWindow1 = new MoreWindow1(this);
            mMoreWindow1.init();
        }
        mMoreWindow1.showMoreWindow(view, 100);
    }

    public void Demo(){
        aa();
        boolean b;
        Object o;
    }

    private void aa() {
        int a;
        ArrayList<String> list=new ArrayList<>();
    }

    /** 获取厂商信息 */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 获得设备型号
     *
     * @return
     */
    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public void initLine(){

        if(mSimpleLineChart == null)
            Log.e("wing","null!!!!");
        mSimpleLineChart.setXItem(xItem);
        mSimpleLineChart.setYItem(yItem);
        HashMap<Integer,Integer> pointMap = new HashMap();
        for(int i = 0;i<xItem.length;i++){
            pointMap.put(i, (int) (Math.random()*5));
        }
        mSimpleLineChart.setData(pointMap);
    }
}
