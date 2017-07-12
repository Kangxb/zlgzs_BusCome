package com.zlgzs.xinhuatong.buscome.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zlgzs.xinhuatong.buscome.R;
import com.zlgzs.xinhuatong.buscome.model.BaseItemEntity;

import java.util.List;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public abstract class BaseRecyclerViewAdapter<T extends BaseItemEntity> extends RecyclerView.Adapter {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    protected OnItemClickListener onItemClickListener;
    protected OnItemClickListener onFooterClickListener;
    protected OnItemClickListener onHeaderClickListener;
    protected OnItemLongClickListener onItemLongClickListener;

    protected Context context;
    private int extraCount;
    protected GridLayoutManager mGridLayoutManager;

    //底部Footer相关状态
    public int showTypeOfFooterView;
    public static final int FOOTER_LOADING = 0;
    public static final int FOOTER_NO_NETWORK = 1;
    public static final int FOOTER_NO_MORE_DATA = 2;
    public static final int FOOTER_REQUEST_ERROR = 3;
    public static final int FOOTER_INVISIBLE = 4;

    private RecyclerView.ViewHolder headerViewHolder;
    private RecyclerView.ViewHolder footerViewHolder;
    protected boolean mHeaderViewVisible = false;
    protected boolean mFooterViewVisible = true; //默认有footerView

    protected abstract T getItem(int position);

    protected abstract int getListSize();

    protected abstract RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent, int viewType);

    protected abstract void bindItemViewHolder(RecyclerView.ViewHolder holder, final int position);

    protected void bindItemViewHolder(RecyclerView.ViewHolder holder, final int position, List payloads){

    }

    protected void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, final int position){

    }

    protected void onBindFooterViewHolder(RecyclerView.ViewHolder holder, final int position) {

    }

    protected void onBindFooterViewHolder(RecyclerView.ViewHolder holder, List payloads){

    }

    protected void onBindFooterViewHolder(RecyclerView.ViewHolder holder, final int position, List payloads) {
    }

    protected void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, final int position, List payloads) {
    }



    public BaseRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public boolean canLoaded() {
        return hasFooterView() && showTypeOfFooterView == FOOTER_LOADING;
    }

    public void setFooterViewTip(int showTyp) {
        showTypeOfFooterView = showTyp;
        //notifyDataSetChanged();
    }

    public void setGridLayoutManager(GridLayoutManager gridLayoutManager) {
        if(gridLayoutManager ==null){
            return;
        }

        mGridLayoutManager = gridLayoutManager;
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = getItemViewType(getRealPosition(position));
                if(type == BaseItemEntity.TYPE_FOOTER || type == BaseItemEntity.TYPE_HEADER){
                    return mGridLayoutManager.getSpanCount();
                }else {
                    return 1;
                }
            }
        });
    }

    public int getShowTypeOfFooterView() {
        return showTypeOfFooterView;
    }

    public void setHeaderViewHolder(RecyclerView.ViewHolder headerViewHolder) {
        this.headerViewHolder = headerViewHolder;
        setHeaderViewVisible(true);
    }

    public void setHeaderViewVisible(boolean isVisible) {
        this.mHeaderViewVisible = isVisible;
    }

    public void setFooterViewHolder(RecyclerView.ViewHolder footerViewHolder) {
        this.footerViewHolder = footerViewHolder;
    }

    public void setFooterViewVisible(boolean isVisible) {
        this.mFooterViewVisible = isVisible;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }

    public void setFooterItemClickListener(OnItemClickListener footerClickListener) {
        this.onFooterClickListener = footerClickListener;
    }

    public void setHeaderClickListener(OnItemClickListener headerClickListener) {
        this.onHeaderClickListener = headerClickListener;
    }

    public void setItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.onItemLongClickListener = itemLongClickListener;
    }

    public int getRealPosition(int position) {
        return position + (hasHeaderView() ? -1 : 0);
    }

    public boolean hasHeaderView() {
        return (headerViewHolder != null) && mHeaderViewVisible;
    }

    public boolean hasFooterView() {
        return mFooterViewVisible;
    }

    @Override
    public int getItemCount() {
        return getListSize() + getExtraItemCount();
    }

    public int getExtraItemCount() {
        extraCount = 0;
        extraCount += hasFooterView() ? 1 : 0;
        extraCount += hasHeaderView() ? 1 : 0;
        return extraCount;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && hasHeaderView()) {
            return BaseItemEntity.TYPE_HEADER;
        } else if ((position == getItemCount() - 1) && hasFooterView()) {
            return BaseItemEntity.TYPE_FOOTER;
        } else {
            return getItem(getRealPosition(position)).getItemViewType();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BaseItemEntity.TYPE_FOOTER:
                if (footerViewHolder != null) {
                    return footerViewHolder;
                }
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_list_footer_view, parent, false);
                footerViewHolder = new FooterViewHolder(v, onFooterClickListener);
                return footerViewHolder;
            case BaseItemEntity.TYPE_HEADER:
                return headerViewHolder;
            default:
                return createItemViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        if(payloads!=null && !payloads.isEmpty()){
            switch (getItemViewType(position)) {
                case BaseItemEntity.TYPE_FOOTER:
                    if (holder instanceof FooterViewHolder) {
                        onBindFooterViewHolder(holder,payloads);
                    } else {
                        onBindFooterViewHolder(holder, position,payloads);
                    }
                    break;
                case BaseItemEntity.TYPE_HEADER:
                    onBindHeaderViewHolder(holder, position,payloads);
                    break;
                default:
                    bindItemViewHolder(holder, position,payloads);
                    break;
            }
        }else {
            onBindViewHolder(holder,position);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case BaseItemEntity.TYPE_FOOTER:
                if (holder instanceof FooterViewHolder) {
                    onBindFooterViewHolder(holder);
                } else {
                    onBindFooterViewHolder(holder, position);
                }
                break;
            case BaseItemEntity.TYPE_HEADER:
                onBindHeaderViewHolder(holder, position);
                break;
            default:
                bindItemViewHolder(holder, position);
                break;
        }
    }


    private void onBindFooterViewHolder(RecyclerView.ViewHolder holder) {
        final FooterViewHolder footerHolder = (FooterViewHolder) holder;
        if (showTypeOfFooterView == FOOTER_LOADING) {
            footerHolder.footerLayout.setVisibility(View.VISIBLE);
            footerHolder.progressbar.setVisibility(View.VISIBLE);
            footerHolder.tipText.setText("加载更多");
        } else if (showTypeOfFooterView == FOOTER_NO_NETWORK) {
            footerHolder.footerLayout.setVisibility(View.VISIBLE);
            footerHolder.progressbar.setVisibility(View.GONE);
            footerHolder.tipText.setText("网络不可用，点击重试");
        } else if (showTypeOfFooterView == FOOTER_NO_MORE_DATA) {
            footerHolder.footerLayout.setVisibility(View.VISIBLE);
            footerHolder.progressbar.setVisibility(View.GONE);
            footerHolder.tipText.setText("没有更多的内容");
        } else if (showTypeOfFooterView == FOOTER_REQUEST_ERROR) {
            footerHolder.footerLayout.setVisibility(View.VISIBLE);
            footerHolder.progressbar.setVisibility(View.GONE);
            footerHolder.tipText.setText("加载数据失败，点击重试");
        } else if (showTypeOfFooterView == FOOTER_INVISIBLE) {
            footerHolder.footerLayout.setVisibility(View.INVISIBLE);
        }

        footerHolder.footerLayout.setTag(showTypeOfFooterView);
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout footerLayout;
        ProgressBar progressbar;
        TextView tipText;
        private OnItemClickListener footerItemListener;

        public FooterViewHolder(View view, OnItemClickListener footerItemListener) {
            super(view);
            this.footerItemListener = footerItemListener;
            footerLayout = (RelativeLayout) view.findViewById(R.id.footer_layout);
            progressbar = (ProgressBar) view.findViewById(R.id.footer_progressbar);
            tipText = (TextView) view.findViewById(R.id.footer_hint_textview);
            footerLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == footerLayout.getId() && footerItemListener != null) {
                footerItemListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

}
