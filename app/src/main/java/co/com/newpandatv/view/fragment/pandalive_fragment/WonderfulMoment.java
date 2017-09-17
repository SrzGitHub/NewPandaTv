package co.com.newpandatv.view.fragment.pandalive_fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.WonderFuAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.WonderfuMomentBean;
import co.com.newpandatv.module.home.contract.WonderfulMomentContract;
import co.com.newpandatv.view.activity.VideoActivity;
import co.com.newpandatv.view.listview.MyListView;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static android.R.id.list;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class WonderfulMoment extends BaseFragment implements WonderfulMomentContract.View {


    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    WonderfulMomentContract.WonderPresenter presenter;
    List<WonderfuMomentBean.VideoBean> pandaLiveList;
    WonderFuAdapter wonderFuAdapter;

//    public static int PAGR = 1;
    @BindView(R.id.pandaPfl)
    PtrFrameLayout pandaPfl;
    private ProgressDialog dialog;

    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment_tab_page;
    }

    @Override
    protected void init(View view) {


    }

    @Override
    protected void loadData() {
        pandaLiveList = new ArrayList<>();

        dialog = new ProgressDialog(App.context);
        dialog.setMessage("正在加载");


        presenter.start();
        initDate();
    }

    private void initDate() {
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(App.context);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(App.context);

        pandaPfl.addPtrUIHandler(header);
        pandaPfl.addPtrUIHandler(footer);

        pandaPfl.setHeaderView(header);
        pandaPfl.setFooterView(footer);
        pandaPfl.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                Log.e("TAG", "onLoadMoreBegin:开始 加载更多");
                App.PAGER++;
                Log.e("TAG", "onLoadMoreBegin: "+App.PAGER);
                presenter.start();
                pandaPfl.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.e("TAG", "onLoadMoreBegin: 开始刷新");
                App.PAGER = 1;
                Log.e("TAG", "onRefreshBegin: "+App.PAGER);
                pandaLiveList.clear();
                presenter.start();
                pandaPfl.refreshComplete();
            }
        });

    }

    @Override
    protected void onShow() {
        super.onShow();




    }

    @Override
    public void setPresenter(WonderfulMomentContract.WonderPresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void showProgressDialog() {

        dialog.show();

    }

    @Override
    public void dismissDialog() {
        dialog.dismiss();
    }

    @Override
    public void setResult(WonderfuMomentBean wonderfuMomentBean) {


        pandaLiveList.addAll(wonderfuMomentBean.getVideo());
        Log.e("TAG", "setResult: " + pandaLiveList.size());
        wonderFuAdapter = new WonderFuAdapter(App.getContext(), R.layout.pandalive_list_item, pandaLiveList);
        pandaLiveListView.setAdapter(wonderFuAdapter);

//        wonderfuMomentBean.getVideo()
        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(App.context, VideoActivity.class);
                intent.putExtra("vid", pandaLiveList.get(i).getVid());
                intent.putExtra("title", pandaLiveList.get(i).getT());
                intent.putExtra("data",pandaLiveList.get(i).getPtime());
                intent.putExtra("len",pandaLiveList.get(i).getLen());
                intent.putExtra("urlIg",pandaLiveList.get(i).getImg());
                startActivity(intent);
            }
        });

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
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
}
