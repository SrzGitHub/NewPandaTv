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
import co.com.newpandatv.model.entity.WcheBean;
import co.com.newpandatv.model.entity.WcheString;
import co.com.newpandatv.view.listview.MyListView;


/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class WatchAndChat extends BaseFragment {
    @BindView(R.id.wccListView)
    MyListView wccListView;
    Unbinder unbinder;
    @BindView(R.id.wchEdText)
    EditText wchEdText;
    @BindView(R.id.wchBut)
    Button wchBut;

    List<WcheBean>  wchList = new ArrayList<>();
    AbsAdapter<WcheBean> absAdapterWch;

    @Override
    protected int getLayoutId() {
        return R.layout.watchandchat;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

        for (int i = 0; i < 10; i++) {
            WcheBean wcheBean = new WcheBean();
            wcheBean.setName(WcheString.NAME[i]);
            wcheBean.setLog(WcheString.LOG[i]);
            wcheBean.setTim(WcheString.TIM[i]);
            wcheBean.setTitle(WcheString.TITLE[i]);
            wchList.add(wcheBean);

        }


        absAdapterWch = new AbsAdapter<WcheBean>(App.context,R.layout.wche_list_item,wchList) {
            @Override
            public void bindResponse(ViewHolder holder, WcheBean data) {
                TextView wchName = (TextView) holder.getView(R.id.wcName);
                TextView wchTitle = (TextView) holder.getView(R.id.wchTitle);
                TextView wchTim = (TextView) holder.getView(R.id.wchTim);
                TextView wchLog = (TextView) holder.getView(R.id.wchLog);

                wchName.setText(data.getName());
                wchLog.setText(data.getLog());
                wchTim.setText(data.getTim());
                wchTitle.setText(data.getTitle());

            }
        };
            wccListView.setAdapter(absAdapterWch);
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


}
