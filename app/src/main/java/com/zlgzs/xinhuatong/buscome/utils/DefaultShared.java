package com.zlgzs.xinhuatong.buscome.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.zlgzs.xinhuatong.buscome.MyApplication;

import java.util.Map;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public final class DefaultShared {

	private static final SharedPreferences spf = MyApplication.mApp.getBaseContext().getSharedPreferences("zlgzs", 0);

	public static void putBoolean(String key, boolean value) {
		spf.edit().putBoolean(key, value).commit();
	}

	public static void remove(String key) {
		spf.edit().remove(key).commit();
	}

	public static void putFloat(String key, float value) {
		spf.edit().putFloat(key, value).commit();
	}

	public static void putInt(String key, int value) {
		spf.edit().putInt(key, value).commit();
	}

	public static void putLong(String key, long value) {
		spf.edit().putLong(key, value).commit();
	}

	public static void putString(String key, String value) {
		spf.edit().putString(key, value).commit();
	}
	
	/**
	 * SharedPreferences支持数据类型
	 * @param params
	 */
	public static void putMap(Map<String,?> params)
	{
		if(params == null || params.size() == 0)
			return;
		Editor edit = spf.edit();
		for(Map.Entry<String, ?> entry : params.entrySet())
		{
			if(entry.getValue() instanceof Boolean)
			{
				edit.putBoolean(entry.getKey(), (Boolean)entry.getValue());
			}else if(entry.getValue() instanceof Float)
			{
				edit.putFloat(entry.getKey(), (Float)entry.getValue());
			}else if(entry.getValue() instanceof Integer)
			{
				edit.putInt(entry.getKey(), (Integer)entry.getValue());
			}else if(entry.getValue() instanceof Long)
			{
				edit.putLong(entry.getKey(), (Long)entry.getValue());
			}else if(entry.getValue() instanceof String)
			{
				edit.putString(entry.getKey(), (String)entry.getValue());
			}
		}
		edit.commit();
	}

	public static boolean getBoolean(String key, boolean defValue) {
		return spf.getBoolean(key, defValue);
	}

	public static float getFloat(String key, float defValue) {

		return spf.getFloat(key, defValue);
	}

	public static int getInt(String key, int defValue) {
		return spf.getInt(key, defValue);
	}

	public static long getLong(String key, long defValue) {
		return spf.getLong(key, defValue);
	}

	public static String getString(String key, String defValue) {
		return spf.getString(key, defValue);
	}
	
	
	public static boolean isContainKey(String key){
		return spf.contains(key);
	}
}