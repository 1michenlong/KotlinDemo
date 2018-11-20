package com.example.tecl.kotlindemo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.example.tecl.kotlindemo.R.layout.banner
import com.example.tecl.kotlindemo.bean.HomePageInfo
import com.example.tecl.kotlindemo.net.ActionCallbackListener
import com.example.tecl.kotlindemo.net.ApiActionImpl
import com.example.tecl.kotlindemo.utlis.GlideImageLoader
import com.example.tecl.kotlindemo.utlis.ViewInfoUtils
import com.google.gson.Gson
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.listener.OnBannerClickListener
import org.json.JSONObject

class HomePageFragment : Activity(){
    var homePageInfo: HomePageInfo? = null
    private var bannerView:Banner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page_fragment)
        bannerView=findViewById(R.id.id_homepage_banner)
        getHomeWorkData()
    }

    private fun setBanner(){
        var mBannerList = ArrayList<String>()
        for(i in homePageInfo?.banners?.indices!!){
            mBannerList.add(homePageInfo!!.banners[i].linkImage.toString())
        }

        ViewInfoUtils.getInstance().setViewSize(bannerView,0,(MyApplication.getWidth()/ 2.5).toInt())
        //设置banner样式
        bannerView?.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        //设置图片加载器
        bannerView?.setImageLoader(GlideImageLoader())
        //设置图片集合
        bannerView?.setImages(mBannerList)
        //设置banner动画效果
        bannerView?.setBannerAnimation(Transformer.Default)
        //设置自动轮播，默认为true
        bannerView?.isAutoPlay(true)
        //设置轮播时间
        bannerView?.setDelayTime(3000)
        //设置指示器位置（当banner模式中有指示器时）
        bannerView?.setIndicatorGravity(BannerConfig.RIGHT)
        //banner设置方法全部调用完毕时最后调用
        bannerView?.start()

        bannerView?.setOnBannerClickListener(object:OnBannerClickListener{
            override fun OnBannerClick(position: Int) {
                Log.i("SSSS","banner.geti=="+position)
            }

        })
    }

    private fun getHomeWorkData(){
        var hashMap = HashMap<String,String>()
        hashMap["applicationNo"] = "40619"

        var api = ApiActionImpl(this@HomePageFragment)
        api.getHomeWorkData(hashMap,object : ActionCallbackListener<String>{
            override fun onSuccess(data: String?) {
                var result = JSONObject(data).getString("result")
                if(result=="success"){
                    Log.i("SSSS","data=="+JSONObject(data).getJSONObject("data"))
                    homePageInfo=Gson().fromJson(JSONObject(data).getJSONObject("data").toString(),HomePageInfo::class.java)
                    setBanner()
                }
            }

            override fun onFailure(errorEvent: String?, message: String?) {
                Log.i("SSSS","message=="+message)
            }

        })
    }
}