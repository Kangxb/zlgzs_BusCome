package com.zlgzs.xinhuatong.buscome.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public  class BaseItemEntity extends BaseEntity implements Serializable, Parcelable {

    public static final int TYPE_DEFAULT = 0;//其他
    public static final int TYPE_HEADER = 1;//头部View
    public static final int TYPE_FOOTER = 2; //底部加载更多Item

    //定义五种通用类型
    public static final int TYPE_TIME1 = 0x16; //通用类型1
    public static final int TYPE_TIME2 = 0x17; //通用类型2
    public static final int TYPE_TIME3 = 0x18; //通用类型3
    public static final int TYPE_TIME4 = 0x19; //通用类型4
    public static final int TYPE_TIME5 = 0x20; //通用类型5
    public static final int TYPE_TIME6 = 0x21; //通用类型6


    public int getItemViewType(){
        return TYPE_DEFAULT;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public BaseItemEntity() {
    }

    protected BaseItemEntity(Parcel in) {
    }

    public static final Creator<BaseItemEntity> CREATOR = new Creator<BaseItemEntity>() {
        @Override
        public BaseItemEntity createFromParcel(Parcel source) {
            return new BaseItemEntity(source);
        }

        @Override
        public BaseItemEntity[] newArray(int size) {
            return new BaseItemEntity[size];
        }
    };
}
