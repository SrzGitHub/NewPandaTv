package co.com.newpandatv.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.editorpage.ShareActivity;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.MainActivity;
import co.com.newpandatv.R;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.web_Img)
    ImageView webImg;
    @BindView(R.id.web_Title)
    TextView webTitle;
    @BindView(R.id.web_View)
    WebView webView;
    @BindView(R.id.webShare)
    ImageView webShare;
    private String webUrl;
    private String title;
    private String img;
    private UMImage thumb;
    private UMWeb web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);


        webUrl = getIntent().getStringExtra("webUrl");
        title = getIntent().getStringExtra("title");
        img = getIntent().getStringExtra("img");

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);//支持js
         settings.setDefaultTextEncodingName("GBK");//编码
        webView.setScrollBarStyle(1);//滚动条风格，为0指滚动条不占用空间，直接覆盖在网页上
        webTitle.setText(title);
        webView.loadUrl(webUrl);
        thumb = new UMImage(WebViewActivity.this, img);

        web = new UMWeb(webUrl);

        web.setThumb(thumb);
        web.setTitle(title);//标题
        web.setDescription("原创互动分享：" + title);//描述

    }


    @OnClick({R.id.web_Img, R.id.webShare})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.web_Img:
                finish();
                break;
            case R.id.webShare:
                setShare();
                break;
        }
    }


    public void setShare() {


       /* new ShareAction(WebViewActivity.this)
                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                .withMedia(web)
                .setCallback(shareListener)
                .open();*/
        new ShareAction(WebViewActivity.this)
                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                .withMedia(web)
                .setCallback(shareListener)//回调监听器
                .share();
    }


    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(WebViewActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(WebViewActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(WebViewActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };

}
