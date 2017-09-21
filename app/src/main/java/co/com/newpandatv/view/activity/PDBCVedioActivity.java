package co.com.newpandatv.view.activity;

import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.config.UMengUtls;
import co.com.newpandatv.dao.DaoMaster;
import co.com.newpandatv.dao.DaoSession;
import co.com.newpandatv.dao.DaoUtil;
import co.com.newpandatv.dao.SQLBeans;
import co.com.newpandatv.dao.SQLBeansDao;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class PDBCVedioActivity extends BaseActivity {


    @BindView(R.id.jiecaovedio)
    JCVideoPlayer jiecaovedio1;
    @BindView(R.id.image_shoucang)
    CheckBox imageShoucang;
    @BindView(R.id.image_share)
    CheckBox imageShare;
    @BindView(R.id.image_goback)
    ImageButton imageGoback;
    public static String id;
    private SQLiteDatabase w;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLBeansDao sqlBeansDao;
    private SQLBeans sqlBeans;


    @Override
    protected int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        return R.layout.activity_pdbcvedio;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        w = DaoUtil.getIn(App.getContext()).getW();
        daoMaster = new DaoMaster(w);
        daoSession = daoMaster.newSession();
        sqlBeansDao = daoSession.getSQLBeansDao();
        sqlBeans = new SQLBeans();

        //获取ImageLoader对象
        ImageLoader imageloader = ImageLoader.getInstance();
        //使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getApplicationContext());
        //初始化ImageLoader的配置
        imageloader.init(configuration);

        final String url1 = getIntent().getStringExtra("url1");

        Log.e("VedioURL", url1);

        final String title = getIntent().getStringExtra("title");
        final String imageurl = getIntent().getStringExtra("imageurl");
        final String path = "http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4";
        jiecaovedio1.setUp(path, "            " + title);
        id = getIntent().getStringExtra("id1");
        sqlBeans.setDaoUrl(path);
        sqlBeans.setUrlImg(imageurl);
        sqlBeans.setUrlTitle(title);
        sqlBeans.setId(null);
        sqlBeansDao.insert(sqlBeans);

        imageShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PDBCVedioActivity.this, "亲，我替你收藏了哦", Toast.LENGTH_SHORT).show();
            }
        });
        imageShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PDBCVedioActivity.this, "亲，稍等一会", Toast.LENGTH_SHORT).show();
                UMImage imgs = new UMImage(App.context, imageurl);
                UMVideo video = new UMVideo("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4");
                video.setTitle(title);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("PandaChannel");//视频的描述
                new ShareAction(PDBCVedioActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();

            }
        });


        Log.e("VedioID", id);

//        Cursor pdbc = read.query("PDBC", null, null, null, null, null, null);
//        if (pdbc.moveToFirst()) {
//            do {
//                String vediourl = pdbc.getString(pdbc.getColumnIndex("vediourl"));
//                Log.e("Greendao",vediourl);
//            }while (pdbc.moveToNext());
//        }
//        pdbc.close();

    }


    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();

    }

    @Override
    protected void onResume() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }


}
