package com.example.tecl.kotlindemo.utlis;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by 1MI-NO28 on 2017/3/2.
 * Sign算法
 */

public class SignUtils {
    public static String createSign(Map<String, String> params, boolean encode)
            throws UnsupportedEncodingException {
        encode = false;
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuffer temp = new StringBuffer();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            if (encode) {
                temp.append(URLEncoder.encode(valueString, "UTF-8"));
            } else {
                temp.append(valueString);
            }
        }
        Log.e("SignUtils","params = "+temp.toString());
        return MD5.GetMD5Code(temp.toString()).toUpperCase();
    }

    public static String createSignObj(Map<String, Object> params, boolean encode)
            throws UnsupportedEncodingException {
        encode = false;
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuffer temp = new StringBuffer();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            if (encode) {
                temp.append(URLEncoder.encode(valueString, "UTF-8"));
            } else {
                temp.append(valueString);
            }
        }
        String sign=MD5.GetMD5Code(temp.toString()).toUpperCase();
        Log.i("dyc","签名字符串："+temp.toString()+"sign:"+sign);
        return sign;
    }

}
