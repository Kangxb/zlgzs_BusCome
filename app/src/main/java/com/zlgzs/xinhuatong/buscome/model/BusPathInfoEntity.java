package com.zlgzs.xinhuatong.buscome.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 类说明：班车路径详情
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/4
 * @modfiy
 */

public class BusPathInfoEntity extends BaseItemEntity  implements Serializable, Parcelable {
    private static final long serialVersionUID = 7322142431698829296L;

    public Long inStationTime;        // 到站时间
    public String inceptionStation;   // 起点站
    public String terminalStation;    // 终点站
    public String busNumber;          // 车次
    public String nearestStation;     // 最近的上车车站
    public int distance;              // 目前位置与最近上车车站距离
    public String walkTime;           // 目前位置与最近上车车站走路时间
    public String outHomeTime;        // 出门时间

    public BusPathInfoEntity(Parcel in) {
       this.inStationTime = in.readLong();
       this.inceptionStation = in.readString();
       this.terminalStation = in.readString();
       this.busNumber = in.readString();
       this.nearestStation = in.readString();
       this.distance = in.readInt();
       this.walkTime = in.readString();
       this.outHomeTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(inStationTime);
        dest.writeString(inceptionStation);
        dest.writeString(terminalStation);
        dest.writeString(busNumber);
        dest.writeString(nearestStation);
        dest.writeInt(distance);
        dest.writeString(walkTime);
        dest.writeString(outHomeTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BusPathInfoEntity> CREATOR = new Creator<BusPathInfoEntity>() {
        @Override
        public BusPathInfoEntity createFromParcel(Parcel in) {
            return new BusPathInfoEntity(in);
        }

        @Override
        public BusPathInfoEntity[] newArray(int size) {
            return new BusPathInfoEntity[size];
        }
    };
}
