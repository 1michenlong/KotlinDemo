package com.example.tecl.kotlindemo.net;

import java.util.HashMap;
import java.util.List;

public interface ApiAction {
    /**
     * 获取首页数据
     */
    void getHomeWorkData(HashMap<String, String> params, ActionCallbackListener<String> listener);
}
