package co.com.newpandatv.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.model.entity.SpecialBean;

import static co.com.newpandatv.R.id.pandaLiveDate;
import static co.com.newpandatv.R.id.pandaLiveImg;
import static co.com.newpandatv.R.id.pandaLiveLen;
import static co.com.newpandatv.R.id.pandaLiveTitle;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class SpecialAdapter extends AbsAdapter<SpecialBean.VideoBean> {
    public SpecialAdapter(Context context, int layoutId, List<SpecialBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, SpecialBean.VideoBean data) {
        ImageView soeImg = (ImageView) holder.getView(pandaLiveImg);
        TextView speTitle = (TextView) holder.getView(pandaLiveTitle);
        TextView speDate = (TextView) holder.getView(pandaLiveDate);
        TextView speLen = (TextView) holder.getView(pandaLiveLen);


        Glide.with(App.mContext).load(data.getImg()).fitCenter().into(soeImg);
        speTitle.setText(data.getT());
        speDate.setText(data.getPtime());
        speLen.setText(data.getLen());
    }
}
