package com.example.tecl.kotlindemo.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


import com.example.tecl.kotlindemo.R;

import java.lang.ref.WeakReference;

/**
 * Created by cyandev on 2016/12/14.
 *
 * onInterceptTouchEvent()：是否拦截触摸事件
     onTouchEvent()：处理触摸事件
     layoutDependsOn()：确定使用Behavior的View要依赖的View的类型
     onDependentViewChanged()：当被依赖的View状态改变时回调
     onDependentViewRemoved()：当被依赖的View移除时回调
     onMeasureChild()：测量使用Behavior的View尺寸
     onLayoutChild()：确定使用Behavior的View位置
     onStartNestedScroll()：嵌套滑动开始（ACTION_DOWN），确定Behavior是否要监听此次事件
     onStopNestedScroll()：嵌套滑动结束（ACTION_UP或ACTION_CANCEL）
     onNestedScroll()：嵌套滑动进行中，要监听的子 View的滑动事件已经被消费
     onNestedPreScroll()：嵌套滑动进行中，要监听的子 View将要滑动，滑动事件即将被消费（但最终被谁消费，可以通过代码控制）
     onNestedFling()：要监听的子 View在快速滑动中
     onNestedPreFling()：要监听的子View即将快速滑动
 */

public class HeaderFloatBehavior extends CoordinatorLayout.Behavior<View> {

    private WeakReference<View> dependentView;
    private ArgbEvaluator argbEvaluator;

    public HeaderFloatBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

        argbEvaluator = new ArgbEvaluator();
    }

    //确定使用Behavior的View要依赖的View的类型
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        if (dependency != null && dependency.getId() == R.id.scrolling_header) {
            dependentView = new WeakReference<>(dependency);
            return true;
        }
        return false;
    }

    //当被依赖的View状态改变时回调
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Resources resources = getDependentView().getResources();
        final float progress = 1.f -
                Math.abs(dependency.getTranslationY() / (dependency.getHeight() - resources.getDimension(R.dimen.collapsed_header_height)));

        Log.i("SSSS","progress=="+progress);
        // Translation
        final float collapsedOffset = resources.getDimension(R.dimen.collapsed_float_offset_y);
        final float initOffset = resources.getDimension(R.dimen.init_float_offset_y);
        final float translateY = collapsedOffset + (initOffset - collapsedOffset) * progress;
        child.setTranslationY(translateY);

        // Background
        child.setBackgroundColor((int) argbEvaluator.evaluate(
                progress,
                resources.getColor(R.color.colorCollapsedFloatBackground),
                resources.getColor(R.color.colorInitFloatBackground)));

        // Margins
        final float collapsedMargin = resources.getDimension(R.dimen.collapsed_float_margin);
        final float initMargin = resources.getDimension(R.dimen.init_float_margin);
        final int margin = (int) (collapsedMargin + (initMargin - collapsedMargin) * progress);
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.setMargins(margin, 0, margin, 0);
        child.setLayoutParams(lp);

        return true;
    }

    private View getDependentView() {
        return dependentView.get();
    }

}
