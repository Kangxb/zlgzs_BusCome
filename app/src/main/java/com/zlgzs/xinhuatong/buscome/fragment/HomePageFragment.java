package com.zlgzs.xinhuatong.buscome.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zlgzs.xinhuatong.buscome.R;
import com.zlgzs.xinhuatong.buscome.adapter.BaseRecyclerViewAdapter;
import com.zlgzs.xinhuatong.buscome.adapter.HomePageAdapter;
import com.zlgzs.xinhuatong.buscome.manager.HomePageManager;
import com.zlgzs.xinhuatong.buscome.manager.IHomePageManager;
import com.zlgzs.xinhuatong.buscome.model.BaseEntity;
import com.zlgzs.xinhuatong.buscome.model.BusPathInfoEntity;
import com.zlgzs.xinhuatong.buscome.model.BusPathListInfoEntity;
import com.zlgzs.xinhuatong.buscome.utils.ToastUtil;
import com.zlgzs.xinhuatong.buscome.widget.decoration.CommonSimpleDivider;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class HomePageFragment extends BaseRecyclerViewFragment implements IHomePageManager{
    private Activity mActivity;
    private HomePageManager mHomePageManager;
    private View mRootView;
    private HomePageAdapter adapter;

    private boolean mIsLoadingNewsList = false;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHomePageManager.getHomePageList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        mHomePageManager = new HomePageManager(mActivity, this);
        mRootView = inflater.inflate(R.layout.fragment_home_page, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.home_page_srl);
        initAdapter();
        initRecyclerView();
        setLoadMoreListener();
//        setRefreshListener();
        mHomePageManager.getHomePageList();
        return mRootView;
    }

    private void initAdapter() {
        adapter = new HomePageAdapter(mActivity);

        adapter.setAdList( /* 实体数据  */new HomePageAdapter.OnAdClickListener() {

            @Override
            public void onClickAd() {
                //TODO 跳转到广告店内信息
                ToastUtil.showLongToast(mActivity, "跳到广告店家信息");
            }
        });
        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                //TODO 打开详细信息
                ToastUtil.showLongToast(mActivity, "打开详细信息");
            }
        });

    }

    private void initRecyclerView(){
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.home_page_rv);
        mLayoutManager = new LinearLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(null);
        CommonSimpleDivider commonSimpleDivider = new CommonSimpleDivider(mActivity, CommonSimpleDivider.VERTICAL_LIST);
        commonSimpleDivider.setDividerPadding(mActivity.getResources().getDimensionPixelOffset(R.dimen.common_list_horizontal_divider));
        mRecyclerView.addItemDecoration(commonSimpleDivider);
    }

    @Override
    protected void loadMore() {
//        if(mIsLoadingNewsList){
            mHomePageManager.getHomePageListFromNet();
//        }
    }

    @Override
    protected void loadRefresh() {
        if(mIsLoadingNewsList){
            mHomePageManager.refreshList();
        }
    }


    @Override
    public void onAdColumn(boolean isRefresh) {

    }

    @Override
    public void onBusInfo(boolean isRefresh) {

    }

    @Override
    public void onLoading(int pageNum, boolean isRefresh) {
        mIsLoadingNewsList = true;
        adapter.setFooterViewTip(BaseRecyclerViewAdapter.FOOTER_LOADING);
        adapter.notifyItemChanged(adapter.getItemCount() - 1);
    }

    @Override
    public void onLoadingSuccess(BaseEntity baseEntity, int pageNum, boolean isRefresh) {
        mIsLoadingNewsList = false;
        ArrayList<BusPathInfoEntity> busPathInfoEntity = ((BusPathListInfoEntity)baseEntity).busPathInfos;
        Log.i(TAG, "--busPathInfoEntity-->" + busPathInfoEntity.get(0).busNumber);
        adapter.setBusPathInfoList(busPathInfoEntity);

//        if(!ResponseUtil.isEmptyList(entity.Rows)){
//            handleNewsList(pageNum,entity.Rows,isRefresh);
//        }else {
//            handleNewsListEmpty(pageNum,isRefresh);
//        }
//        mNewsManager.getNewsTopList();
    }

    @Override
    public void onLoadingError(BaseEntity baseEntity, int pageNum, boolean isRefresh) {
        mIsLoadingNewsList = false;
//        handleNewsListError(pageNum,entity,isRefresh);
//        mNewsManager.getNewsTopList();
    }
}
