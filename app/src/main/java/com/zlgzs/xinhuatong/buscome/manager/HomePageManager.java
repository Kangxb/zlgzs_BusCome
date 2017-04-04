package com.zlgzs.xinhuatong.buscome.manager;

import android.content.Context;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/4
 * @modfiy
 */
public class HomePageManager extends BaseManager{
    private Context mContext;
    private IHomePageManager mIHomePageManager;

    public HomePageManager(Context mContext, IHomePageManager mIHomePageManager) {
        this.mContext = mContext;
        this.mIHomePageManager = mIHomePageManager;
    }

    /**
     * 先获取本地缓存的数据
     */
    public void getHomePageList() {
//        NewsListResEntity entity = getNewsListFromCache();
//        if(entity!=null){
//            mINewsManager.onLoadingSuccess(entity,mNewsListPageNum,false);
//            if(isNeedRefreshNewsList(entity.lastModified)){
//                getHomePageListFromNet(true);
//            }
//        }else {
        getHomePageListFromNet(false);
//        }

    }

    public void getHomePageListFromNet() {
        getHomePageListFromNet(true);
    }

    public void getHomePageListFromNet(final boolean isRefresh){

    }

    public void refreshList() {
    }

    @Override
    public void cancel() {

    }
}
