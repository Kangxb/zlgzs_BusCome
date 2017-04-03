package com.zlgzs.xinhuatong.buscome.model;


import java.io.Serializable;

/**
 * 实体基类
 *
 * Created by caot on 2016/10/25.
 */
public class BaseEntity implements Serializable{

    public int ret;
    public String msg;

    public boolean success(){
        return ret == 0;
    }
}
