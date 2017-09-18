package co.com.newpandatv.view.activity.homeactivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.config.UMengUtls;
import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.home_video_bean.PandaeyeBean;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import co.com.newpandatv.view.activity.VideoActivity;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static co.com.newpandatv.R.id.collectionlImg;
import static co.com.newpandatv.R.id.shareImg;
import static co.com.newpandatv.view.activity.VideoActivity.urls;

public class VideoLiuActivity extends AppCompatActivity {

    String url = UrlsUtils.URLK;
    @BindView(R.id.videoJP_pandaeye)
    JCVideoPlayer videoJPPandaeye;

    @BindView(R.id.video_collectionlImg)
    ImageView videoCollectionlImg;
    @BindView(R.id.video_shareImg)
    ImageView videoShareImg;
    @BindView(R.id.video_listImg)
    ImageView videoListImg;
    PandaeyeBean pandaeyeBean2;

    int VIDEO =0;
    private String url1;
    private String title;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        setContentView(R.layout.activity_video_liu);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String pandaeye = intent.getStringExtra("pandaeye");
        OkHttpUtils.getInstance().get(url + pandaeye, null, new MyNetWorkCallback<PandaeyeBean>() {
            @Override
            public void onSuccess(PandaeyeBean pandaeyeBean) {

                url1 = pandaeyeBean.getVideo().getChapters().get(0).getUrl();
                title = pandaeyeBean.getTitle();
                image = pandaeyeBean.getVideo().getChapters().get(0).getImage();
                videoJPPandaeye.setUp(url1, title);
//                boolean isFullscreenFromNormal = videoJPPandaeye.isFullscreenFromNormal;
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

        videoShareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UMImage imgs = new UMImage(App.getContext(), R.mipmap.ic_launcher);
                UMVideo video = new UMVideo(urls);
                video.setTitle(title);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("pandaeye_home");//视频的描述
                new ShareAction(VideoLiuActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();

            }
        });


        videoCollectionlImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (VIDEO){
                    case 0:
                        VIDEO=1;
                        videoCollectionlImg.setImageResource(R.mipmap.collect_yes);
                        Toast.makeText(VideoLiuActivity.this,"收藏成功",Toast.LENGTH_SHORT).show();

                        break;
                    case 1:
                        VIDEO=0;
                        videoCollectionlImg.setImageResource(R.mipmap.collect_no);
                        Toast.makeText(VideoLiuActivity.this,"取消收藏",Toast.LENGTH_SHORT).show();

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
