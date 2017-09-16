package co.com.newpandatv.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.BillowingMoveBean;
import co.com.newpandatv.net.HttpUtils;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Billow_moveActivity extends BaseActivity {

    @BindView(R.id.mVideoview)
    JCVideoPlayer mVideoview;

    private String url;
    private String title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_billow_move;
    }

    @Override
    protected void initView() {

        String pid = getIntent().getStringExtra("pid");
        Log.e("TAG", pid);

        HttpUtils.doGet(UrlsUtils.MOVIE + "?pid=" + pid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","请求错误"+e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();
                Log.e("TAG",string);
                Gson gson = new Gson();
                BillowingMoveBean billowingMoveBean = gson.fromJson(string, BillowingMoveBean.class);
                Log.e("TAG","0000000000000000000"+billowingMoveBean.toString());

                title = billowingMoveBean.getTitle();
                Log.e("Tag","title===="+ title);
                List<BillowingMoveBean.VideoBean.ChaptersBean> chapters = billowingMoveBean.getVideo().getChapters();
                url = chapters.get(0).getUrl();
                Log.e("Tag","url===="+ url);

            }
        });

        /*//获取ImageLoader对象
        ImageLoader imageloader = ImageLoader.getInstance();

        //使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getApplicationContext());
        //初始化ImageLoader的配置
        imageloader.init(configuration);*/

        mVideoview.setUp(url,title);
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
}
