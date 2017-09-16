package co.com.newpandatv.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.model.entity.OriginalNewsBean;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class OriginalNewsAdapter extends AbsAdapter<OriginalNewsBean.VideoBean> {
    public OriginalNewsAdapter(Context context, int layoutId, List<OriginalNewsBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, OriginalNewsBean.VideoBean data) {
        ImageView newsImg = (ImageView) holder.getView(R.id.pandaLiveImg);
        TextView newsLen = (TextView) holder.getView(R.id.pandaLiveLen);
        TextView newsTitle = (TextView) holder.getView(R.id.pandaLiveTitle);
        TextView newsDate = (TextView) holder.getView(R.id.pandaLiveDate);

        Glide.with(App.getContext()).load(data.getImg()).fitCenter().into(newsImg);
        newsDate.setText(data.getPtime());
        newsLen.setText(data.getLen());
        newsTitle.setText(data.getT());
    }
}
