package com.zlgzs.xinhuatong.buscome.manager;


import com.zlgzs.xinhuatong.buscome.model.BaseEntity;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public interface IBaseManager<T extends BaseEntity> {

    void onLoadComplete(T t);

    void onLoading();
}
