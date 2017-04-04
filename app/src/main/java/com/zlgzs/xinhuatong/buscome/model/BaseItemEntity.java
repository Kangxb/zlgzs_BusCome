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
