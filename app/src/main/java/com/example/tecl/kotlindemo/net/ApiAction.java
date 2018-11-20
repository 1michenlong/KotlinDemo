package com.example.tecl.kotlindemo.net;

import com.example.tecl.kotlindemo.bean.HomePageLiveData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ApiAction {
    /**
     * 获取首页数据
     */
    void getHomeWorkData(HashMap<String, String> params, ActionCallbackListener<String> listener);
    /**
     * 获取首页直播数据
     */
    void getLiveData(HashMap<String, String> params, ActionCallbackListener<ArrayList<HomePageLiveData>> listener);
}
