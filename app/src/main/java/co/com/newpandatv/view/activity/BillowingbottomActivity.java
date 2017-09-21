package co.com.newpandatv.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.BillowingbottomAdapter;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.config.UMengUtls;
import co.com.newpandatv.model.entity.BillowingItemBean;
import co.com.newpandatv.module.bilowing.BillowingbottomContract;
import co.com.newpandatv.module.bilowing.BillowingbottomPresenter;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import co.com.newpandatv.view.listview.MyListView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static co.com.newpandatv.view.activity.VideoActivity.urls;

public class BillowingbottomActivity extends BaseActivity implements BillowingbottomContract.View {

    BillowingbottomContract.Presenter presenter;
    @BindView(R.id.fanhui_b)
    ImageView fanhuiB;
    @BindView(R.id.name_b)
    TextView nameB;
    @BindView(R.id.jiecao_b)
    JCVideoPlayer jiecaoB;
    @BindView(R.id.butImg)
    ImageView butImg;
    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.mBillowing_bottom_listview)
    MyListView mBillowingBottomListview;
    @BindView(R.id.ptrFrame_bb)
    PtrFrameLayout ptrFrameBb;
    @BindView(R.id.shoucang_b)
    ImageView shoucangB;
    @BindView(R.id.fenxiang_b)
    ImageView fenxiangB;

    int ABS = 0;
    private List<BillowingItemBean.VideoBean> mList = new ArrayList<>();
    ;
    private BillowingbottomAdapter adapter;
    private String desc;
    private String img;
    private String name;
    private String vsid;
    private String urll;
    private String aaa;

    int VIDEO = 0;

    @Override
    public void setPresenter(BillowingbottomContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setResult(BillowingItemBean billowingItemBean) {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, "请求失败" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_billowingbottom;
    }

    @Override
    protected void initView() {

        new BillowingbottomPresenter(this);
        presenter.start();

        //找到传递过来的这个id
        String id = getIntent().getStringExtra("id");
        adapter = new BillowingbottomAdapter(this, R.layout.billowing_bottom_item, mList);
        mBillowingBottomListview.setAdapter(adapter);
        //点击条目播放视频
        mBillowingBottomListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //加载视频
                jiecaoB.setUp("http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2017/09/19/41f6ae4c38c7478baabcf0944e0f31d1_h264418000nero_aac32.mp4", name);
            }
        });

        //进行请求
        OkHttpUtils.getInstance().get("http://api.cntv.cn/video/videolistById?vsid=" + id + "&n=7&serviceId=panda&o=desc&of=time&p=", null, new MyNetWorkCallback<BillowingItemBean>() {
            @Override
            public void onSuccess(BillowingItemBean billowingItemBean) {
                Log.e("TAG", "-------" + billowingItemBean.toString());
                mList.addAll(billowingItemBean.getVideo());

                //栏目介绍
                desc = billowingItemBean.getVideoset().get_$0().getDesc();
                //获取图片
                img = billowingItemBean.getVideo().get(0).getImg();
                //标题
                name = billowingItemBean.getVideoset().get_$0().getName();
                nameB.setText(name);

                //获得vsid
                vsid = billowingItemBean.getVideo().get(0).getVsid();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Log.e("TAG", "请求失败" + errorMsg);
            }
        });


        //设置点击隐藏 收藏 分享
        butImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ABS == 0) {
                    ABS = 1;
                    textName.setText(desc);
                    Log.e("ATG", textName.toString());
                    textName.setVisibility(View.VISIBLE);
                } else {
                    ABS = 0;
                    textName.setText("隐藏");
                    Log.e("ATG", textName.toString());
                    textName.setVisibility(View.GONE);
                }
            }
        });

        shoucangB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (VIDEO) {
                    case 0:
                        VIDEO = 1;
                        shoucangB.setImageResource(R.mipmap.collect_yes);
                        Toast.makeText(BillowingbottomActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        VIDEO = 0;
                        shoucangB.setImageResource(R.mipmap.collect_no);
                        Toast.makeText(BillowingbottomActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        fenxiangB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UMImage imgs = new UMImage(App.getContext(), img);
                UMVideo video = new UMVideo(urls);
                video.setTitle(name);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("PandaChannel");//视频的描述
                new ShareAction(BillowingbottomActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();
            }
        });

        initDate();

    }

    private void initDate() {
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(App.context);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(App.context);

        ptrFrameBb.addPtrUIHandler(header);
        ptrFrameBb.addPtrUIHandler(footer);

        ptrFrameBb.setHeaderView(header);
        ptrFrameBb.setFooterView(footer);
        ptrFrameBb.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                Log.e("TAG", "onLoadMoreBegin:开始 加载更多");
                App.PAGER++;
                presenter.start();
                ptrFrameBb.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.e("TAG", "onLoadMoreBegin: 开始加载");
                App.PAGER = 1;
                mList.clear();
                presenter.start();
                ptrFrameBb.refreshComplete();
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        jiecaoB.releaseAllVideos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick(R.id.fanhui_b)
    public void onViewClicked() {
        finish();
    }
}
