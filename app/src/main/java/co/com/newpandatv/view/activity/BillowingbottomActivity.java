package co.com.newpandatv.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.BillowingbottomAdapter;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.model.entity.BillowingItemBean;
import co.com.newpandatv.model.entity.BillowingMoveBean;
import co.com.newpandatv.module.bilowing.BillowingActivityContract;
import co.com.newpandatv.module.bilowing.BillowingActivityPresenter;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import co.com.newpandatv.view.listview.MyListView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class BillowingbottomActivity extends BaseActivity implements BillowingActivityContract.View {


    @BindView(R.id.butImg)
    ImageView butImg;
    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.mBillowing_bottom_listview)
    MyListView mBillowingBottomListview;

    @BindView(R.id.jiecao_b)
    JCVideoPlayer jiecaoB;
    @BindView(R.id.fanhui_b)
    ImageView fanhuiB;
    @BindView(R.id.name_b)
    TextView nameB;
    private BillowingActivityContract.Presenter presenter;
    int ABS = 0;

    private List<BillowingItemBean.VideoBean> list = new ArrayList<>();
    private String url;
    private String desc;
    private String img;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_billowingbottom;
    }

    @Override
    protected void initView() {
        presenter = new BillowingActivityPresenter(this);
        presenter.start();


        String id = getIntent().getStringExtra("id");
        Log.e("TAG", "id: " + id);

        OkHttpUtils.getInstance().get("http://api.cntv.cn/video/videolistById?vsid=" + id + "&n=7&serviceId=panda&o=desc&of=time&p=", null, new MyNetWorkCallback<BillowingItemBean>() {
            @Override
            public void onSuccess(BillowingItemBean billowingItemBean) {

                list.addAll(billowingItemBean.getVideo());

                List<BillowingItemBean.VideoBean> video = billowingItemBean.getVideo();
                Log.e("Tag", "我是getVideo这个bean类" + billowingItemBean);

                BillowingItemBean.VideosetBean videoset = billowingItemBean.getVideoset();
                //获取标题名
                String name = videoset.get_$0().getName();
                nameB.setText(name);
                //获取显示内容
                desc = videoset.get_$0().getDesc();

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                Log.e("Tag", "请求失败deBillowingbottomActivity=" + errorMsg);
            }
        });


        final BillowingbottomAdapter billowingbottomAdapter = new BillowingbottomAdapter(this, R.layout.billowing_bottom_item, list);
        mBillowingBottomListview.setAdapter(billowingbottomAdapter);
        mBillowingBottomListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                url = list.get(i).getUrl();
                Log.e("Tag", "我是视频的url===" + url);
                img = list.get(i).getImg();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        billowingbottomAdapter.notifyDataSetChanged();
                    }
                });

            }
        });


//        //获取ImageLoader对象
//        ImageLoader imageloader = ImageLoader.getInstance();
//        //使用默认的ImageLoaderConfiguration
//        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getApplicationContext());
//        //初始化ImageLoader的配置
//        imageloader.init(configuration);

        jiecaoB.setUp(url, null);

        Log.e("TAG", "initView: " + textName.toString());
        textName.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(BillowingActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setResult(BillowingMoveBean billowingMoveBean) {


        Log.e("TAG", "=======" + billowingMoveBean.toString());
    }

    @Override
    public void showMessage(String msg) {

        Toast.makeText(this, "请求失败" + msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.butImg, R.id.fenxiang_b, R.id.shoucang_b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.butImg:

                textName.setVisibility(View.VISIBLE);
                textName.setText(desc);

                switch (ABS) {
                    case 0:
                        ABS = 1;
                        textName.setText(desc);
                        Log.e("ATG", textName.toString());
                        textName.setVisibility(View.VISIBLE);

                        break;
                    case 1:
                        ABS = 0;
                        textName.setText("隐藏");
                        Log.e("ATG", textName.toString());
                        textName.setVisibility(View.GONE);
                        break;
                }
                break;

            case R.id.shoucang_b:
                Toast.makeText(BillowingbottomActivity.this, "收藏", Toast.LENGTH_LONG).show();

                break;
            case R.id.fenxiang_b:
                Toast.makeText(BillowingbottomActivity.this, "分享", Toast.LENGTH_LONG).show();


                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
