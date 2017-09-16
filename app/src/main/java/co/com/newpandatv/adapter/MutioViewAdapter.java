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
import co.com.newpandatv.model.entity.MultioLeBeans;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class MutioViewAdapter extends RecyclerView.Adapter<MutioViewAdapter.ViewHodler> {

    Context context;
    List<MultioLeBeans.ListBean> muList;

    public MutioViewAdapter(Context context, List<MultioLeBeans.ListBean> muList) {
        this.context = context;
        this.muList = muList;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hodelrtwo,parent,false);


        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {
        Glide.with(context).load(muList.get(position).getImage()).fitCenter().into(holder.twoImg);
        holder.twoTitle.setText(muList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return muList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        ImageView twoImg;
        TextView twoTitle;

        public ViewHodler(View itemView) {
            super(itemView);
            twoImg = itemView.findViewById(R.id.twoImg);
            twoTitle =itemView.findViewById(R.id.twoTitle);

        }
    }
}
