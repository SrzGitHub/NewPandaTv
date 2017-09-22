package co.com.newpandatv.view.fragment.pandalive_fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.adapter.MostAdapter;
import co.com.newpandatv.model.entity.LiveChinabean;
import co.com.newpandatv.model.entity.TaiShanBean;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodFragment extends Fragment {
    private ListView listView;
    private List<TaiShanBean.LiveBean> list=new ArrayList<>();
    private List<LiveChinabean.AlllistBean> alllistBeen=new ArrayList<>();
    private int position;
    private XRecyclerView recycler;
    private MostAdapter adapter;
    private int refreshTime = 0;
    private int times = 0;
    TaiShanBean liveBeans;
   private String url;
    @SuppressLint("ValidFragment")

    public GoodFragment(){

    }
    @SuppressLint("ValidFragment")

    public GoodFragment(String url) {
        this.url=url;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_good3, container, false);
        recycler = (XRecyclerView) view.findViewById(R.id.recycler);
        OkHttpUtils.getInstance().get(url, null, new MyNetWorkCallback<TaiShanBean>() {
                @Override
                public void onSuccess(TaiShanBean liveBean) {
                    liveBeans=liveBean;
                    list.addAll(liveBean.getLive());
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
                    adapter = new MostAdapter(list,getContext());
                    recycler.setLayoutManager(linearLayoutManager);
                    recycler.setAdapter(adapter);
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }
            });
//设置刷新的样式
        recycler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
//        recy.addHeaderView();
        //关闭上拉加载
        recycler.setLoadingMoreEnabled(false);
        recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新数据
                refreshTime ++;
                times = 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
                        if(liveBeans!=null){
                                list.addAll(liveBeans.getLive());
                        }else {
                            Toast.makeText(getContext(), "网络错误", Toast.LENGTH_SHORT).show();
                        }
                        adapter.notifyDataSetChanged();
                        recycler.refreshComplete();
                    }
                }, 3000);            //refresh data here
            }
            @Override
            public void onLoadMore() {
                //加载数据
                recycler.setNoMore(true);
            }
        });
        recycler.refresh();
        return view;
    }

}
