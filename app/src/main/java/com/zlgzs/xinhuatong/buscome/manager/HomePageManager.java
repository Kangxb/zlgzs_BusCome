package com.zlgzs.xinhuatong.buscome.manager;

import android.content.Context;
import android.text.TextUtils;

import com.zlgzs.xinhuatong.buscome.model.BusPathInfoEntity;
import com.zlgzs.xinhuatong.buscome.model.BusPathListInfoEntity;
import com.zlgzs.xinhuatong.buscome.utils.JsonUtil;

import java.util.ArrayList;

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

    public void getHomePageListFromNet(final boolean isRefresh) {
        //FIXME 暂时写假数据
        BusPathListInfoEntity busPathListInfoEntity = new BusPathListInfoEntity();
        String jsonData = "{\"busPathInfos\":[" +
                "{\"inStationTime\":\"08:30\",\"inceptionStation\":\"新化\",\"terminalStation\":\"田坪\",\"busNumber\":\"湘K1080\",\"nearestStation\":\"关上\",\"distance\":980,\"walkTime\":\"15分钟\",\"outHomeTime\":\"08:20\" }," +
                "{\"inStationTime\":\"09:00\",\"inceptionStation\":\"新化\",\"terminalStation\":\"田坪\",\"busNumber\":\"湘K1089\",\"nearestStation\":\"关上\",\"distance\":980,\"walkTime\":\"15分钟\",\"outHomeTime\":\"08:50\" }," +
                "{\"inStationTime\":\"09:30\",\"inceptionStation\":\"新化\",\"terminalStation\":\"田坪\",\"busNumber\":\"湘K1022\",\"nearestStation\":\"关上\",\"distance\":980,\"walkTime\":\"15分钟\",\"outHomeTime\":\"09:20\" }," +
                "{\"inStationTime\":\"10:00\",\"inceptionStation\":\"新化\",\"terminalStation\":\"田坪\",\"busNumber\":\"湘K1032\",\"nearestStation\":\"关上\",\"distance\":980,\"walkTime\":\"15分钟\",\"outHomeTime\":\"10:50\" }," +
                "{\"inStationTime\":\"10:30\",\"inceptionStation\":\"新化\",\"terminalStation\":\"田坪\",\"busNumber\":\"湘K10w3\",\"nearestStation\":\"关上\",\"distance\":980,\"walkTime\":\"15分钟\",\"outHomeTime\":\"11:20\" }," +
                "{\"inStationTime\":\"11:00\",\"inceptionStation\":\"新化\",\"terminalStation\":\"田坪\",\"busNumber\":\"湘K1349\",\"nearestStation\":\"关上\",\"distance\":980,\"walkTime\":\"15分钟\",\"outHomeTime\":\"11:50\" }," +
                "{\"inStationTime\":\"11:30\",\"inceptionStation\":\"新化\",\"terminalStation\":\"田坪\",\"busNumber\":\"湘K1054\",\"nearestStation\":\"关上\",\"distance\":980,\"walkTime\":\"15分钟\",\"outHomeTime\":\"12:20\" }," +
                "{\"inStationTime\":\"12:00\",\"inceptionStation\":\"新化\",\"terminalStation\":\"田坪\",\"busNumber\":\"湘K1036\",\"nearestStation\":\"关上\",\"distance\":980,\"walkTime\":\"15分钟\",\"outHomeTime\":\"01:50\" }"  +
                "]}";
        if(!TextUtils.isEmpty(jsonData)){
            busPathListInfoEntity = JsonUtil.fromJsonString(jsonData,BusPathListInfoEntity.class);
        }
        if(busPathListInfoEntity != null){
            mIHomePageManager.onLoadingSuccess(busPathListInfoEntity, 1, false);
        }

    }

    public void refreshList() {
    }

    @Override
    public void cancel() {

    }
}
