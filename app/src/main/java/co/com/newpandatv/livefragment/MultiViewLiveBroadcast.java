package co.com.newpandatv.livefragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.com.newpandatv.MainActivity;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.MutioViewAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.MultioLeBeans;
import co.com.newpandatv.module.home.contract.MultioLeModelContract;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class MultiViewLiveBroadcast extends BaseFragment implements MultioLeModelContract.View{

    @BindView(R.id.mlbRlv)
    RecyclerView mlbRlv;
    Unbinder unbinder;
    MultioLeModelContract.MultioLePresnter multioLePresnter;
    List<MultioLeBeans.ListBean> muList = new ArrayList<>();
    MutioViewAdapter mutioViewAdapter;



    @Override
    protected int getLayoutId() {
        Log.e("TAG", "getLayoutId: "+"getLayoutId");
        return R.layout.multiviewllivebroadcast_fragment;

    }

    @Override
    protected void init(View view) {

        Log.e("TAG", "init: "+view);
    }

    @Override
    protected void loadData() {

        Log.e("TAG", "loadData: ");
        multioLePresnter.start();

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

    @Override
    public void setPresenter(MultioLeModelContract.MultioLePresnter multioLePresnter) {
        this.multioLePresnter =multioLePresnter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }


    @Override
    protected void onHidden() {
        super.onHidden();
        if(isHidden()&&mutioViewAdapter!=null){
            mutioViewAdapter.notifyDataSetChanged();
        }else {
            multioLePresnter.start();
        }

    }

    @Override
    public void setResult(MultioLeBeans multioLeBeans) {


        muList.addAll(multioLeBeans.getList());
        mlbRlv.setLayoutManager(new GridLayoutManager(App.context, 3));
        mutioViewAdapter = new MutioViewAdapter(App.context,muList);
        mlbRlv.setAdapter(mutioViewAdapter);
        mutioViewAdapter.setOnClickLisener(new MutioViewAdapter.OnClickListener() {
            @Override
            public void onclicklistener(int pos) {

                Toast.makeText(App.mContext,"接口没找到！",Toast.LENGTH_SHORT).show();

            }
        });

    }



    @Override
    public void showMessage(String msg) {

    }


}
