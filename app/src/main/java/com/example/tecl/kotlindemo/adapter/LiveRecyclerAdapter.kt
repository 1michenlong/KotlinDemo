package com.example.tecl.kotlindemo.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.tecl.kotlindemo.R
import com.example.tecl.kotlindemo.bean.HomePageLiveData
import com.example.tecl.kotlindemo.utlis.ViewInfoUtils
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import kotlin.collections.ArrayList

open class LiveRecyclerAdapter (private val context: Context, layoutId: Int, datas: ArrayList<HomePageLiveData>?,
                                private val width:Int,private val height:Int)
    : CommonAdapter<HomePageLiveData>(context, layoutId, datas) {

    override fun convert(holder: ViewHolder?, t: HomePageLiveData?, position: Int) {
        var image = holder?.getView<ImageView>(R.id.id_image)
        var priceText = holder?.getView<TextView>(R.id.id_price_text)
        var numText = holder?.getView<TextView>(R.id.id_bottom_text)
        var liveTitle = holder?.getView<TextView>(R.id.id_live_title)

        liveTitle?.text=t?.lessonName
        priceText?.text=if(t?.price==0)  "免费" else t?.price.toString()
        numText?.text=t?.payCount.toString()+"人已报名"

        if (image != null) {
            ViewInfoUtils.getInstance().setViewSize(image, width,height)
            Glide.with(context).load(t?.img).into(image)
        }
    }
}
