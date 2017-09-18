package app.demo.view.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

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
    private List<PandaBroadCastBean.DataBean.BigImgBean> imageurl = new ArrayList<PandaBroadCastBean.DataBean.BigImgBean>();
    private MyAdapters adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.pandabroadcasth_fragment;

    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

//        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh(RefreshLayout refreshlayout) {
//                refreshlayout.finishRefresh(2000);
//            }
//        });
//        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
//            @Override
//            public void onLoadmore(RefreshLayout refreshlayout) {
//                refreshlayout.finishLoadmore(2000);
//            }
//        });
//
//
//        refreshLayout.setRefreshFooter(new BallPulseFooter(App.context).setSpinnerStyle(SpinnerStyle.Scale));

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
        dialog = new ProgressDialog(App.context);
        dialog.show();
    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(PandaBroadCastBean pdbcBean) {
        showProgressDialog();
        List<PandaBroadCastBean.DataBean.BigImgBean> bigImg = pdbcBean.getData().getBigImg();
        imageurl.addAll(bigImg);
        View view = LayoutInflater.from(App.context).inflate(R.layout.head_image, null);
        image = (ImageView) view.findViewById(R.id.head_image);
        Log.e("TAG", imageurl.toString());
        final String image1 = imageurl.get(0).getImage();
        Log.e("TAG", image1);
        Glide.with(App.context).load(image1).into(image);
        listview.addHeaderView(view);
        dialog.dismiss();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(App.context, PDBCVedioActivity.class);
                intent.putExtra("url1", imageurl.get(0).getUrl());
                intent.putExtra("title", imageurl.get(0).getTitle());
//                intent.putExtra("imageurl",image1);
                intent.putExtra("id1", imageurl.get(0).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setInfo(PandaBroadcastInfoBean pdbcInfoBean) {
//        setResult();
        List<PandaBroadcastInfoBean.ListBean> list1 = pdbcInfoBean.getList();
        final List<PandaBroadcastInfoBean.ListBean> list = new ArrayList<PandaBroadcastInfoBean.ListBean>();

        list.addAll(list1);
        adapter = new MyAdapters(App.context, list);

        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(App.context, PDBCActivity.class);
                PandaBroadcastInfoBean.ListBean listBean = list.get(i - 1);
                intent.putExtra("list", listBean);
                startActivity(intent);
            }
        });


    }

    @Override
    public void setFootInfo(PandaBroadcastInfoBean pdbcInfoBean) {
        List<PandaBroadcastInfoBean.ListBean> list2 = pdbcInfoBean.getList();
        List<PandaBroadcastInfoBean.ListBean> list = new ArrayList<PandaBroadcastInfoBean.ListBean>();

        list.addAll(list2);
        View view = LayoutInflater.from(App.context).inflate(R.layout.foot_view, null);
        ListView lv = (ListView) view.findViewById(R.id.list_foot);
        final MyAdapters adapter = new MyAdapters(App.context, list);
        lv.setAdapter(adapter);

//        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
//            public int visibleLastIndex;
//            public int visibleItemCount;
//            @Override
//            public void onScrollStateChanged(AbsListView absListView, int i) {
//                int itemsLastIndex = adapter.getCount() - 1;    //数据集最后一项的索引
//                int lastIndex = itemsLastIndex + 1;             //加上底部的loadMoreView项
//                if (!isload&&scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == lastIndex) {
//                    //如果是自动加载,可以在这里放置异步加载数据的代码
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            List<String> moredata = loadmoreData();
//                            data.addAll(moredata);
//                            adapter.notifyDataSetChanged(); //数据集变化后,通知adapter
////                                     loadMoreBtn.setText("加载更多");    //恢复按钮文字
//                            isload=false;
//                        }
//                    }, 4000);
//                }
//            }

//            @Override
//            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
//                this.visibleItemCount = visibleItemCount;
//                visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
//
//            }
//        });

//        newList.setLoadMoreListener(new LoadMoreListener() {
//            @Override
//            public void onLoadMore() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        if (page < 30) {
//                            page++;
//                            setGets();
//                            xWenAdapter.notifyDataSetChanged();
//                            //设置loading完成
//                            newList.loadMoreComplete();
//                        } else {
//                            //设置加载到底
//                            newList.loadMoreEnd();
//                        }
//
//                    }
//                },1500);
//            }
//        });



        listview.addHeaderView(view);
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}

