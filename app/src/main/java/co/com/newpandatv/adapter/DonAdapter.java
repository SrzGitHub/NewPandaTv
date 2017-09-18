package co.com.newpandatv.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.model.entity.DonBean;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class DonAdapter extends AbsAdapter<DonBean.VideoBean> {
    public DonAdapter(Context context, int layoutId, List<DonBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, DonBean.VideoBean data) {
      ImageView  donImg = (ImageView) holder.getView(R.id.pandaLiveImg);
        TextView donLen = (TextView) holder.getView(R.id.pandaLiveLen);
        TextView donTitle = (TextView) holder.getView(R.id.pandaLiveTitle);
        TextView donDate = (TextView) holder.getView(R.id.pandaLiveDate);

        Glide.with(App.mContext).load(data.getImg()).diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().into(donImg);
        donDate.setText(data.getPtime());
        donLen.setText(data.getLen());
        donTitle.setText(data.getT());

    }
}
