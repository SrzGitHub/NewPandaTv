package co.com.newpandatv.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;
import co.com.newpandatv.app.App;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.pr_IMG, R.id.login, R.id.lishi, R.id.shoucang, R.id.shezhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pr_IMG:
                finish();
                break;
            case R.id.login:
                Toast.makeText(App.context,"登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.lishi:
                startActivity(new Intent(App.getContext(),SQLActivity.class));
                break;
            case R.id.shoucang:
               startActivity(new Intent(App.getContext(),SQLActivity.class));
                break;
            case R.id.shezhi:
               startActivity(new Intent(PersonalCenterActivity.this,SetUpActivity.class));
                break;
        }
    }
}
