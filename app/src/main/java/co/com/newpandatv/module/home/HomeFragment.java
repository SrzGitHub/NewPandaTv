package co.com.newpandatv.module.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.home_adapter.HomeAdapter;
import co.com.newpandatv.adapter.home_adapter.SpaceItemDecoration;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.home_video_bean.PandaLiveLiuBean;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

public class HomeFragment extends BaseFragment implements HomeContract.View {

    HomeContract.Presenter presenter;
    @BindView(R.id.recy_home)
    XRecyclerView recy;
    Unbinder unbinder   ;
    List<PandaLiveLiuBean.DataBean> listHome=new ArrayList<>();
    private HomeAdapter homeAdapter;

    private int refreshTime = 0;
    private int times = 0;
    PandaLiveLiuBean pan;


    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

        presenter.start();




        initOk();
        //设置刷新的样式
        recy.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
//        recy.addHeaderView();
        //关闭上拉加载
        recy.setLoadingMoreEnabled(false);
        recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新数据
                refreshTime ++;
                times = 0;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listHome.clear();
                        if(pan!=null){
                            for (int i = 0; i < 6; i++) {

                                listHome.add(pan.getData());
                            }
                        }else {
//                            Toast.makeText(getContext(), "刷新失败", Toast.LENGTH_SHORT).show();
                            initOk();


                        }
//                        if(listHome.size()==0){
//                            Toast.makeText(getContext(), "刷新失败", Toast.LENGTH_SHORT).show();
//                        }
                        homeAdapter.notifyDataSetChanged();
                        recy.refreshComplete();
                    }
                }, 2000);            //refresh data here

            }

            @Override
            public void onLoadMore() {
                //加载数据
                recy.setNoMore(true);
            }
        });

        recy.refresh();
        //RecyclerView的item的间距
        recy.addItemDecoration(new SpaceItemDecoration(20,30));
    }

    private void initOk() {
        OkHttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/PAGE14501749764071042/index.json", null, new MyNetWorkCallback<PandaLiveLiuBean>() {
            @Override
            public void onSuccess(PandaLiveLiuBean pandaLiveLiuBean) {
                pan= pandaLiveLiuBean;
                for (int i = 0; i < 6; i++) {
                    listHome.add(pandaLiveLiuBean.getData());
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

        homeAdapter = new HomeAdapter(getContext(),listHome);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recy.setLayoutManager(manager);
        recy.setAdapter(homeAdapter);
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(PandaLiveLiuBean pandaLiveLiuBean) {


    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                App.context.onBackPressed();
//                getActivity().onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
