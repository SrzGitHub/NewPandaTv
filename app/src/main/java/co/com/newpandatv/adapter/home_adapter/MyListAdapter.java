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
import co.com.newpandatv.model.entity.home_video_bean.BillowingvideoLiuBean;

/**
 * Created by dell on 2017/9/14.
 */

public class MyListAdapter extends BaseAdapter {
    Context context;
    List<BillowingvideoLiuBean.ListBean> list;

    public MyListAdapter(Context context, List<BillowingvideoLiuBean.ListBean> list) {
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
            convertView = View.inflate(context, R.layout.item_list, null);
            vh.image = (ImageView) convertView.findViewById(R.id.list_five_image);
            vh.text1= (TextView) convertView.findViewById(R.id.list_five_text);
            vh.text2= (TextView) convertView.findViewById(R.id.list_five_text2);
            vh.textTime= (TextView) convertView.findViewById(R.id.item_list_time);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        BillowingvideoLiuBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getImage()).into(vh.image);
        vh.textTime.setText(listBean.getVideoLength());
        vh.text1.setText(listBean.getTitle());
        vh.text2.setText(listBean.getDaytime());
        return convertView;
    }

    class ViewHolder{
        ImageView image;
        TextView text1,text2,textTime;
    }
}
