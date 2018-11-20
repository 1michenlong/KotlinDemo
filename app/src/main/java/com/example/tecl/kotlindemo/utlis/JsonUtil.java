package com.example.tecl.kotlindemo.utlis;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonUtil {
	private static Gson gson = new Gson();
	/**
	 * 将对象或集合或数组转化为json
	 * 
	 * @param
	 * @return
	 */
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	/**
	 * 将json转为特定格式
	 *
	 * @param <T>
	 * @return
	 * 集合Type为
	 * new TypeToken<List<>>(){}.getType()
	 */
	public static <T> T toObject(String json, Type objType) {

		try {
			return gson.fromJson(json, objType);
		} catch (Exception ex) {
			Log.e("json","json转换异常："+ex.getMessage());
		}
		return null;
	}

	/**
	 *
	 * 函数名称: parseData 函数描述: 将json字符串转换为map
	 *
	 * @param json
	 * @return
	 */
	public static HashMap<String, String> parseData(String json) {
		GsonBuilder gb = new GsonBuilder();
		Gson g = gb.create();
		HashMap<String, String> map = g.fromJson(json, new TypeToken<HashMap<String, String>>() {
		}.getType());
		return map;
	}
	public static <T> List<T> getListInfo(String jsonStr, Type objType) {
		return gson.fromJson(jsonStr, objType);
	}

	public static <T> ArrayList<T> getArrayListInfo(String jsonStr, Type objType) {
		return gson.fromJson(jsonStr, objType);
	}

	public static Gson getGson() {
		return gson;
	}

}
