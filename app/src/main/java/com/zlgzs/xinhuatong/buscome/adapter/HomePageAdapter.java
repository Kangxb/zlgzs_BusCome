package com.zlgzs.xinhuatong.buscome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zlgzs.xinhuatong.buscome.R;
import com.zlgzs.xinhuatong.buscome.model.BaseItemEntity;
import com.zlgzs.xinhuatong.buscome.model.BusPathInfoEntity;

import java.util.ArrayList;

/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/4
 * @modfiy
 */
public class HomePageAdapter extends BaseRecyclerViewAdapter{

    private Context mContext;
    private OnAdClickListener onAdClickListener;
    private HeaderViewHolder mHeaderViewHolder;

    private ArrayList<BusPathInfoEntity> busPathInfoEntities = new ArrayList<BusPathInfoEntity>();
//    private ArrayList<AdEntity> adEntities = new ArrayList<AdEntity>();


    public HomePageAdapter(Context context) {
        super(context);
        mContext = context;
    }

    /**
     * 设置班车信息数据
     * @param busPathInfoEntity
     */
    public void setBusPathInfoList(ArrayList<BusPathInfoEntity> busPathInfoEntity) {
        this.busPathInfoEntities = busPathInfoEntity;
        notifyDataSetChanged();

    }

    /**
     * 设置广告信息数据       View view =
     * @param
     */
    public void setAdList(/*, ArrayList<AdEntity> adEntity*/ OnAdClickListener onAdClickListener) {
//        this.adEntities = adEntity;
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_headler, null, false);
        setHeaderViewHolder(new HeaderViewHolder(view, onAdClickListener ));
        notifyDataSetChanged();
    }

    @Override
    protected BaseItemEntity getItem(int position) {
        return busPathInfoEntities.get(position);
    }

    @Override
    protected int getListSize() {
        return busPathInfoEntities.size();
    }

    @Override
    protected RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_bus_path_list, parent, false);
        return new BusPathItemViewHolder(view, onItemClickListener);
    }

    @Override
    protected void bindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        BusPathItemViewHolder busPathItemViewHolder = (BusPathItemViewHolder)holder;
        BusPathInfoEntity entity = busPathInfoEntities.get(getRealPosition(position));
        busPathItemViewHolder.gotInBusTimeTv.setText(entity.inStationTime + "上车");
        busPathItemViewHolder.busStationTv.setText(entity.inceptionStation + "-->" + entity.terminalStation);
        busPathItemViewHolder.busNumberTv.setText(entity.busNumber);
        busPathItemViewHolder.nearestStationTv.setText("上车站 " + entity.nearestStation);
        busPathItemViewHolder.walkTimeTv.setText("步行：" + entity.distance + " 约" + entity.walkTime);
        busPathItemViewHolder.leaveHomeTimeTv.setText("请" + entity.inStationTime + "前出门");
    }

    public static class BusPathItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public LinearLayout busInfoLly;
        public TextView gotInBusTimeTv;
        public TextView busStationTv;
        public TextView busNumberTv;
        public TextView nearestStationTv;
        public TextView walkTimeTv;
        public TextView leaveHomeTimeTv;
        public OnItemClickListener clickListener;
        public BusPathItemViewHolder(View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);
            clickListener = onItemClickListener;

            busInfoLly = (LinearLayout) itemView.findViewById(R.id.bus_info_lly);
            busInfoLly.setOnClickListener(this);

            gotInBusTimeTv = (TextView) itemView.findViewById(R.id.got_in_bus_time_tv);
            busStationTv = (TextView) itemView.findViewById(R.id.bus_station_tv);
            busNumberTv = (TextView) itemView.findViewById(R.id.bus_number_tv);
            nearestStationTv = (TextView) itemView.findViewById(R.id.nearest_station_tv);
            walkTimeTv = (TextView) itemView.findViewById(R.id.walk_time_tv);
            leaveHomeTimeTv = (TextView) itemView.findViewById(R.id.leave_home_time_tv);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != -1 && clickListener != null) {
                clickListener.onItemClick(itemView, position);
            }
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView adIv;
        public OnAdClickListener onAdClickListener;
        public HeaderViewHolder(View view,final OnAdClickListener onAdClickListener) {
            super(view);
            adIv = (ImageView) view.findViewById(R.id.ad_iv);
            adIv.setOnClickListener(this);
            this.onAdClickListener = onAdClickListener;
        }

        @Override
        public void onClick(View view) {
            if(onAdClickListener != null)
            onAdClickListener.onClickAd();
        }
    }

    @Override
    protected void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindHeaderViewHolder(holder, position);
        HeaderViewHolder headerViewHolder = (HeaderViewHolder)holder;
        headerViewHolder.adIv.setImageResource(R.mipmap.start_logo);
    }

    public void setAdClickListener(OnAdClickListener onAdClickListener) {
        this.onAdClickListener = onAdClickListener;
    }
    public interface OnAdClickListener {
        void onClickAd(/*NewsAdItemEntity entity*/);
    }
}
