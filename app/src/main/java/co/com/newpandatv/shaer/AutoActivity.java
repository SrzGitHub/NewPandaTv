package co.com.newpandatv.shaer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;

import java.util.ArrayList;
import java.util.Map;

import co.com.newpandatv.R;

public class AutoActivity extends AppCompatActivity {

    private ListView listView;
    private SHARE_MEDIA[] list = { SHARE_MEDIA.QQ};
    private AutoAdapter autoAdapter;
    private ArrayList<SnsPlatform> platforms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        listView = (ListView) findViewById(R.id.autolist);
        initPlatforms();
        autoAdapter = new AutoAdapter(this, platforms);
        listView.setAdapter(autoAdapter);


        UMShareAPI.get(this).fetchAuthResultWithBundle(this, savedInstanceState, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Toast.makeText(AutoActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                autoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Toast.makeText(AutoActivity.this, "No"+throwable.getMessage().toString(), Toast.LENGTH_SHORT).show();
                autoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Toast.makeText(AutoActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                autoAdapter.notifyDataSetChanged();
            }
        });
    }

    public void initPlatforms(){
        platforms.clear();
        for (int i=0;i<list.length;i++){
            platforms.add(list[i].toSnsPlatform());
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        UMShareAPI.get(this).onSaveInstanceState(outState);
    }
}
