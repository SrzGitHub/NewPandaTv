package co.com.newpandatv.shaer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;

import java.util.ArrayList;

import co.com.newpandatv.R;
import co.com.newpandatv.view.activity.PersonalCenterActivity;

public class UserActivity extends AppCompatActivity {
    private ListView listView;
    private SHARE_MEDIA[] list = { SHARE_MEDIA.QQ};
    private ShareAdapter autoAdapter;
    private ArrayList<SnsPlatform> platforms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.umeng_share);
        listView = (ListView) findViewById(R.id.list);
        initPlatforms();
        autoAdapter = new ShareAdapter(this, platforms);
        listView.setAdapter(autoAdapter);


        ((TextView) findViewById(R.id.umeng_title)).setText("获取用户信息");
        findViewById(R.id.umeng_back).setVisibility(View.VISIBLE);
        findViewById(R.id.umeng_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UserActivity.this, PersonalCenterActivity.class);
                intent.putExtra("platforms", platforms.get(position).mPlatform);
                startActivity(intent);
            }
        });

    }

    public void initPlatforms(){
        platforms.clear();
        for (int i=0;i<list.length;i++){
            platforms.add(list[i].toSnsPlatform());
        }

    }
}
