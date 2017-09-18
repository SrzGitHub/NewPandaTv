package co.com.newpandatv.adapter.daoadapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.adapter.AbsAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.dao.SQLBeans;

/**
 * Created by Administrator on 2017/9/17.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class SQLAdapter extends AbsAdapter<SQLBeans> {
    public SQLAdapter(Context context, int layoutId, List<SQLBeans> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, SQLBeans data) {
        TextView daoTitle = (TextView) holder.getView(R.id.daoTitle);
        TextView daoLen = (TextView) holder.getView(R.id.daoLen);
        TextView daoData = (TextView) holder.getView(R.id.daoDate);
        ImageView daoImg = (ImageView) holder.getView(R.id.daoImg);
        Glide.with(App.mContext).load(data.getUrlImg()).diskCacheStrategy(DiskCacheStrategy.ALL).into(daoImg);
        daoTitle.setText(data.getUrlTitle());
        daoLen.setText(data.getUrlLen());
        daoData.setText(data.getUrlData());



    }
}
