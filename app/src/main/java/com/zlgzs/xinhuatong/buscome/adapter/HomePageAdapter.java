package com.zlgzs.xinhuatong.buscome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.zlgzs.xinhuatong.buscome.model.BaseItemEntity;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/4
 * @modfiy
 */
public class HomePageAdapter extends BaseRecyclerViewAdapter{

    private Context mContext;
    private OnAdCoumnClickListener onAdCoumnClickListener;
//    private HeaderViewHolder mHeaderViewHolder;

    public HomePageAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseItemEntity getItem(int position) {
        return null;
    }

    @Override
    protected int getListSize() {
        return 0;
    }

    @Override
    protected RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected void bindItemViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public void setAdCoumnClickListener(OnAdCoumnClickListener onAdCoumnClickListener) {
        this.onAdCoumnClickListener = onAdCoumnClickListener;
//        mHeaderViewHolder = new HeaderViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_news_list_header, null), onFocusViewClickListener);
//        setHeaderViewHolder(mHeaderViewHolder);
    }
    public interface OnAdCoumnClickListener {
        void onClickAd(/*NewsAdItemEntity entity*/);
    }
}
