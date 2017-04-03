package com.zlgzs.xinhuatong.buscome.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zlgzs.xinhuatong.buscome.R;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class ToolBarView extends Toolbar implements View.OnClickListener{
    private Context context;
    private ImageView mHeaderLeftIv, mRightIv;
    private TextView mCenterTitle, mHeaderRightTxt;
    private Toolbar toolbar;

    public ToolBarView(Context context) {
        this(context, null);
    }

    public ToolBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        inflate(context, R.layout.layout_toolbar, this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        mHeaderLeftIv = (ImageView) findViewById(R.id.left_iv);
        mCenterTitle = (TextView) findViewById(R.id.center_title);
        mHeaderRightTxt = (TextView) findViewById(R.id.right_tv);
        mRightIv = (ImageView) findViewById(R.id.right_iv);
        mHeaderRightTxt.setOnClickListener(this);
        mRightIv.setOnClickListener(this);
        mHeaderLeftIv.setOnClickListener(this);
        mCenterTitle.setOnClickListener(this);
    }

    public void setLeftIvResource(int resourceId){
        mHeaderLeftIv.setImageResource(resourceId);
    }

    public void setLeftIvBg(int background){
        mHeaderLeftIv.setBackgroundResource(background);
    }

    public void setLeftIvVisibility(int visibility){
        mHeaderLeftIv.setVisibility(visibility);
    }

    public void setLeftPadding(int leftPadding){
        toolbar.setPadding(leftPadding,0,0,0);
    }

    public void setCenterTitleSize(int size){
        mCenterTitle.setTextSize(size);
    }
    public void setCenterTitleColor(int color){
        mCenterTitle.setTextColor(color);
    }

    public void setCenterTitleMargin(int left, int top, int right, int bottom){
        RelativeLayout.LayoutParams params =(RelativeLayout.LayoutParams) mCenterTitle.getLayoutParams();
        params.setMargins(left, top, right, bottom);
        mCenterTitle.setLayoutParams(params);
    }

    public void setToolbarHeight(int height){
        ViewGroup.LayoutParams params = toolbar.getLayoutParams();
        params.height = height;
        toolbar.setLayoutParams(params);
    }

    public void setCenterTitleTxt(String text){
        mCenterTitle.setText(text);
    }

    /**
     * 获取球队toolbar的选项
     */
    public String getCenterTitleTxt(){
        return mCenterTitle.getText().toString();
    }

    /**
     * 设置header右侧图标,球队fragment需要用到
     * @param resourceId
     */
    public void setCenterTitleDrawableRight(int resourceId){
        Drawable drawableRight=getResources().getDrawable(resourceId);
        drawableRight.setBounds(0, 0, drawableRight.getMinimumWidth(), drawableRight.getMinimumHeight());
        mCenterTitle.setCompoundDrawables(null, null, drawableRight, null);
        mCenterTitle.setCompoundDrawablePadding(12);
    }

    public void setRightTxt(String text){
        mHeaderRightTxt.setText(text);
    }

    public void setRightTxtColor(int color){
        mHeaderRightTxt.setTextColor(color);
    }

    public void setCenterTxtColor(int color){
        mCenterTitle.setTextColor(color);
    }

    public void setRightTxtVisibility(int visibility){
        mHeaderRightTxt.setVisibility(visibility);
    }

    public void setRightTxtClickable(boolean isClick){
        mHeaderRightTxt.setClickable(isClick);
    }

    public void setRightIvVisibility(int visibility){
        mRightIv.setVisibility(visibility);
    }

    public void setRightIvResource(int resourceId){
        mRightIv.setImageResource(resourceId);
    }

    public void setClickListener(OnToolBarClickListener listener){
        this.mClickListener = listener;
    }

    public View getRightIv() {
        return mRightIv;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_iv:
                if(mClickListener != null){
                    mClickListener.onLeftClick();
                }
                break;
            case R.id.right_iv:
                if(mClickListener != null){
                    mClickListener.onRightIvClick();
                }
                break;
            case R.id.right_tv:
                if(mClickListener != null){
                    mClickListener.onRightTxtClick();
                }
                break;
            case R.id.center_title:
                if(mClickListener != null){
                    mClickListener.onCenterTitleClick();
                }
                break;
        }
    }

    public interface OnToolBarClickListener{
        void onLeftClick();
        void onRightIvClick();
        void onRightTxtClick();
        void onCenterTitleClick();
    }

    private OnToolBarClickListener mClickListener;

    @TargetApi(19)
    private void setTranslucentStatus(boolean on, Activity act) {
        Window win = act.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
