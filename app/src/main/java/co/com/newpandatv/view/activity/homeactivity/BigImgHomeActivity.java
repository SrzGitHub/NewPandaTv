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
import co.com.newpandatv.model.entity.home_video_bean.BigImgBean;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static co.com.newpandatv.view.activity.VideoActivity.urls;

public class BigImgHomeActivity extends AppCompatActivity {

    @BindView(R.id.videoJP_bigimg)
    JCVideoPlayer videoJPBigimg;
    String url = UrlsUtils.URLK;
    @BindView(R.id.bigimg_collectionlImg)
    ImageView bigimgCollectionlImg;
    @BindView(R.id.bigimg_shareImg)
    ImageView bigimgShareImg;
    @BindView(R.id.bigimg_listImg)
    ImageView bigimgListImg;
    private String title;
    private String image;
    private String url1;
    int VIDEO=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        setContentView(R.layout.activity_big_img_home);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String bigimg = intent.getStringExtra("bigimg");

        OkHttpUtils.getInstance().get(url + bigimg, null, new MyNetWorkCallback<BigImgBean>() {
            @Override
            public void onSuccess(BigImgBean bigImgBean) {
                title = bigImgBean.getTitle();
                image = bigImgBean.getVideo().getChapters().get(0).getImage();
                url1 = bigImgBean.getVideo().getChapters().get(0).getUrl();
                videoJPBigimg.setUp(url1, title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

        bigimgShareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UMImage imgs = new UMImage(App.getContext(), image);
                UMVideo video = new UMVideo(urls);
                video.setTitle(title);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("bigimg_home");//视频的描述
                new ShareAction(BigImgHomeActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();

            }
        });


        bigimgCollectionlImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (VIDEO) {
                    case 0:
                        VIDEO = 1;
                        bigimgCollectionlImg.setImageResource(R.mipmap.collect_yes);
                        Toast.makeText(BigImgHomeActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();

                        break;
                    case 1:
                        VIDEO = 0;
                        bigimgCollectionlImg.setImageResource(R.mipmap.collect_no);
                        Toast.makeText(BigImgHomeActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();

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
