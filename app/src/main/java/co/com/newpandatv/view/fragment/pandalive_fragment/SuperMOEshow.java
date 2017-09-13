package co.com.newpandatv.view.fragment.pandalive_fragment;

import android.os.Bundle;
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
import co.com.newpandatv.adapter.SuperMOEshowAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.SuperMOEshowBean;
import co.com.newpandatv.module.home.contract.SuperMOEshowContract;
import co.com.newpandatv.view.listview.MyListView;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class SuperMOEshow extends BaseFragment implements SuperMOEshowContract.View {

    SuperMOEshowContract.SuperPresnter superPresnter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<SuperMOEshowBean.VideoBean> showList = new ArrayList<>();
    SuperMOEshowAdapter superMOEshowAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment_tab_page;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

        superPresnter.start();

    }

    @Override
    public void setPresenter(SuperMOEshowContract.SuperPresnter superPresnter) {
        this.superPresnter = superPresnter;

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(SuperMOEshowBean superMOEshowBean) {
    showList.addAll(superMOEshowBean.getVideo());
        superMOEshowAdapter = new SuperMOEshowAdapter(App.context,R.layout.pandalive_list_item,showList);
        pandaLiveListView.setAdapter(superMOEshowAdapter);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();

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
