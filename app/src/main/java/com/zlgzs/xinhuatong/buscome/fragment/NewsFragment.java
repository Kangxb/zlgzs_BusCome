package com.zlgzs.xinhuatong.buscome.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zlgzs.xinhuatong.buscome.R;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class NewsFragment extends BaseFragment{
    private Activity mActivity;
    private View mRootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
//        mNewsManager = new NewsManager(mActivity,this);
        mRootView = inflater.inflate(R.layout.fragment_home,container,false);

        return mRootView;
    }

}
