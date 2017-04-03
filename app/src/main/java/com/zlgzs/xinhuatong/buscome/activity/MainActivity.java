package com.zlgzs.xinhuatong.buscome.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zlgzs.xinhuatong.buscome.R;
import com.zlgzs.xinhuatong.buscome.adapter.MainViewPagerAdapter;
import com.zlgzs.xinhuatong.buscome.widget.MainBottomView;
import com.zlgzs.xinhuatong.buscome.widget.ToolBarView;

/**
 * 类说明：   
 * @author kangxb
 * @date 2017/4/3
 * @version 1.0
 * @modfiy
 */

public class MainActivity extends BaseActivity implements View.OnClickListener,
        ViewPager.OnPageChangeListener, MainBottomView.OnMainBottomTabClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ToolBarView mHeader = null;
    private Context mContext;
    private ViewPager mContentViewPager;
    private MainBottomView mMainBottomView;

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        if (context instanceof Activity) {
            context.startActivity(intent);
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initData();
        initView();
    }


    private void initData() {
        mContext = this;
    }


    private void initView() {
        initHeader();
        initBottomView();
        initContentView();
    }

    private void initContentView() {
        mContentViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mContentViewPager.addOnPageChangeListener(this);
        mContentViewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));
    }

    private void initHeader() {
        mHeader = (ToolBarView) findViewById(R.id.main_header);
        mHeader.setCenterTitleTxt(getString(R.string.main_bus_come));
        mHeader.setLeftIvVisibility(View.GONE);
        mHeader.setRightIvVisibility(View.GONE);
        setSupportActionBar(mHeader);
    }

    private void initBottomView(){
        mMainBottomView = (MainBottomView) findViewById(R.id.main_bottom);
        mMainBottomView.setOnMainBottomTabClickListener(this);
        mMainBottomView.setCurPosition(MainBottomView.HOME);
    }

    private void setHeaderState(int curPosition){
        switch (curPosition){
            case MainBottomView.HOME:
                mHeader.setCenterTitleTxt(getString(R.string.main_home));
                mHeader.setLeftIvVisibility(View.GONE);
                mHeader.setRightIvVisibility(View.GONE);
                mHeader.setRightTxtVisibility(View.GONE);
                break;
            case MainBottomView.OFFICIAL:
                mHeader.setCenterTitleTxt(getString(R.string.main_official));
                mHeader.setLeftIvVisibility(View.GONE);
                mHeader.setRightIvVisibility(View.GONE);
                mHeader.setRightTxtVisibility(View.GONE);
                break;
            case MainBottomView.TICKET:
                mHeader.setLeftIvVisibility(View.GONE);
                mHeader.setCenterTitleTxt(getString(R.string.main_ticket));
                mHeader.setRightIvVisibility(View.GONE);
                mHeader.setRightTxtVisibility(View.VISIBLE);
                break;
            case MainBottomView.USER_CENTER:
                mHeader.setCenterTitleTxt(getString(R.string.main_user_center));
                mHeader.setLeftIvVisibility(View.GONE);
                mHeader.setRightIvVisibility(View.VISIBLE);
                mHeader.setRightTxtVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onClick(int prePosition, int curPosition) {

    }
}
