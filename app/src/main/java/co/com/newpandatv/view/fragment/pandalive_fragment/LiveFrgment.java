package co.com.newpandatv.view.fragment.pandalive_fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.LiveFragmentAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.livefragment.MultiViewLiveBroadcast;
import co.com.newpandatv.livefragment.WatchAndChat;
import co.com.newpandatv.livefragment.contract_presenter.WatchAndChatModelPresenter;
import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.module.home.contract.LiveFrgmentModelContract;
import co.com.newpandatv.presenter.MultioLeModelPresnter;
import co.com.newpandatv.view.listview.MyListView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static co.com.newpandatv.R.id.but2;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class LiveFrgment extends BaseFragment implements LiveFrgmentModelContract.View{

    int a = 0;
    LiveFrgmentModelContract.LivePresnter livePresnter;


    @BindView(R.id.liveJCV)
    JCVideoPlayer liveJCV;
    @BindView(R.id.pandaTitle)
    TextView pandaTitle;
    @BindView(R.id.pandaZK)
    ImageView pandaZK;
    TextView zkName;
    Unbinder unbinder;

    MultiViewLiveBroadcast broadcast;
    WatchAndChat watchAndChat;
    LinearLayout layout;
    ArrayList<String> mLists = new ArrayList<>();
    LiveFragmentAdapter fragmentAdapter;


    String ss = "http://117.23.6.54/vod.cntv.lxdns.com/flash/mp4video62/TMS/2017/09/15/11a617225f2f4c8683fe3443706d6550_h264418000nero_aac32.mp4?wshc_tag=0&wsts_tag=59bb7bfa&wsid_tag=6a254920&wsiphost=ipdbm";
    @BindView(R.id.liveFment)
    MyListView liveFment;
    Button but1;
    Button but2;


    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fmt;
    }

    @Override
    protected void init(View view) {

        liveFment.addHeaderView(View.inflate(App.context, R.layout.live_item_add, null));
       zkName = view.findViewById(R.id.zkName);
        layout = view.findViewById(R.id.layout);
        but1 = view.findViewById(R.id.but1);
        but2 = view.findViewById(R.id.but2);

         MultiViewLiveBroadcast broadcasta = new MultiViewLiveBroadcast();
        new MultioLeModelPresnter(broadcasta);
        FragmentManager manager = getActivity().getSupportFragmentManager();
         FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.addFragMent,broadcasta);
        transaction.commit();

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction2 = manager.beginTransaction();
                shouFragMent(transaction2);
                if (broadcast==null){
                    broadcast = new MultiViewLiveBroadcast();
                    new MultioLeModelPresnter(broadcast);
                    transaction2.add(R.id.addFragMent,broadcast);
                }else {
                    transaction2.show(broadcast);
                }
                transaction2.commit();
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveFment.setItemsCanFocus(true);
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction1 = manager.beginTransaction();
                shouFragMent(transaction1);
                if (watchAndChat==null){
                    watchAndChat = new WatchAndChat();
                    new WatchAndChatModelPresenter(watchAndChat);
                    transaction1.add(R.id.addFragMent,watchAndChat);
                }else {
                    transaction1.show(watchAndChat);
                }
                transaction1.commit();
            }
        });


    }

    @Override
    protected void loadData() {
        for (int i = 0; i < 10; i++) {
            mLists.add("这是该隐藏的");
        }
        fragmentAdapter = new LiveFragmentAdapter(App.context,mLists);
        liveFment.setAdapter(fragmentAdapter);
        livePresnter.start();
        layout.setVisibility(View.GONE);


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


    @OnClick({R.id.pandaTitle, R.id.pandaZK})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.pandaTitle:
                break;
            case R.id.pandaZK:

                switch (a) {
                    case 0:
                        a = 1;
                        pandaZK.setImageResource(R.mipmap.live_china_detail_up);
                        layout.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        a = 0;
                        pandaZK.setImageResource(R.mipmap.live_china_detail_down);
                        layout.setVisibility(View.GONE);
                        break;
                }
                break;



        }

    }


    public void shouFragMent(FragmentTransaction transaction){
        if (broadcast!=null){
            transaction.hide(broadcast);

        }
        if (watchAndChat!=null){
            transaction.hide(watchAndChat);
        }
    }

    @Override
    public void setPresenter(LiveFrgmentModelContract.LivePresnter livePresnter) {
        this.livePresnter = livePresnter;
    }

    @Override
    public void showProgressDialog() {
    }

    @Override
    public void dismissDialog() {
    }

    @Override
    public void setResult(PandaLiveBean pandaLiveBean) {


        pandaTitle.setText("[正在直播]" + pandaLiveBean.getLive().get(0).getTitle());

        liveJCV.setUp(ss, "", true);

        zkName.setText(pandaLiveBean.getLive().get(0).getBrief());

    }

    @Override
    public void showMessage(String msg) {
        Log.e("TAG", "showMessage: "+msg);
        Toast.makeText(App.context, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


}
