package co.com.newpandatv.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.com.newpandatv.R;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class LiveFragmentAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> mLists;

    public LiveFragmentAdapter(Context context, ArrayList<String> mLists) {
        this.context = context;
        this.mLists = mLists;
    }

    @Override
    public int getCount() {
        return mLists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.itm,null);
        TextView liveNAMES= view.findViewById(R.id.liveNAMES);
        liveNAMES.setVisibility(View.GONE);
        liveNAMES.setText(mLists.get(i));

        return view;
    }
}
