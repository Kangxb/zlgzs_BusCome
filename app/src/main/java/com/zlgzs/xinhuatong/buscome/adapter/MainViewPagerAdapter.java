package com.zlgzs.xinhuatong.buscome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zlgzs.xinhuatong.buscome.fragment.HomePageFragment;
import com.zlgzs.xinhuatong.buscome.widget.MainBottomView;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private static final int MAIN_TAB_SUM = 4;

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == MainBottomView.OFFICIAL){
            return new HomePageFragment();
        }else if(position == MainBottomView.TICKET){
            return new HomePageFragment();
        }else if(position == MainBottomView.HOME){
            return new HomePageFragment();
        }else {
            return new HomePageFragment();
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return MAIN_TAB_SUM;
    }
}
