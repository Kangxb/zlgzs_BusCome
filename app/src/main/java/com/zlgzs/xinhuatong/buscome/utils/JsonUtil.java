package com.zlgzs.xinhuatong.buscome.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

public class JsonUtil {
	private static Gson mGson = new Gson();
	
	public static String parseJsonToString(JsonObject obj, String item){
		
		return obj.has(item)?!obj.get(item).isJsonNull()?obj.get(item).getAsString():"":"";
	}
	
	public static int parseJsonToInt(JsonObject obj, String item){
		return obj.has(item)?!obj.get(item).isJsonNull()?obj.get(item).getAsInt():0:0;
	}
	
	public static synchronized <T> T fromJsonString(String jsonString, TypeToken<T> typeToken) {
		try {
			return (T)mGson.fromJson(jsonString, typeToken.getType());
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static synchronized <T> T fromJsonString(String jsonString, Class<T> objClass) {
		if(!TextUtils.isEmpty(jsonString)){
			try {
				return (T)mGson.fromJson(jsonString, objClass);
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}else{
			return  null;
		}
	}
	
	public static synchronized <T> T fromJsonElement(JsonElement element, Class<T> objClass) {
		try {
			return (T)mGson.fromJson(element, objClass);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static synchronized String toJsonElement(Object objClass) {
        try {
            return mGson.toJson(objClass);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	public static synchronized String getString(String s, String key){
		try {
			JSONObject jsonObject = new JSONObject(s);
			return jsonObject.getString(key);
		} catch (Exception e) {
			return null;
		}
	}

}
