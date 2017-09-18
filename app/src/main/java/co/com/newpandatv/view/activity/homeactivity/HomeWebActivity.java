package co.com.newpandatv.view.activity.homeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
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
import co.com.newpandatv.view.activity.VideoActivity;

import static co.com.newpandatv.view.activity.VideoActivity.urls;

public class HomeWebActivity extends AppCompatActivity {

    @BindView(R.id.web)
    WebView web;
    @BindView(R.id.web_image1)
    ImageView webImage1;
    @BindView(R.id.web_image2)
    ImageView webImage2;
    private String webUrl;
    private String webImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_web);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        webUrl = intent.getStringExtra("web");
        webImage = intent.getStringExtra("webImage");
        web.loadUrl(webUrl);

        webImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        webImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMImage imgs = new UMImage(App.getContext(), webImage);
                UMVideo video = new UMVideo(webUrl);
//                video.setTitle(title);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("PandaChannel");//视频的描述
                new ShareAction(HomeWebActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();
            }
        });
    }
}
