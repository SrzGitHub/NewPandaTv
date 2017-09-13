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
import co.com.newpandatv.adapter.DonAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.DonBean;
import co.com.newpandatv.module.home.contract.DonModelContract;
import co.com.newpandatv.view.listview.MyListView;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class DontLetTheMale extends BaseFragment implements DonModelContract.View {

    DonModelContract.DonPresnter donPresnter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<DonBean.VideoBean> donList   = new ArrayList<>() ;
    DonAdapter donAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment_tab_page;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

        donPresnter.start();
    }

    @Override
    public void setPresenter(DonModelContract.DonPresnter donPresnter) {
        this.donPresnter = donPresnter;

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(DonBean donBean) {
        donList.addAll(donBean.getVideo());
        donAdapter = new DonAdapter(App.context,R.layout.pandalive_list_item,donList);
        pandaLiveListView.setAdapter(donAdapter);

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
