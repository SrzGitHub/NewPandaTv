package co.com.newpandatv.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.model.entity.WonderfuMomentBean;

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

public class WonderFuAdapter extends AbsAdapter<WonderfuMomentBean.VideoBean> {

    public WonderFuAdapter(Context context, int layoutId, List<WonderfuMomentBean.VideoBean> datas) {
        super(context, layoutId, datas);

    }

    @Override
    public void bindResponse(ViewHolder holder, WonderfuMomentBean.VideoBean data) {

        ImageView derImg = (ImageView) holder.getView(pandaLiveImg);
        TextView derTitle = (TextView) holder.getView(pandaLiveTitle);
        TextView derDate = (TextView) holder.getView(pandaLiveDate);
        TextView derLen = (TextView) holder.getView(pandaLiveLen);


        Glide.with(App.getContext()).load(data.getImg()).fitCenter().into(derImg);
        derTitle.setText(data.getT());
        derDate.setText(data.getPtime());
        derLen.setText(data.getLen());

    }


}
