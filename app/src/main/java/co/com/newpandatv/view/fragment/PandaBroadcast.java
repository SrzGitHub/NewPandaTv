package co.com.newpandatv.view.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.pdbc.MyAdapters;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.PandaBroadCastBean;
import co.com.newpandatv.model.entity.PandaBroadcastInfoBean;
import co.com.newpandatv.module.pandabroadcast.PDBCContract;
import co.com.newpandatv.module.pandabroadcast.PDBCPresenter;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import co.com.newpandatv.view.activity.PDBCActivity;
import co.com.newpandatv.view.activity.PDBCVedioActivity;

/*
 * 作者：Liyuxing on 2017/9/13 09:48
 * 邮箱：3226974614@qq.com
 */

public class PandaBroadcast extends BaseFragment implements PDBCContract.View {

    PDBCContract.Presenter presenter;

    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ProgressDialog dialog;
    private ImageView image;
    private MyAdapters adapter;
    String imageurlll = null;
    private ArrayList<PandaBroadcastInfoBean.ListBean> list;
    View view;

    @Override
    protected int getLayoutId() {
        return R.layout.pandabroadcasth_fragment;

    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        refreshLayout.setEnableLoadmore(true);
        refreshLayout.setLoadmoreFinished(false);
        refreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.start();
                refreshlayout.finishRefresh();
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                String path = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=2";
                OkHttpUtils.getInstance().get(path, null, new MyNetWorkCallback<PandaBroadcastInfoBean>() {
                    @Override
                    public void onSuccess(PandaBroadcastInfoBean pandaBroadcastInfoBean) {
                        List<PandaBroadcastInfoBean.ListBean> loadlist = pandaBroadcastInfoBean.getList();
                        list.addAll(loadlist);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });

                refreshlayout.finishLoadmore();
            }
        });

        presenter = new PDBCPresenter(this);
        presenter.start();
    }

    @Override
    protected void onHidden() {
        super.onHidden();
    }


    @Override
    public void setPresenter(PDBCContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {
    }

    @Override
    public void setResult(final PandaBroadCastBean pdbcBean) {


        if (imageurlll == null) {
            imageurlll = pdbcBean.getData().getBigImg().get(0).getImage();
            view = LayoutInflater.from(App.mContext).inflate(R.layout.head_image, null);
            image = view.findViewById(R.id.head_image);
            Glide.with(App.context).load(imageurlll).into(image);
            listview.addHeaderView(view);
        } else {
            imageurlll = null;
            imageurlll = pdbcBean.getData().getBigImg().get(0).getImage();
            Glide.with(App.context).load(imageurlll).into(image);
            listview.removeHeaderView(view);
            listview.addHeaderView(view);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(App.mContext, PDBCVedioActivity.class);
                intent.putExtra("url1", pdbcBean.getData().getBigImg().get(0).getUrl());
                intent.putExtra("title", pdbcBean.getData().getBigImg().get(0).getTitle());
                intent.putExtra("id1", pdbcBean.getData().getBigImg().get(0).getId());
                intent.putExtra("imageurl", pdbcBean.getData().getBigImg().get(0).getImage());
                startActivity(intent);
            }
        });
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setInfo(PandaBroadcastInfoBean pdbcInfoBean) {
        if (list == null) {
            list = (ArrayList<PandaBroadcastInfoBean.ListBean>) pdbcInfoBean.getList();
            adapter = new MyAdapters(App.mContext, list);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(App.mContext, PDBCActivity.class);
                    PandaBroadcastInfoBean.ListBean listBean = list.get(i - 1);
                    intent.putExtra("list", listBean);
                    startActivity(intent);
                }
            });
            Toast.makeText(getActivity(), "网络请求成功啦", Toast.LENGTH_SHORT).show();
        } else {
            list.clear();
            list.addAll(pdbcInfoBean.getList());
            adapter.notifyDataSetChanged();
            Toast.makeText(getActivity(), "下拉刷新成功啦", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

    }


}

