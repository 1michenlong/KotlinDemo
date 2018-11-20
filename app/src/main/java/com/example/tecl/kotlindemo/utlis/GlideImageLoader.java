package com.example.tecl.kotlindemo.utlis;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tecl.kotlindemo.MyApplication;

import com.youth.banner.loader.ImageLoader;

/**
 * Created by android on 2017/2/14.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(MyApplication.getContext()).load(path).into(imageView);
    }
}
