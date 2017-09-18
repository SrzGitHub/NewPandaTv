package co.com.newpandatv.shaer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.youth.banner.loader.ImageLoader;

import java.util.Map;
import java.util.Set;

import co.com.newpandatv.R;
import co.com.newpandatv.view.activity.PersonalCenterActivity;

import static android.R.attr.data;
import static android.R.attr.name;

public class InfoActivity extends AppCompatActivity {


    Button getbtn,closebtn;
    TextView userinfo;
    SHARE_MEDIA share_media;
    ImageView infoImg;
    TextView infoName;

    String image_url,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
//        PushAgent.getInstance(this).onAppStart();
        share_media = (SHARE_MEDIA) getIntent().getSerializableExtra("platforms");

        getbtn = (Button) findViewById(R.id.getbtn);
        closebtn = (Button) findViewById(R.id.closebtn);
        userinfo = (TextView) findViewById(R.id.userinfo);

        infoName = (TextView) findViewById(R.id.infoName);
        infoImg = (ImageView) findViewById(R.id.infoImg);


        ((TextView) findViewById(R.id.umeng_title)).setText("获取用户信息");
        findViewById(R.id.umeng_back).setVisibility(View.VISIBLE);
        findViewById(R.id.umeng_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI.get(InfoActivity.this).getPlatformInfo(InfoActivity.this,
                        share_media, authlistener);

//                Intent intent = new Intent(InfoActivity.this, PersonalCenterActivity.class);
//                intent.putExtra("name",name);
//                intent.putExtra("img",image_url);
//                startActivity(intent);



            }
        });

        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userinfo.setText("");
            }
        });

    }


    private UMAuthListener authlistener = new UMAuthListener() {

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
                userinfo.setText(image_url+"\n"+name);

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
    protected void onStop() {
        super.onStop();
        userinfo.setText("");
    }
}
