package com.zlgzs.xinhuatong.buscome.manager;

import com.zlgzs.xinhuatong.buscome.model.BaseEntity;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/4
 * @modfiy
 */
public interface IBaseListManager <T extends BaseEntity> {
    void onLoading(int pageNum,boolean isRefresh);

    void onLoadingSuccess(T t,int pageNum,boolean isRefresh);

    void onLoadingError(T t,int pageNum,boolean isRefresh);
}
