package co.com.newpandatv.view.activity;

import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.base.BaseActivity;
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
        //获取ImageLoader对象
        ImageLoader imageloader = ImageLoader.getInstance();
        //使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getApplicationContext());
        //初始化ImageLoader的配置
        imageloader.init(configuration);

        String url1 = getIntent().getStringExtra("url1");

        Log.e("VedioURL", url1);

        String title = getIntent().getStringExtra("title");
//        String imageurl = getIntent().getStringExtra("imageurl");
        jiecaovedio1.setUp("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4", "            " + title);
         id = getIntent().getStringExtra("id1");
        imageShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PDBCVedioActivity.this, "亲，我替你收藏了哦", Toast.LENGTH_SHORT).show();
            }
        });
        imageShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PDBCVedioActivity.this, "亲，没有分享哎", Toast.LENGTH_SHORT).show();

            }
        });


        Log.e("VedioID", id);
    }


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pdbcvedio);
//        ButterKnife.bind(this);
//        //获取ImageLoader对象
//        ImageLoader imageloader= ImageLoader.getInstance();
//        //使用默认的ImageLoaderConfiguration
//        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this.getApplicationContext());
//        //初始化ImageLoader的配置
//        imageloader.init(configuration);
//
//        String url1 = getIntent().getStringExtra("url1");
//        String id1 = getIntent().getStringExtra("id1");
//        VEDIOId = id1;
//        Log.e("VedioURL",url1);
//        String title = getIntent().getStringExtra("title");
//        String imageurl = getIntent().getStringExtra("imageurl");
//        jiecaovedio.setUp(url1,imageurl,title );
//    }
//
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
