package co.com.newpandatv.view.activity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.model.entity.VideoBeans;
import co.com.newpandatv.module.home.contract.VideoActivityModelContract;
import co.com.newpandatv.presenter.VideoActivityModelPresenter;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends AppCompatActivity implements VideoActivityModelContract.View {

    VideoActivityModelContract.ActivityPresnter activityPresnter;
    @BindView(R.id.videoJP)
    JCVideoPlayer videoJP;


    public static String urls;
    public static String vid;
    private String title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        new VideoActivityModelPresenter(this);
        vid = getIntent().getStringExtra("vid");
        title = getIntent().getStringExtra("title");
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
    public void setResult(VideoBeans videoBeans) {

        urls = videoBeans.getVideo().getChapters().get(0).getUrl();
        Log.e("TAG", "setResult: "+urls);
        videoJP.setUp(urls,title,true);

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
