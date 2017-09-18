package co.com.newpandatv.adapter.home_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.model.entity.home_video_bean.PandaLiveLiuBean;

/**
 * Created by dell on 2017/9/13.
 */

public class MyGridAdapter3 extends BaseAdapter {
    Context context;
    List<PandaLiveLiuBean.DataBean.ChinaliveBean.ListBean> list;

    public MyGridAdapter3(Context context, List<PandaLiveLiuBean.DataBean.ChinaliveBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            convertView = View.inflate(context, R.layout.item_grid, null);
            vh.image= (ImageView) convertView.findViewById(R.id.grid_image);
            vh.text= (TextView) convertView.findViewById(R.id.grid_text);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        PandaLiveLiuBean.DataBean.ChinaliveBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getImage()).into(vh.image);
        vh.text.setText(listBean.getTitle());
        return convertView;
    }

    class ViewHolder{
        ImageView image;
        TextView text;
    }
}
