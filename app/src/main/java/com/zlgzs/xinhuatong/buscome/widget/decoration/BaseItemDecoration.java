package com.zlgzs.xinhuatong.buscome.widget.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 自定义RecyclerView item的分割线
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy0
 * */
public class BaseItemDecoration extends RecyclerView.ItemDecoration {

    protected Context context;
    protected int mTop;
    protected int mBottom;
    protected int mLeft;
    protected int mRight;

    public BaseItemDecoration(Context ctx) {
        context = ctx;
    }

    public void setDividerSize(int left,int top,int right,int bottom){
        mLeft = left;
        mTop = top;
        mRight = right;
        mBottom = bottom;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.set(mLeft, mTop, mRight, mBottom);
    }

}
