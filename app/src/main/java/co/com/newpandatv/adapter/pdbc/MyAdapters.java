package co.com.newpandatv.adapter.pdbc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.model.entity.PandaBroadcastInfoBean;


/**
 * 作者：Liyuxing on 2017/9/14 21:16
 * 邮箱：3226974614@qq.com
 */

public class MyAdapters extends BaseAdapter {
    private Context context;
    private List<PandaBroadcastInfoBean.ListBean> listdata;


    public MyAdapters(Context context, List<PandaBroadcastInfoBean.ListBean> listdata) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.listdata = listdata;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub

        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = View.inflate(context, R.layout.item_pdbcinfo, null);

            holder.title = (TextView) convertView
                    .findViewById(R.id.tv_title);
            holder.time = (TextView) convertView
                    .findViewById(R.id.tv_time);
            holder.image = (ImageView) convertView
                    .findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final PandaBroadcastInfoBean.ListBean ss = listdata.get(position);
        holder.title.setText(ss.getTitle());
        holder.time.setText(ss.getFocus_date() + "");
        Glide.with(context).load(ss.getPicurl()).into(holder.image);


        return convertView;
    }

    static class ViewHolder {

        TextView title;
        TextView time;
        ImageView image;


    }

}
