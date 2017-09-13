package co.com.newpandatv.view.fragment.pandalive_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.AbsAdapter;
import co.com.newpandatv.adapter.TopAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.TopBean;
import co.com.newpandatv.module.home.contract.TopContract;
import co.com.newpandatv.view.listview.MyListView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class Panda_Top_List extends BaseFragment implements TopContract.View {

    TopContract.TopPresnter topPresnter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<TopBean.VideoBean> topList = new ArrayList<>();
    TopAdapter topAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment_tab_page;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        topPresnter.start();
    }

    @Override
    public void setPresenter(TopContract.TopPresnter topPresnter) {
        this.topPresnter = topPresnter;

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(TopBean topBean) {
        topList.addAll(topBean.getVideo());
        topAdapter = new TopAdapter(App.context,R.layout.pandalive_list_item,topList);
        pandaLiveListView.setAdapter(topAdapter);


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
