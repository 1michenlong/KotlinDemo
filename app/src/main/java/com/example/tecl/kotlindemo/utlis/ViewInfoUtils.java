package com.example.tecl.kotlindemo.utlis;

import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by android on 2017/2/17.
 */

public class ViewInfoUtils {

    private static ViewInfoUtils mViewInfoUtils;

    public static ViewInfoUtils getInstance() {
        if (mViewInfoUtils == null) {
            synchronized (ViewInfoUtils.class) {
                if (mViewInfoUtils == null) {
                    mViewInfoUtils = new ViewInfoUtils();
                }
            }
        }
        return mViewInfoUtils;
    }

    /**
     * 获取控件宽度
     */
    public int getViewWidth(View view){
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        return view.getMeasuredWidth();
    }

    /**
     * 获取控件高度
     */
    public int getViewHeight(View view){
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        return view.getMeasuredHeight();
    }

    /**
     * 设置控件宽高
     * @param w
     * @param h
     */
    public void setViewSize(View view, int w, int h){
        LinearLayout.LayoutParams linearParams1 =(LinearLayout.LayoutParams) view.getLayoutParams();
        if(h!=0){
            linearParams1.height = h;
        }

        if(w!=0){
            linearParams1.width = w;
        }
        view.setLayoutParams(linearParams1);
    }

    /**
     * 设置控件宽高
     * @param w
     * @param h
     */
    public void setViewSizeRelative(View view, int w, int h){
        RelativeLayout.LayoutParams linearParams1 =(RelativeLayout.LayoutParams) view.getLayoutParams();
        if(h!=0){
            linearParams1.height = h;
        }

        if(w!=0){
            linearParams1.width = w;
        }
        view.setLayoutParams(linearParams1);
    }

    /**
     * 设置控件宽高
     * @param w
     * @param h
     */
    public void setViewSizeonFrame(View view, int w, int h){
        FrameLayout.LayoutParams linearParams1 =(FrameLayout.LayoutParams) view.getLayoutParams();
        if(h!=0){
            linearParams1.height = h;
        }

        if(w!=0){
            linearParams1.width = w;
            linearParams1.gravity= Gravity.RIGHT;
        }
        view.setLayoutParams(linearParams1);
    }
}
