package com.example.tecl.kotlindemo;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

public class MyApplication extends Application{
    private static Context context;
    private static int width;
    private static int height;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        DisplayMetrics dm = getResources().getDisplayMetrics();
        height = dm.heightPixels;
        width = dm.widthPixels;
    }

    public static Context getContext(){
        return context;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
