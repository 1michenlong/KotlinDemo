package com.example.tecl.kotlindemo

import android.app.Activity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.tecl.kotlindemo.MyApplication.isTablet
import com.example.tecl.kotlindemo.adapter.LiveRecyclerAdapter
import com.example.tecl.kotlindemo.bean.HomePageInfo
import com.example.tecl.kotlindemo.bean.HomePageLiveData
import com.example.tecl.kotlindemo.net.ActionCallbackListener
import com.example.tecl.kotlindemo.net.ApiActionImpl
import com.example.tecl.kotlindemo.utlis.GlideImageLoader
import com.example.tecl.kotlindemo.utlis.ViewInfoUtils
import com.google.gson.Gson
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.listener.OnBannerClickListener
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import org.json.JSONObject

class HomePageFragment : Activity(){
    //data
    var homePageInfo: HomePageInfo? = null
    var liveDataList : ArrayList<HomePageLiveData>? = null
    //view
    private var mSwipeRefreshLayout: SwipeRefreshLayout? =null
    private var bannerView:Banner? = null
    private var mLiveRecyclerView:RecyclerView? = null
    private var mInformationRecycler:RecyclerView? = null
    private var mLiveRecyclerAdapter : CommonAdapter<HomePageLiveData>? = null
    private var mInformationAdapter : CommonAdapter<HomePageInfo.Items>? = null
    private var recyclerItemImageWidth:Int? = null
    private var recyclerItemImageHeight:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page_fragment)
        mSwipeRefreshLayout=findViewById(R.id.main_swrl)
        bannerView=findViewById(R.id.id_homepage_banner)
        mLiveRecyclerView=findViewById(R.id.id_live_recyclerview)
        mInformationRecycler=findViewById(R.id.id_information_recycler)
        setRecyclerStyle(mLiveRecyclerView)
        setRecyclerStyle(mInformationRecycler)
        getHomeWorkData()
        getLiveData()

        mSwipeRefreshLayout?.setColorSchemeResources(R.color.main_org,R.color.main_org)
        mSwipeRefreshLayout?.setOnRefreshListener {
            getHomeWorkData()
            getLiveData()
        }
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

    fun setRecyclerStyle(mRecyclerView: RecyclerView?){
        recyclerItemImageWidth = if(isTablet(this@HomePageFragment)){//pad
            (MyApplication.getWidth()*0.3).toInt()
        }else{
            (MyApplication.getWidth()*0.66).toInt()
        }
        recyclerItemImageHeight = (recyclerItemImageWidth!! /1.77).toInt()

        var mLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mLayoutManager.orientation=LinearLayoutManager.HORIZONTAL
        mRecyclerView?.layoutManager =mLayoutManager//设置布局管理器
        //设置动画
        mRecyclerView?.itemAnimator = DefaultItemAnimator()
    }

    private fun getHomeWorkData(){
        var hashMap = HashMap<String,String>()
        hashMap["applicationNo"] = "40619"

        var api = ApiActionImpl(this@HomePageFragment)
        api.getHomeWorkData(hashMap,object : ActionCallbackListener<String>{
            override fun onSuccess(data: String?) {
                var result = JSONObject(data).getString("result")
                if(result=="success"){
                    homePageInfo=Gson().fromJson(JSONObject(data).getJSONObject("data").toString(),HomePageInfo::class.java)
                    setBanner()

                    if(null==mInformationAdapter){
                        mInformationAdapter = object:CommonAdapter<HomePageInfo.Items>(this@HomePageFragment,
                                R.layout.homepage_info_recycler_adapter, homePageInfo?.active?.items){
                            override fun convert(holder: ViewHolder?, t: HomePageInfo.Items?, position: Int) {
                                var image = holder?.getView<ImageView>(R.id.id_image)
                                var priceText = holder?.getView<TextView>(R.id.id_price_text)
                                var viewLine = holder?.getView<View>(R.id.id_gray_line)
                                var numText = holder?.getView<TextView>(R.id.id_bottom_text)
                                holder?.setText(R.id.id_live_title,t?.title)
                                priceText?.visibility= View.GONE
                                viewLine?.visibility= View.GONE
                                numText?.visibility= View.GONE
                                if (image != null) {
                                    ViewInfoUtils.getInstance().setViewSize(image, recyclerItemImageWidth!!,recyclerItemImageHeight!!)
                                    Glide.with(this@HomePageFragment).load(t?.linkImage).into(image)
                                }
                            }
                        }
                        mInformationRecycler?.adapter =mInformationAdapter
                    }else{
                        mInformationAdapter?.notifyDataSetChanged()
                    }

                    mSwipeRefreshLayout!!.isRefreshing = false//取消刷新
                }
            }
            override fun onFailure(errorEvent: String?, message: String?) {
            }
        })
    }

    private fun getLiveData(){
        var api = ApiActionImpl(this@HomePageFragment)
        api.getLiveData(HashMap<String,String>(),object : ActionCallbackListener<ArrayList<HomePageLiveData>>{
            override fun onSuccess(data: ArrayList<HomePageLiveData>?) {
                liveDataList=data
                if(null==mLiveRecyclerAdapter){
                    mLiveRecyclerAdapter=object : LiveRecyclerAdapter(this@HomePageFragment,
                            R.layout.homepage_info_recycler_adapter,liveDataList,recyclerItemImageWidth!!,recyclerItemImageHeight!!){}
                    mLiveRecyclerView?.adapter=mLiveRecyclerAdapter
                }else{
                    mLiveRecyclerAdapter?.notifyDataSetChanged()
                }

            }

            override fun onFailure(errorEvent: String?, message: String?) {

            }

        })
    }
}