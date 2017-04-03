package com.zlgzs.xinhuatong.buscome.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class ToastUtil {

	public static void showLongToast(Context context , String text) {
        Toast.makeText(context ,text , Toast.LENGTH_LONG).show();
	}

	public static void showShortToast(Context context , String text) {
        Toast.makeText(context ,text , Toast.LENGTH_SHORT).show();
	}

}
