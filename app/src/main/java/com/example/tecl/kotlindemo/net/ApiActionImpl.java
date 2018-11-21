package com.example.tecl.kotlindemo.net;

import android.content.Context;
import android.util.Log;

import com.example.tecl.kotlindemo.bean.HomePageLiveData;
import com.example.tecl.kotlindemo.utlis.JsonUtil;
import com.example.tecl.kotlindemo.utlis.SignUtils;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

public class ApiActionImpl implements ApiAction{
    private Context context;

    public ApiActionImpl(Context context) {
        this.context = context;
    }

    @Override
    public void getHomeWorkData(HashMap<String, String> params, final ActionCallbackListener<String> listener) {
        OkHttpUtils
                .post()
                .url(getUrlAndParams("app/index/getIndexData",params))
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailure("请求失败", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        listener.onSuccess(response);
                    }
                });

    }

    @Override
    public void getLiveData(HashMap<String, String> params, final ActionCallbackListener<ArrayList<HomePageLiveData>> listener) {
        OkHttpUtils
                .post()
                .url(getUrlAndParams("app/index/lvb/recommend",params))
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailure("请求失败", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            String result = new JSONObject(response).getString("result");
                            if(result.equals("success")){
                                ArrayList<HomePageLiveData> liveDataList =
                                        JsonUtil.toObject(new JSONObject(response).getJSONArray("data").toString()
                                        ,  new TypeToken<ArrayList<HomePageLiveData>> () {
                                }.getType());
                                listener.onSuccess(liveDataList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    private String getUrlAndParams(String _url,HashMap<String,String> params){
        String url = "https://test-api.yimifudao.com/v2.4/"+_url;

        SimpleDateFormat dt= new SimpleDateFormat("yyyyMMddHHmmss");
//        params.put("token", (null==UserInfo.getUser() || null == UserInfo.getUser().getToken() )?"":UserInfo.getUser().getToken());
        params.put("timestamp", dt.format(System.currentTimeMillis()));
        params.put("apiVersion", "2.7");
        try{
            params.put("sign", SignUtils.createSign(params,true));
        }catch (Exception e){}

        String sParams = "?";
        if (params != null & params.size() > 0) {
            int i = 0;
            int len = params.size();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sParams += entry.getKey() + "=" + entry.getValue();
                i++;
                if (i != len) {
                    sParams += "&";
                }
            }
        }

        Log.e("RequestUrl","网络请求URL："+url+sParams);
        return url;
    }

}
