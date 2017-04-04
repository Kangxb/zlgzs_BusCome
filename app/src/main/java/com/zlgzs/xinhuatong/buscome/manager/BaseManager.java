package com.zlgzs.xinhuatong.buscome.manager;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public abstract class BaseManager {
    /**
     * 用于退出页面时间取消后台线程
     */
    public abstract void cancel();
}
