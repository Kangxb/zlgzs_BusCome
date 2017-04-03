package com.zlgzs.xinhuatong.buscome.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.zlgzs.xinhuatong.buscome.R;
import com.zlgzs.xinhuatong.buscome.manager.IStartManager;
import com.zlgzs.xinhuatong.buscome.manager.StartManager;
import com.zlgzs.xinhuatong.buscome.model.BaseEntity;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class StartActivity extends BaseActivity implements IStartManager {
    private StartManager mStartManager;
    private TextView mVersionTv;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();
    }

    private void init(){
        initData();
        initView();
    }

    private void initView(){
        mVersionTv = (TextView) findViewById(R.id.start_version_tv);
//        mVersionTv.append(" " + ClientUtil.getVersionName(this));
//        if(!DefaultShared.getBoolean(Constants.KEY_IS_FIRST,false)){
//            //TODO 第一次安装显示流量使用提示
//        }
        mStartManager.start();
    }

    private void initData(){
        mContext = this;
        mStartManager = new StartManager(mContext,this);
    }

    @Override
    public void toMainPage() {
        MainActivity.openActivity(this);
        finish();
    }

    @Override
    public void onLoadComplete(BaseEntity baseEntity) {

    }

    @Override
    public void onLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStartManager.cancel();
    }
}
