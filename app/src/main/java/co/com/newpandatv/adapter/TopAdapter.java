package co.com.newpandatv.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.app.App;
import co.com.newpandatv.model.entity.TopBean;

import static co.com.newpandatv.R.id.pandaLiveDate;
import static co.com.newpandatv.R.id.pandaLiveImg;
import static co.com.newpandatv.R.id.pandaLiveLen;
import static co.com.newpandatv.R.id.pandaLiveTitle;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class TopAdapter extends AbsAdapter<TopBean.VideoBean> {
    public TopAdapter(Context context, int layoutId, List<TopBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, TopBean.VideoBean data) {
        ImageView topImg = (ImageView) holder.getView(pandaLiveImg);
        TextView topTitle = (TextView) holder.getView(pandaLiveTitle);
        TextView topDate = (TextView) holder.getView(pandaLiveDate);
        TextView topLen = (TextView) holder.getView(pandaLiveLen);


        Glide.with(App.mContext).load(data.getImg()).fitCenter().into(topImg);
        topTitle.setText(data.getT());
        topDate.setText(data.getPtime());
        topLen.setText(data.getLen());
    }
}
