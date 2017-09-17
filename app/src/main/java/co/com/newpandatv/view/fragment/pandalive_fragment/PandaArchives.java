package co.com.newpandatv.view.fragment.pandalive_fragment;

import android.app.ProgressDialog;
import android.content.Intent;
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
import co.com.newpandatv.adapter.PandaArchivesAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.PandaArchivesBean;
import co.com.newpandatv.module.home.contract.PandaArchivesModeContract;
import co.com.newpandatv.view.activity.VideoActivity;
import co.com.newpandatv.view.listview.MyListView;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaArchives extends BaseFragment implements PandaArchivesModeContract.View {

    PandaArchivesModeContract.PandaArchivesPresenter pandaArchivesPresenter;
    List<PandaArchivesBean.VideoBean> pandaArcList = new ArrayList<>();
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    PandaArchivesAdapter pandaArchivesAdapter;
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
        pandaArchivesPresenter.start();
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
                pandaArchivesPresenter.start();
                pandaPfl.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.e("TAG", "onLoadMoreBegin: 开始加载");
                App.PAGER = 1;
                pandaArcList.clear();
                pandaArchivesPresenter.start();
                pandaPfl.refreshComplete();
            }
        });

    }
    @Override
    public void setPresenter(PandaArchivesModeContract.PandaArchivesPresenter pandaArchivesPresenter) {
        this.pandaArchivesPresenter = pandaArchivesPresenter;
    }

    @Override
    public void showProgressDialog() {
    }

    @Override
    public void dismissDialog() {
    }

    @Override
    public void setResult(PandaArchivesBean pandaArchivesBean) {

        pandaArcList.addAll(pandaArchivesBean.getVideo());

        pandaArchivesAdapter = new PandaArchivesAdapter(App.context, R.layout.pandalive_list_item, pandaArcList);
        pandaLiveListView.setAdapter(pandaArchivesAdapter);
        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(App.context, VideoActivity.class);
                intent.putExtra("vid", pandaArcList.get(i).getVid());
                intent.putExtra("title", pandaArcList.get(i).getT());
                intent.putExtra("data",pandaArcList.get(i).getPtime());
                intent.putExtra("len",pandaArcList.get(i).getLen());
                intent.putExtra("urlIg",pandaArcList.get(i).getImg());
                startActivity(intent);
            }
        });

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(App.context, msg, Toast.LENGTH_SHORT).show();

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
