package com.zlgzs.xinhuatong.buscome.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.SyncStateContract;

import com.zlgzs.xinhuatong.buscome.model.BaseEntity;
import com.zlgzs.xinhuatong.buscome.utils.DefaultShared;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class StartManager extends BaseManager {

    private Context mContext;
    private IStartManager mIStartManager;
    private Timer mTimer;
    private static final long TIME_OVER = 1;
    private Handler mHandler;
    private Call<BaseEntity> mCall;
    private boolean mIsCancelTimer = false;

    public StartManager(Context context, IStartManager iStartManager) {
        mContext = context;
        mIStartManager = iStartManager;
        mHandler = new Handler(Looper.getMainLooper());
        handleVersionCode();

    }

    /**
     * 处理版本信息
     */
    private void handleVersionCode() {
//
//        //获取手机上次运行的版本号
//        int preVersionCode = DefaultShared.getInt(SyncStateContract.Constants.KEY_VERSION_CODE, 0);
//
//        //获取本次运行包的版本号
//        int curVersionCode = ClientUtil.getVersionCode(mContext);
//        // 保存本次运行包的版本号
//        DefaultShared.putInt(SyncStateContract.Constants.KEY_VERSION_CODE, curVersionCode);
//
//        if(curVersionCode > preVersionCode){
//            /**
//             * 版本更新
//             */
//        }
    }

    public void start() {
        mIStartManager.onLoading();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        cancelLoadTask();
                        mIStartManager.toMainPage();
                    }
                });
            }
        };
        mTimer = new Timer();
        mTimer.schedule(task,TIME_OVER);
    }

    private void loadConfig(){
//        Map<String,String> params = new HashMap<>();
//
//        mCall = RetrofitService.createDefaultService(FootballAppApi.class).loadConfig(params);
//        mCall.enqueue(new Callback<BaseEntity>() {
//            @Override
//            public void onResponse(Call<BaseEntity> call, Response<BaseEntity> response) {
//                mIStartManager.toMainPage();
//                cancelTimerTask();
//            }
//
//            @Override
//            public void onFailure(Call<BaseEntity> call, Throwable t) {
//                mIStartManager.toMainPage();
//                cancelTimerTask();
//            }
//        });
    }

    private void cancelLoadTask(){
        if(mCall!=null
                &&!mCall.isCanceled()){
            mCall.cancel();
        }
    }

    private void cancelTimerTask(){
        if(mTimer!=null && !mIsCancelTimer){
            mIsCancelTimer = true;
            mTimer.cancel();
        }
    }

    @Override
    public void cancel() {
        super.cancel();
        cancelTimerTask();
        cancelLoadTask();
    }
}
