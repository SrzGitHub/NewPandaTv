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
 * Created by dell on 2017/9/14.
 */

public class MyGridAdapter2 extends BaseAdapter {
    Context context;
    List<PandaLiveLiuBean.DataBean.AreaBean.ListscrollBean> listscroll;

    public MyGridAdapter2(Context context, List<PandaLiveLiuBean.DataBean.AreaBean.ListscrollBean> listscroll) {
        this.context = context;
        this.listscroll = listscroll;
    }

    @Override
    public int getCount() {
        return listscroll.size();
    }

    @Override
    public Object getItem(int position) {
        return listscroll.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyGridAdapter2.ViewHolder vh;
        if(convertView==null){
            vh=new MyGridAdapter2.ViewHolder();
            convertView = View.inflate(context, R.layout.item_grid2, null);
            vh.grid2_image = (ImageView) convertView.findViewById(R.id.grid2_image);
            vh.grid2_text = (TextView) convertView.findViewById(R.id.grid2_text);
            vh.grid2_text2 = (TextView) convertView.findViewById(R.id.grid2_text2);
            convertView.setTag(vh);
        }else {
            vh = (MyGridAdapter2.ViewHolder) convertView.getTag();
        }
        PandaLiveLiuBean.DataBean.AreaBean.ListscrollBean listscrollBean = listscroll.get(position);
        Glide.with(context).load(listscrollBean.getImage()).into(vh.grid2_image);
        vh.grid2_text.setText(listscrollBean.getTitle());
        vh.grid2_text2.setText("2017-09-13");
        return convertView;
    }
    class ViewHolder{
        ImageView grid2_image;
        TextView grid2_text,grid2_text2;
    }
}
