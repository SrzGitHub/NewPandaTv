package co.com.newpandatv.view.fragment.pandalive_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.PandaThoseThingsBean;
import co.com.newpandatv.module.home.contract.PandaThoseThingsModelContract;
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

public class PandaThoseThings extends BaseFragment implements PandaThoseThingsModelContract.View {

    PandaThoseThingsModelContract.ThosePresnter thosePresnter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<PandaThoseThingsBean.VideoBean> thoseList = new ArrayList<>();
    AbsAdapter<PandaThoseThingsBean.VideoBean> absAdapter;
    @BindView(R.id.pandaPfl)
    PtrFrameLayout pandaPfl;


    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment_tab_page;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {



        thosePresnter.start();
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
                Log.e("TAG", "onLoadMoreBegin:开始加载更多");
                App.PAGER++;
                thosePresnter.start();
                pandaPfl.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.e("TAG", "onLoadMoreBegin: 开始刷新");
                App.PAGER = 1;
                thoseList.clear();
                thosePresnter.start();
                pandaPfl.refreshComplete();
            }
        });

    }

    @Override
    public void setPresenter(PandaThoseThingsModelContract.ThosePresnter thosePresnter) {
        this.thosePresnter = thosePresnter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(PandaThoseThingsBean pandaThoseThingsBean) {

        thoseList.addAll(pandaThoseThingsBean.getVideo());


        absAdapter = new AbsAdapter<PandaThoseThingsBean.VideoBean>(App.mContext, R.layout.pandalive_list_item, thoseList) {
            @Override
            public void bindResponse(ViewHolder holder, PandaThoseThingsBean.VideoBean data) {
                ImageView donImg = (ImageView) holder.getView(R.id.pandaLiveImg);
                TextView donLen = (TextView) holder.getView(R.id.pandaLiveLen);
                TextView donTitle = (TextView) holder.getView(R.id.pandaLiveTitle);
                TextView donDate = (TextView) holder.getView(R.id.pandaLiveDate);

                Glide.with(App.mContext).load(data.getImg()).into(donImg);
                donDate.setText(data.getPtime());
                donLen.setText(data.getLen());
                donTitle.setText(data.getT());
            }
        };
        pandaLiveListView.setAdapter(absAdapter);


        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(App.context, VideoActivity.class);
                intent.putExtra("vid", thoseList.get(i).getVid());
                intent.putExtra("title", thoseList.get(i).getT());
                intent.putExtra("data",thoseList.get(i).getPtime());
                intent.putExtra("len",thoseList.get(i).getLen());
                intent.putExtra("urlIg",thoseList.get(i).getImg());
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
