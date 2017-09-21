package co.com.newpandatv.view.activity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import org.greenrobot.greendao.query.QueryBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.config.UMengUtls;
import co.com.newpandatv.dao.DaoMaster;
import co.com.newpandatv.dao.DaoSession;
import co.com.newpandatv.dao.DaoUtil;
import co.com.newpandatv.dao.SQLBeans;
import co.com.newpandatv.dao.SQLBeansDao;
import co.com.newpandatv.model.entity.VideoBeans;
import co.com.newpandatv.module.home.contract.VideoActivityModelContract;
import co.com.newpandatv.presenter.VideoActivityModelPresenter;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static com.umeng.socialize.a.b.d.i;


public class VideoActivity extends AppCompatActivity implements VideoActivityModelContract.View {

    VideoActivityModelContract.ActivityPresnter activityPresnter;
    @BindView(R.id.videoJP)
    JCVideoPlayer videoJP;


    public static String urls;
    public static String vid;
    @BindView(R.id.collectionlImg)
    ImageView collectionlImg;
    @BindView(R.id.shareImg)
    ImageView shareImg;
    @BindView(R.id.listImg)
    ImageView listImg;
    private String title;
    int VIDEO =0;
    private String data;
    private String len;
    private SQLiteDatabase w;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLBeansDao sqlBeansDao;
    private SQLBeans sqlBeans;
    private String urlIg;
    private String image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        setContentView(R.layout.activity_svideo);
        ButterKnife.bind(this);

        new VideoActivityModelPresenter(this);
        vid = getIntent().getStringExtra("vid");
        title = getIntent().getStringExtra("title");
        data = getIntent().getStringExtra("data");
        len = getIntent().getStringExtra("len");
        urlIg = getIntent().getStringExtra("urlIg");
        Log.e("TAG", "onCreate: "+urlIg);

        w = DaoUtil.getIn(App.getContext()).getW();
        daoMaster = new DaoMaster(w);
        daoSession = daoMaster.newSession();
        sqlBeansDao = daoSession.getSQLBeansDao();
        sqlBeans = new SQLBeans();
        activityPresnter.start();


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

    @Override
    public void setPresenter(VideoActivityModelContract.ActivityPresnter activityPresnter) {
        this.activityPresnter = activityPresnter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(final VideoBeans videoBeans) {
        urls = videoBeans.getVideo().getChapters().get(0).getUrl();
        image = videoBeans.getVideo().getChapters().get(0).getImage();
        Log.e("TAG", "setResult: image："+ image);

        Log.e("TAG", "setResult: " + urls);

        videoJP.setUp(urls,title);

        shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMImage imgs = new UMImage(App.getContext(), image);//设置缩略图
                UMVideo video = new UMVideo(urls);//设置 视频地址
                video.setTitle(title);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("PandaChannel");//视频的描述
                new ShareAction(VideoActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();

            }
        });


        collectionlImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               switch (VIDEO){
                   case 0:
                       VIDEO=1;
                       collectionlImg.setImageResource(R.mipmap.collect_yes);
                       Toast.makeText(VideoActivity.this,"收藏成功",Toast.LENGTH_SHORT).show();
                       Date date=new Date();
                       DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                       String time=format.format(date);
                       sqlBeans.setDaoUrl(urls);
                       sqlBeans.setUrlImg(urlIg);
                       sqlBeans.setUrlData(time);
                       sqlBeans.setUrlLen(len);
                       sqlBeans.setUrlTitle(title);
                       sqlBeans.setId(null);
                       sqlBeansDao.insert(sqlBeans);
                       break;
                   case 1:
                       VIDEO=0;
                       collectionlImg.setImageResource(R.mipmap.collect_no);
                       Toast.makeText(VideoActivity.this,"取消收藏",Toast.LENGTH_SHORT).show();
                       SQLiteDatabase r = DaoUtil.getIn(VideoActivity.this).getR();
                       DaoMaster daoMaster = new DaoMaster(r);
                       DaoSession daoSession = daoMaster.newSession();
                       SQLBeansDao sqlBeansDao = daoSession.getSQLBeansDao();
                       List<SQLBeans> list = sqlBeansDao.queryBuilder().build().list();
                       sqlBeansDao.delete(list.get(1));
                       List<SQLBeans> list1 = sqlBeansDao.queryBuilder().build().list();
                       list.clear();
                       list.addAll(list1);



                       break;
               }



            }
        });





    }

    @Override
    public void showMessage(String msg) {


    }

    @Override
    protected void onPause() {
        super.onPause();
        videoJP.releaseAllVideos();
    }
}
