package co.com.newpandatv.view.fragment;

import android.content.Intent;
import android.os.Bundle;
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
import co.com.newpandatv.adapter.BillowingAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.model.entity.BillowingVideoBean;
import co.com.newpandatv.module.bilowing.BilowingVideoContract;
import co.com.newpandatv.view.activity.Billow_moveActivity;
import co.com.newpandatv.view.activity.BillowingbottomActivity;
import co.com.newpandatv.view.listview.MyListView;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class BillowingVideo extends BaseFragment implements BilowingVideoContract.View {

    Unbinder unbinder;
    @BindView(R.id.billowListView)
    MyListView billowListView;
    private List<BillowingVideoBean.ListBean> mList = new ArrayList();

    private BillowingAdapter billowingAdapter;

    BilowingVideoContract.Presenter presenter;
    private ImageView addImg;
    private TextView addTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.billowingvideo_fragment;
    }

    @Override
    protected void init(View view) {

//        view = LayoutInflater.from(App.context).inflate(R.layout.imglayout,null);
//        view = LayoutInflater.from(App.context).inflate(R.layout.imglayout,null);
        billowListView.addHeaderView(View.inflate(App.context,R.layout.imglayout,null));
        addImg = view.findViewById(R.id.addImg);
        addTitle = view.findViewById(R.id.addTitle);

    }

    @Override
    protected void loadData() {

       presenter.start();

    }

    @Override
    public void setPresenter(BilowingVideoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(BillowingVideoBean billowing) {
        mList.addAll(billowing.getList());

        final String pid = billowing.getBigImg().get(0).getPid();

        final String image = billowing.getBigImg().get(0).getImage();
        Glide.with(App.context).load(image).into(addImg);
        addTitle.setText(billowing.getBigImg().get(0).getTitle());

        //一张图片的
        addImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(App.context, Billow_moveActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });

        billowingAdapter = new BillowingAdapter(App.context,R.layout.billow_item,mList);
        billowListView.setAdapter(billowingAdapter);
        billowListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(App.context, BillowingbottomActivity.class);
//                intent.putExtra("vid",mList.get(i).get
                startActivity(intent);
            }
        });


    }

    @Override
    public void showMessage(String msg) {

        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onHidden() {
        super.onHidden();
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
