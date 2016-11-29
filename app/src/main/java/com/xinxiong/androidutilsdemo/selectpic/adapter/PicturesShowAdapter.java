package com.xinxiong.androidutilsdemo.selectpic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xinxiong.androidutilsdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxin on 16/11/29.
 */

public class PicturesShowAdapter extends RecyclerView.Adapter<PicturesShowAdapter.MyViewHolder>{

    private Context mContext;
    private List<String> mPicList=new ArrayList<>();
    public PicturesShowAdapter(Context context){
        mContext=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.selectpic_item_recyclerview, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mPicList.get(position))
                .into(holder.iv);
    }
    @Override
    public int getItemCount() {
        return mPicList==null ? 0:mPicList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView iv;

        public MyViewHolder(View view)
        {
            super(view);
            iv = (ImageView) view.findViewById(R.id.iv_pic);
        }
    }
    public void setPicList(List<String> picList){
        mPicList=picList;
    }
}
