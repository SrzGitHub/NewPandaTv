package co.com.newpandatv.adapter.pdbc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.model.entity.PandaBroadcastInfoBean;


/**
 * 作者：Liyuxing on 2017/9/14 10:56
 * 邮箱：3226974614@qq.com
 */

public class MyRecycAdapter extends RecyclerView.Adapter<MyRecycAdapter.ViewHolder> {

    private Context context;
    private List<PandaBroadcastInfoBean.ListBean> data;

    public MyRecycAdapter(Context content, List<PandaBroadcastInfoBean.ListBean> data) {
        this.context = content;
        this.data = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_pdbcinfo, parent, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        itemview.setLayoutParams(layoutParams);
        ViewHolder viewHolder = new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PandaBroadcastInfoBean.ListBean mm = data.get(position);
        holder.title.setText(mm.getTitle());
        holder.time.setText(mm.getFocus_date()+"");
        Glide.with(context).load(mm.getPicurl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView time;
        private ImageView image;
        //private   View   recycleItemview;

        public ViewHolder(View itemView) {
            super(itemView);

            //recycleItemview=itemView;
            title = (TextView) itemView.findViewById(R.id.tv_title);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
