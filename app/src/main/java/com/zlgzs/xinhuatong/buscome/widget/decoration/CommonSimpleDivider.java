package com.zlgzs.xinhuatong.buscome.widget.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zlgzs.xinhuatong.buscome.R;


/**
 * 公共RecyclerView分隔线
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy0
 * */
public class CommonSimpleDivider extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private int mOrientation;
    private int mDividerPadding;
    private int mDividerSize = 1;
    private Context mContext;

    public CommonSimpleDivider(Context context, int orientation) {
        mContext = context;
        mOrientation = orientation;
        mPaint = new Paint();
        mPaint.setColor(context.getResources().getColor(R.color.common_divider));
    }

    /**
     * 设置分隔线大小
     *
     * @param size
     */
    public void setDividerSize(int size){
        mDividerSize = size;
    }

    /**
     * 设置分割线颜色
     *
     * @param color
     */
    public void setDividerColor(@ColorRes int color){
        mPaint.setColor(mContext.getResources().getColor(color));
    }

    /**
     * 设置列表方向
     *
     * @param orientation
     */
    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    /**
     * 设置分隔线偏移量
     *
     * @param dividerPadding
     */
    public void setDividerPadding(int dividerPadding) {
        mDividerPadding = dividerPadding;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft() + mDividerPadding;
        final int right = parent.getWidth() - parent.getPaddingRight() - mDividerPadding;

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDividerSize;
            if(i != childCount - 1){
                c.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop() - mDividerPadding;
        final int bottom = parent.getHeight() - parent.getPaddingBottom() + mDividerPadding;

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDividerSize;
            if(i != childCount - 1){
                c.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

}
