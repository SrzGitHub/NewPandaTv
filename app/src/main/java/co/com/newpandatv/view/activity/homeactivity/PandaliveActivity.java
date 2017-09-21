package co.com.newpandatv.view.activity.homeactivity;

        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.content.res.Configuration;
        import android.os.Build;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.Toast;

        import com.bumptech.glide.Glide;
        import com.umeng.socialize.ShareAction;
        import com.umeng.socialize.bean.SHARE_MEDIA;
        import com.umeng.socialize.media.UMImage;
        import com.umeng.socialize.media.UMVideo;

        import co.com.newpandatv.R;
        import co.com.newpandatv.app.App;
        import co.com.newpandatv.config.UMengUtls;
        import co.com.newpandatv.model.entity.home_video_bean.AreaBean;
        import co.com.newpandatv.model.entity.home_video_bean.LivePandaliveBean;
        import co.com.newpandatv.net.OkHttpUtils;
        import co.com.newpandatv.net.callback.MyNetWorkCallback;
        import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

        import static co.com.newpandatv.view.activity.VideoActivity.urls;

public class PandaliveActivity extends AppCompatActivity {

    private JCVideoPlayer videoJP_pandalive;
    private ImageView pandalive_collectionlImg;
    private ImageView pandalive_shareImg;
    private ImageView pandalive_listImg;
    private String pandalive;
    int VIDEO=0;
    private String cdn_name;
    private String hls1;
    private String chinalivename;
    private String pandalive_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        setContentView(R.layout.activity_pandalive);
        Intent intent = getIntent();
        pandalive = intent.getStringExtra("pandalive");
        chinalivename = intent.getStringExtra("chinalivename");
        pandalive_image = intent.getStringExtra("pandalive_image");

        initView();
    }

    private void initView() {
        videoJP_pandalive = (JCVideoPlayer) findViewById(R.id.videoJP_pandalive);
        pandalive_collectionlImg = (ImageView) findViewById(R.id.pandalive_collectionlImg);
        pandalive_shareImg = (ImageView) findViewById(R.id.pandalive_shareImg);
        pandalive_listImg = (ImageView) findViewById(R.id.pandalive_listImg);

        OkHttpUtils.getInstance().get("http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+pandalive+"&amp;client=androidapp", null, new MyNetWorkCallback<LivePandaliveBean>() {

            @Override
            public void onSuccess(LivePandaliveBean livePandaliveBean) {
                hls1 = livePandaliveBean.getHls_url().getHls1();
//                livePandaliveBean.getHls_cdn_info()''
                cdn_name = livePandaliveBean.getHls_cdn_info().getCdn_name();
                videoJP_pandalive.setUp(hls1, chinalivename);
                Glide.with(App.mContext).load(pandalive_image).into(videoJP_pandalive.ivThumb);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

        pandalive_shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UMImage imgs = new UMImage(App.getContext(), R.mipmap.ic_launcher);
                UMVideo video = new UMVideo(urls);
                video.setTitle(chinalivename);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("area_home");//视频的描述
                new ShareAction(PandaliveActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();

            }
        });


        pandalive_collectionlImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (VIDEO) {
                    case 0:
                        VIDEO = 1;
                        pandalive_collectionlImg.setImageResource(R.mipmap.collect_yes);
                        Toast.makeText(PandaliveActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();

                        break;
                    case 1:
                        VIDEO = 0;
                        pandalive_collectionlImg.setImageResource(R.mipmap.collect_no);
                        Toast.makeText(PandaliveActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();

                        break;
                }

            }
        });
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
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
