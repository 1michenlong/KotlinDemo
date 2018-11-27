package com.example.tecl.kotlindemo.popupwindow

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RelativeLayout
import com.example.tecl.kotlindemo.R

class KuPayPopupWindow(private val context: Context) : PopupWindow() {
    private var mFatherRelative:RelativeLayout?=null

    constructor(mContext: Context,name:String) : this(mContext) {
        Log.i("SSSS","constructor")
    }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.kupay_popupwindow, null,false)

        this.width = ViewGroup.LayoutParams.MATCH_PARENT
        this.height = ViewGroup.LayoutParams.WRAP_CONTENT
        this.isFocusable = true
        this.isOutsideTouchable=true
        this.setBackgroundDrawable(BitmapDrawable())
        this.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        this.contentView = view
    }
}
