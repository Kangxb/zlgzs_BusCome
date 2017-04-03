package com.zlgzs.xinhuatong.buscome.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zlgzs.xinhuatong.buscome.R;

/**
 * 类说明：
 * @author kangxb
 * @date 2017/4/3
 * @version 1.0
 * @modfiy
 */
public class MainBottomView extends LinearLayout implements View.OnClickListener{
    private int mCurPosition = 0;
    public static final int HOME = 0;
    public static final int OFFICIAL = 1;
    public static final int TICKET = 2;
    public static final int USER_CENTER = 3;
    private View mRootView;
    private Context mContext;
    private TextView mOfficialTabTv;
    private TextView mTicketTabTv;
    private TextView mUserCenterTabTv;
    private TextView mNewsTabTv;
    private OnMainBottomTabClickListener mOnMainBottomTabClickListener;

    public MainBottomView(Context context) {
        super(context);
        init(context);
    }

    public MainBottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        mContext = context;
        mRootView = inflate(mContext, R.layout.layout_main_bottom,this);

        mNewsTabTv = (TextView) findViewById(R.id.main_bottom_news_tab);
        mOfficialTabTv = (TextView) findViewById(R.id.main_bottom_official_tab);
        mTicketTabTv = (TextView) findViewById(R.id.main_bottom_tickets_tab);
        mUserCenterTabTv = (TextView) findViewById(R.id.main_bottom_user_center_tab);
        mTicketTabTv.setOnClickListener(this);
        mOfficialTabTv.setOnClickListener(this);
        mUserCenterTabTv.setOnClickListener(this);
        mNewsTabTv.setOnClickListener(this);
    }

    public void setOnMainBottomTabClickListener(OnMainBottomTabClickListener onMainBottomTabClickListener) {
        mOnMainBottomTabClickListener = onMainBottomTabClickListener;
    }

    public void setCurPosition(int curPosition) {
        this.mCurPosition = curPosition;
        handleSelect(curPosition);
    }

    private void handleSelect(int curPosition){
        switch (curPosition){
            case OFFICIAL:
                mOfficialTabTv.setBackgroundColor(getResources().getColor(R.color.common_red_press));
                mTicketTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mUserCenterTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mNewsTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                break;
            case TICKET:
                mOfficialTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mTicketTabTv.setBackgroundColor(getResources().getColor(R.color.common_red_press));
                mUserCenterTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mNewsTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                break;
            case USER_CENTER:
                mOfficialTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mTicketTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mUserCenterTabTv.setBackgroundColor(getResources().getColor(R.color.common_red_press));
                mNewsTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                break;
            case HOME:
                mOfficialTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mTicketTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mUserCenterTabTv.setBackgroundColor(getResources().getColor(R.color.common_red));
                mNewsTabTv.setBackgroundColor(getResources().getColor(R.color.common_red_press));
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_bottom_official_tab:
                handleSelect(OFFICIAL);
                if(mOnMainBottomTabClickListener!=null){
                    mOnMainBottomTabClickListener.onClick(mCurPosition,OFFICIAL);
                }
                break;
            case R.id.main_bottom_tickets_tab:
                handleSelect(TICKET);
                if(mOnMainBottomTabClickListener!=null){
                    mOnMainBottomTabClickListener.onClick(mCurPosition,TICKET);
                }
                break;
            case R.id.main_bottom_user_center_tab:
                handleSelect(USER_CENTER);
                if(mOnMainBottomTabClickListener!=null){
                    mOnMainBottomTabClickListener.onClick(mCurPosition,USER_CENTER);
                }
                break;
            case R.id.main_bottom_news_tab:
                handleSelect(HOME);
                if(mOnMainBottomTabClickListener!=null){
                    mOnMainBottomTabClickListener.onClick(mCurPosition,HOME);
                }
                break;
            default:
                break;
        }
    }

    public interface OnMainBottomTabClickListener{
        void onClick(int prePosition, int curPosition);
    }
}
