package com.zlgzs.xinhuatong.buscome.manager;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/4
 * @modfiy
 */

public interface IHomePageManager extends IBaseListManager{
    void onAdColumn(boolean isRefresh);  // 广告栏
    void onBusInfo(boolean isRefresh);   // 班车信息

}
