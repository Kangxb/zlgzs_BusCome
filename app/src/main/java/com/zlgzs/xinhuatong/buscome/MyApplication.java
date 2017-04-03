package com.zlgzs.xinhuatong.buscome;

import android.app.Application;

import com.zlgzs.xinhuatong.buscome.utils.ConfigManager;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class MyApplication extends Application {

    public static MyApplication mApp;
    private static final String TAG = MyApplication.class.getSimpleName();
    private CustomExceptionHandler mCustomExceptionHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
//        mCustomExceptionHandler = new CustomExceptionHandler();
//        setDefaultUncaughtException();

    }

    /**
     * 设置异常捕获
     */
    private void setDefaultUncaughtException(){
        if(ConfigManager.DEBUG_SWITCH){
            Thread.setDefaultUncaughtExceptionHandler(mCustomExceptionHandler);
        }
    }

    /**
     * 打印日志
     */
    static class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {

        private Thread.UncaughtExceptionHandler defaultUEH;

        public CustomExceptionHandler() {
            defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        }

        public void uncaughtException(Thread t, Throwable e) {
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String stacktrace = result.toString();
            printWriter.close();
            defaultUEH.uncaughtException(t, e);
        }
    }
}
