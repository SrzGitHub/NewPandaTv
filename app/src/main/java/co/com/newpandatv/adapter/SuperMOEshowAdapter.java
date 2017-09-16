package co.com.newpandatv.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.model.entity.SuperMOEshowBean;

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

public class SuperMOEshowAdapter extends AbsAdapter<SuperMOEshowBean.VideoBean> {

    public SuperMOEshowAdapter(Context context, int layoutId, List<SuperMOEshowBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, SuperMOEshowBean.VideoBean data) {
        ImageView showImg = (ImageView) holder.getView(pandaLiveImg);
        TextView showTitle = (TextView) holder.getView(pandaLiveTitle);
        TextView showDate = (TextView) holder.getView(pandaLiveDate);
        TextView showLen = (TextView) holder.getView(pandaLiveLen);


        Glide.with(App.getContext()).load(data.getImg()).fitCenter().into(showImg);
        showTitle.setText(data.getT());
        showDate.setText(data.getPtime());
        showLen.setText(data.getLen());

    }
}
