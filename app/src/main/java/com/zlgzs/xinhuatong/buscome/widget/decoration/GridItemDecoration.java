package com.zlgzs.xinhuatong.buscome.widget.decoration;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zlgzs.xinhuatong.buscome.R;

/**
 * 网格列表装饰器
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy0
 * */
public class GridItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;

    protected int mLeft;
    protected int mRight;

    protected int mHorizontalDivider;
    protected int mVerticalDivider;
    protected int mSpanCount;

    public GridItemDecoration(Context context, int spanCount) {
        mSpanCount = spanCount;
        mPaint = new Paint();
        mPaint.setColor(context.getResources().getColor(R.color.transparent));
    }

    public void setDivider(int left,int right,int horizontalDivider,int verticalDivider){
        mLeft = left;
        mRight = right;
        mHorizontalDivider = horizontalDivider;
        mVerticalDivider = verticalDivider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if( position % mSpanCount == 0){
            outRect.set(mLeft, 0, mHorizontalDivider, mVerticalDivider);
        }else {
            outRect.set(0, 0, mRight, mVerticalDivider);
        }
    }
}
