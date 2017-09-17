package co.com.newpandatv.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.TionAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.model.entity.TionBean;
import co.com.newpandatv.module.home.contract.TionModelContract;
import co.com.newpandatv.presenter.TionModelPresenter;
import co.com.newpandatv.view.listview.MyListView;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class InteracTionActivity extends BaseActivity implements TionModelContract.View{

    TionModelContract.TionPresenter tionPresenter ;
    List<TionBean.InteractiveBean> tionLists = new ArrayList<>();
    TionAdapter tionAdapter;
    @BindView(R.id.tion_list)
    MyListView tionList;
    @BindView(R.id.tion_pfl)
    PtrFrameLayout tionPfl;
    @BindView(R.id.tion_Dis)
    ImageView tionDis;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_interac_tion;

    }

    @Override
    protected void initView() {
        new TionModelPresenter(this);
        tionPresenter.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick(R.id.tion_Dis)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void setPresenter(TionModelContract.TionPresenter tionPresenter) {
        this.tionPresenter = tionPresenter;

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(TionBean tionBean) {
        tionLists.addAll(tionBean.getInteractive());
        tionAdapter = new TionAdapter(InteracTionActivity.this,R.layout.activity_interac_tion_item,tionLists);
        tionList.setAdapter(tionAdapter);
        tionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(InteracTionActivity.this,WebViewActivity.class);
                intent.putExtra("webUrl",tionLists.get(i).getUrl());
                intent.putExtra("title",tionLists.get(i).getTitle());
                intent.putExtra("img",tionLists.get(i).getImage());

                startActivity(intent);
            }
        });

    }

    @Override
    public void showMessage(String msg) {

    }
}
