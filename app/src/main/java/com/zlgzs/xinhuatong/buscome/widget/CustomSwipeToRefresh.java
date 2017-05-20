package com.zlgzs.xinhuatong.buscome.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * 自定义下拉刷新 解决下拉事件不顺畅
 * Created by kangxb on 2017/5/21.
 */
public class CustomSwipeToRefresh extends SwipeRefreshLayout {

    private int mTouchSlop;
    private float mPrevX;

    public CustomSwipeToRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPrevX = MotionEvent.obtain(event).getX();
                break;

            case MotionEvent.ACTION_MOVE:
                final float eventX = event.getX();
                float xDiff = Math.abs(eventX - mPrevX);

                if (xDiff > mTouchSlop) {
                    return false;
                }
        }

        return super.onInterceptTouchEvent(event);
    }
}
