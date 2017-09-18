package co.com.newpandatv.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.model.entity.TionBean;

/**
 * Created by Administrator on 2017/9/16.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class TionAdapter extends AbsAdapter<TionBean.InteractiveBean> {
    public TionAdapter(Context context, int layoutId, List<TionBean.InteractiveBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, TionBean.InteractiveBean data) {
        TextView tion_Name = (TextView) holder.getView(R.id.tion_Name);
        ImageView tion_Img = (ImageView) holder.getView(R.id.tion_Img);

        Glide.with(App.mContext).load(data.getImage()).fitCenter().into(tion_Img);
        tion_Name.setText(data.getTitle());
    }
}
