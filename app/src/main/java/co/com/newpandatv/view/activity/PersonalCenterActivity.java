package co.com.newpandatv.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.shaer.AutoActivity;
import co.com.newpandatv.shaer.UserActivity;

public class PersonalCenterActivity extends AppCompatActivity {

    @BindView(R.id.pr_IMG)
    ImageView prIMG;
    @BindView(R.id.pr_php)
    ImageView prPhp;
    @BindView(R.id.pr_Name)
    TextView prName;
    @BindView(R.id.login)
    LinearLayout login;
    @BindView(R.id.lishi)
    LinearLayout lishi;
    @BindView(R.id.shoucang)
    LinearLayout shoucang;
    @BindView(R.id.shezhi)
    LinearLayout shezhi;
    int USER = 0;
    SHARE_MEDIA share_media;
    String image_url,name;
    UMAuthListener authlistener = new UMAuthListener() {

        @Override
        public void onStart(SHARE_MEDIA share_media) {

            Log.e("TAG", "onStart: "+share_media.toString());
        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Set<String> set=map.keySet();
            for (String string:set){
                //获取头像url
                if (string.equals("profile_image_url")){
                    image_url = map.get(string);

                    Log.e("TAG", "image_url:"+image_url);
                }

                //获取昵称
                if (string.equals("screen_name")){
                    name = map.get(string);
                }


                    Glide.with(PersonalCenterActivity.this).load(image_url).into(prPhp);
                    prName.setText(name);


            }


        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Log.e("TAG","失败了"+throwable.getMessage().toString());
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        ButterKnife.bind(this);

        share_media = (SHARE_MEDIA) getIntent().getSerializableExtra("platforms");
        UMShareAPI.get(PersonalCenterActivity.this).getPlatformInfo(PersonalCenterActivity.this,
                share_media, authlistener);

    }

    @OnClick({R.id.pr_IMG, R.id.login, R.id.lishi, R.id.shoucang, R.id.shezhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pr_IMG:
                finish();
                break;
            case R.id.login:
                Toast.makeText(App.context,"登录",Toast.LENGTH_SHORT).show();
               switch (USER){
                   case 0:
                       USER =1;
                       Toast.makeText(App.context,"请先授权",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(PersonalCenterActivity.this, AutoActivity.class));

                       break;
                   case 1:
                        USER= 0;
                       startActivity(new Intent(PersonalCenterActivity.this, UserActivity.class));
                        finish();
                       break;

               }
                break;
            case R.id.lishi:
                Intent intent = new Intent(App.getContext(),SQLActivity.class);
                intent.putExtra("title","观看历史");
                startActivity(intent);
                break;
            case R.id.shoucang:
                Intent in = new Intent(App.getContext(),SQLActivity.class);
                in.putExtra("title","收藏");
                startActivity(in);
                break;
            case R.id.shezhi:
               startActivity(new Intent(PersonalCenterActivity.this,SetUpActivity.class));
                break;
        }




    }
}
