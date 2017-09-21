package co.com.newpandatv.adapter;

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
import co.com.newpandatv.model.entity.TaiShanBean;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/**
 * Created by lenovo on 2017/9/16.
 */

public class MostAdapter extends RecyclerView.Adapter<MostAdapter.MyViewHolder> {
    private List<TaiShanBean.LiveBean> list;
    private Context context;

    public MostAdapter(List<TaiShanBean.LiveBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.taishan_fragment, null);
        MyViewHolder vh=new MyViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.textView.setText("[正在直播]"+list.get(position).getTitle());
            holder.textView7.setText(list.get(position).getBrief());
            holder.textView7.setVisibility(View.GONE);
            holder.livevideogao.setUp("http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel454.m3u8?AUTH=UjGaAl/PgU0SwsC9CqaVQqbLd3XWYZ92XvcnsGQa3m0c8e533V5xNN7lTMWlZ7tOtJBbLwW9Bey0lSaZPzDZxg=="
                    ,list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImage()).into(holder.livevideogao.ivThumb);
            holder.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int visibility = holder.textView7.getVisibility();
                    if (visibility == View.GONE) {
                        holder.textView7.setVisibility(View.VISIBLE);
                        holder.imageView2.setImageResource(R.mipmap.com_facebook_tooltip_black_topnub);

                    } else {
                        holder.textView7.setVisibility(View.GONE);
                        holder.imageView2.setImageResource(R.mipmap.com_facebook_tooltip_black_bottomnub);
                    }
                }
            });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

         private final View view;
        private final JCVideoPlayer livevideogao;
        private final ImageView imageView2;
        private final TextView textView;
        private final TextView textView7;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            livevideogao =  (JCVideoPlayer)itemView.findViewById(R.id.livevideogao);
            imageView2 = (ImageView) itemView.findViewById(R.id.imageViewxx);
            textView = (TextView) itemView.findViewById(R.id.textView);
            textView7 = (TextView) itemView.findViewById(R.id.textView7);
        }

    }
}
