package co.com.newpandatv.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.model.entity.BillowingVideoBean;

/**
 * Created by 小七七 on 2017/9/14.
 */

public class BillowingAdapter extends AbsAdapter<BillowingVideoBean.ListBean> {


    public BillowingAdapter(Context context, int layoutId, List<BillowingVideoBean.ListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, BillowingVideoBean.ListBean data) {
        TextView mTim = (TextView) holder.getView(R.id.mTime_g);
        TextView mTitle = (TextView) holder.getView(R.id.mTitle_g);
        TextView mCon = (TextView) holder.getView(R.id.mContent_g);
        ImageView mImg = (ImageView) holder.getView(R.id.mImage_g);
        Glide.with(App.mContext).load(data.getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().into(mImg);
        mTim.setText(data.getVideoLength());
        mCon.setText(data.getBrief());
        mTitle.setText(data.getTitle());


    }
}
