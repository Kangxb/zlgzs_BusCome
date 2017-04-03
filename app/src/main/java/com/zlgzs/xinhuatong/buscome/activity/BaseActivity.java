package com.zlgzs.xinhuatong.buscome.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.zlgzs.xinhuatong.buscome.R;
import com.zlgzs.xinhuatong.buscome.utils.ToastUtil;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        PushAgent.getInstance(this).onAppStart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void showShortToast(int pResId) {
        showShortToast(getString(pResId));
    }

    protected void showLongToast(String pMsg) {
        ToastUtil.showLongToast(this,pMsg);
    }

    protected void showShortToast(String pMsg) {
        ToastUtil.showShortToast(this,pMsg);
    }

    protected ProgressDialog progressDialog;
    public void showLoadingProgress() {
        showLoadingProgress("");
    }

    public void showLoadingProgress(String hint) {
        progressDialog = new ProgressDialog(this);
        if(!TextUtils.isEmpty(hint)){
            progressDialog.setMessage(hint);
        }else{
            progressDialog.setMessage(getResources().getString(R.string.common_waiting));
        }
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    public void dismissLoadingProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    protected void cancelTask() {
//        if(task != null && !task.isCancelled()) {
//            task.cancel();
//            task = null;
//        }
    }

}
