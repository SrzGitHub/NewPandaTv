package co.com.newpandatv.view.fragment.pandalive_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import co.com.newpandatv.view.listview.MyListView;
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


    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment_tab_page;
    }

    @Override
    protected void init(View view) {


    }

    @Override
    protected void loadData() {
        pandaLiveList=new ArrayList<>();
        presenter.start();
    }

    @Override
    public void setPresenter(WonderfulMomentContract.WonderPresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(WonderfuMomentBean wonderfuMomentBean) {
        pandaLiveList.addAll(wonderfuMomentBean.getVideo());
        Log.e("TAG", "setResult: "+pandaLiveList.size());
        wonderFuAdapter = new WonderFuAdapter(App.context,R.layout.pandalive_list_item,pandaLiveList);
        pandaLiveListView.setAdapter(wonderFuAdapter);

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
