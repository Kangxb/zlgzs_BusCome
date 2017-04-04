package com.zlgzs.xinhuatong.buscome.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
 /**
 * 类说明： RecyclerView列表Fragment基类
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */

public class BaseRecyclerViewFragment extends BaseFragment {

    protected RecyclerView mRecyclerView;
    protected LinearLayoutManager mLayoutManager;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean mIsCanLoadMore = true;
    private boolean mIsCanLoadRefresh = true;
    /**
     * 加载更多回调
     */
    protected void loadMore(){};

    /**
     * 刷新回调
     */
    protected void loadRefresh(){};

    /**
     * 加载列表获取结束时
     *
     * @param isCanLoadMore
     */
    protected void setCanLoadMore(boolean isCanLoadMore){
        mIsCanLoadMore = isCanLoadMore;
    }

    /**
     * 是否可以加载更多
     *
     * @return
     */
    protected boolean isCanLoadMore(){
        return mIsCanLoadMore;
    }

    /**
     * 设置是否可刷新
     *
     * @return
     */
    public boolean setCanLoadRefresh() {
        return mIsCanLoadRefresh;
    }

    /**
     * 是否可以刷新
     *
     * @return
     */
    public boolean isCanLoadRefresh() {
        return mIsCanLoadRefresh;
    }

    /**
     * 设置向下滚动（加载更多）监听
     */
    protected void setLoadMoreListener() {
        if(mRecyclerView == null){
            throw new IllegalArgumentException("RecyclerView uninitialized");
        }

        if(mLayoutManager == null){
            throw new IllegalArgumentException("LayoutManager uninitialized");
        }

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                int totalItemCount = mLayoutManager.getItemCount();
                if (lastVisibleItem >= totalItemCount - 2) {
                    if (isCanLoadMore()) {
                        loadMore();
                    }
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    /**
     * 设置下拉刷新回调
     */
    protected void setLoadRefreshListener(){
        if(mSwipeRefreshLayout == null){
            throw new IllegalArgumentException("SwipeRefreshLayout uninitialized");
        }

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(isCanLoadRefresh()){
                    loadRefresh();
                }
            }
        });
    }
}
