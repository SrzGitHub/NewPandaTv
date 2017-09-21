package co.com.newpandatv.livefragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.AbsAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.livefragment.contract_presenter.WatchAndChatModelContract;
import co.com.newpandatv.model.entity.WcheBean;
import co.com.newpandatv.model.entity.WcheString;
import co.com.newpandatv.view.listview.MyListView;


/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class WatchAndChat extends BaseFragment implements WatchAndChatModelContract.View{
    @BindView(R.id.wccListView)
    MyListView wccListView;
    Unbinder unbinder;
    @BindView(R.id.wchEdText)
    EditText wchEdText;
    @BindView(R.id.wchBut)
    Button wchBut;
    WatchAndChatModelContract.WatchAndPresenter watchAndPresenter;
    List<WcheBean.DataBean.ContentBean> watList = new ArrayList<>();
    AbsAdapter<WcheBean.DataBean.ContentBean> watAbsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.watchandchat;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

        watchAndPresenter.start();

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

    @OnClick(R.id.wchBut)
    public void onViewClicked() {

    }


    @Override
    public void setPresenter(WatchAndChatModelContract.WatchAndPresenter watchAndPresenter) {
        this.watchAndPresenter = watchAndPresenter;

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(WcheBean wcheBean) {
        watList.addAll(wcheBean.getData().getContent());
        watAbsAdapter = new AbsAdapter<WcheBean.DataBean.ContentBean>(App.mContext,R.layout.wche_list_item,watList) {
            @Override
            public void bindResponse(ViewHolder holder, WcheBean.DataBean.ContentBean data) {
                TextView wcName = (TextView) holder.getView(R.id.wcName);
                TextView wcLog = (TextView) holder.getView(R.id.wchLog);
                TextView wcTitle = (TextView) holder.getView(R.id.wchTitle);
                TextView wcTim = (TextView) holder.getView(R.id.wchTim);
                wcName.setText(data.getAuthor());
                wcTitle.setText(data.getMessage());
                wcLog.setText(data.getAuthorid());
                wcTim.setText(data.getDateline());


            }
        };
        wccListView.setAdapter(watAbsAdapter);

    }

    @Override
    public void showMessage(String msg) {

    }
}
