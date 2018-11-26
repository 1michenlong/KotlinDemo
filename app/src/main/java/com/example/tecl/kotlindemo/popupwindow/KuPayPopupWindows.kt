package com.example.tecl.kotlindemo.popupwindow

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow

import com.example.tecl.kotlindemo.R

class KuPayPopupWindows(private val context: Context) : PopupWindow() {

    init {
        initView()
    }

    private fun initView() {
        val view = LayoutInflater.from(context).inflate(R.layout.kupay_popupwindow, null, false)

        this.width = ViewGroup.LayoutParams.MATCH_PARENT
        this.height = ViewGroup.LayoutParams.WRAP_CONTENT
        //        this.setFocusable(true);
        //        this.setBackgroundDrawable(new BitmapDrawable());
        //        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        this.contentView = view
    }

    companion object {
        val ASA = 1
        val ADF = 2
        val DEA = 3
    }
}
