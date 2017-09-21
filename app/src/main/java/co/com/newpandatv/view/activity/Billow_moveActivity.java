package co.com.newpandatv.view.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.config.UMengUtls;
import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.dao.DaoMaster;
import co.com.newpandatv.dao.DaoSession;
import co.com.newpandatv.dao.DaoUtil;
import co.com.newpandatv.dao.SQLBeans;
import co.com.newpandatv.dao.SQLBeansDao;
import co.com.newpandatv.model.entity.BillowingMoveBean;
import co.com.newpandatv.module.bilowing.BillowingActivityContract;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class Billow_moveActivity extends BaseActivity implements BillowingActivityContract.View {

    @BindView(R.id.mVideoview)
    JCVideoPlayer mVideoview;
    @BindView(R.id.shoucang_top)
    ImageView shoucangTop;
    @BindView(R.id.shareImg_top)
    ImageView shareImgTop;
    @BindView(R.id.listImg_top)
    ImageView listImgTop;

    BillowingActivityContract.Presenter presenter;

    private String url1;
    private String image;
    private String title;

    int VIDEO = 0;

    private SQLiteDatabase w;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLBeansDao sqlBeansDao;
    private SQLBeans sqlBeans;

    @Override
    protected int getLayoutId() {

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_billow_move;
    }

    @Override
    protected void initView() {

        String pid = getIntent().getStringExtra("pid");
        Log.e("TAG", pid);


        //创建数据库
        w = DaoUtil.getIn(App.getContext()).getW();
        daoMaster = new DaoMaster(w);
        daoSession = daoMaster.newSession();
        sqlBeansDao = daoSession.getSQLBeansDao();
        sqlBeans = new SQLBeans();



        OkHttpUtils.getInstance().get(UrlsUtils.MOVIE + "?pid=" + pid, null, new MyNetWorkCallback<BillowingMoveBean>() {
            @Override
            public void onSuccess(BillowingMoveBean billowingMoveBean) {
                Log.e("TAG", "===================" + billowingMoveBean.toString());

                url1 = billowingMoveBean.getVideo().getChapters().get(0).getUrl();
                Log.e("TAG", "===================" + url1);
                image = billowingMoveBean.getVideo().getChapters().get(0).getImage();
                title = billowingMoveBean.getTitle();


                Date date=new Date();
                DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time=format.format(date);
                sqlBeans.setDaoUrl(url1);
                sqlBeans.setUrlImg(image);
                sqlBeans.setUrlData(time);
                sqlBeans.setUrlTitle(title);
                sqlBeans.setId(null);
                sqlBeansDao.insert(sqlBeans);

                mVideoview.setUp(url1, title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

        shareImgTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMImage imgs = new UMImage(App.getContext(), image);
                UMVideo video = new UMVideo(url1);
                video.setTitle(title);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("PandaChannel");//视频的描述
                new ShareAction(Billow_moveActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();

            }
        });

        shoucangTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (VIDEO) {
                    case 0:
                        VIDEO = 1;
                        shoucangTop.setImageResource(R.mipmap.collect_yes);
                        Toast.makeText(Billow_moveActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        VIDEO = 0;
                        shoucangTop.setImageResource(R.mipmap.collect_no);
                        Toast.makeText(Billow_moveActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void setPresenter(BillowingActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setResult(BillowingMoveBean billowingMoveBean) {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
