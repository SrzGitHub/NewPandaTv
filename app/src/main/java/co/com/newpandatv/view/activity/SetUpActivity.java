package co.com.newpandatv.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import co.com.newpandatv.config.GlideCacheUtil;
import co.com.newpandatv.view.activity.setup.FeedbackActivity;
import co.com.newpandatv.view.activity.setup.GYActivity;

public class SetUpActivity extends AppCompatActivity {

    @BindView(R.id.setUp_IMG)
    ImageView setUpIMG;
    @BindView(R.id.setUp_T)
    ImageView setUpT;
    @BindView(R.id.setUp_X)
    ImageView setUpX;
    @BindView(R.id.setUp_Mb)
    TextView setUpMb;
    @BindView(R.id.huan)
    LinearLayout huan;
    @BindView(R.id.setUp_F)
    LinearLayout setUpF;
    @BindView(R.id.setUp_C)
    LinearLayout setUpC;
    @BindView(R.id.setUp_H)
    LinearLayout setUpH;
    @BindView(R.id.setUp_G)
    LinearLayout setUpG;

    int A =0;
    int B =0;
    int C =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        ButterKnife.bind(this);
        String cacheSize = GlideCacheUtil.getInstance().getCacheSize(this);
        setUpMb.setText(cacheSize);
    }

    @OnClick({R.id.setUp_G,R.id.setUp_IMG, R.id.setUp_T, R.id.setUp_X, R.id.huan, R.id.setUp_F, R.id.setUp_C, R.id.setUp_H})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setUp_IMG:
                finish();
                break;
            case R.id.setUp_T:
                switch (A){
                    case 0:
                        A =1;
                        Toast.makeText(this,"已关闭！",Toast.LENGTH_SHORT).show();

                        setUpT.setImageResource(R.mipmap.switch_close);

                        break;
                    case 1:
                        A =0;
                        Toast.makeText(this,"已开启！",Toast.LENGTH_SHORT).show();

                        setUpT.setImageResource(R.mipmap.switch_open);
                        break;
                }

                break;
            case R.id.setUp_X:
                switch (B){
                    case 0:
                        B =1;
                        Toast.makeText(this,"已关闭！",Toast.LENGTH_SHORT).show();

                        setUpX.setImageResource(R.mipmap.switch_close);

                        break;
                    case 1:
                        B =0;
                        Toast.makeText(this,"已经开启！",Toast.LENGTH_SHORT).show();

                        setUpX.setImageResource(R.mipmap.switch_open);
                        break;
                }
                break;
            case R.id.huan:
                AlertDialog.Builder builder = new AlertDialog.Builder(SetUpActivity.this);
                builder.setTitle("提示");
                builder.setMessage("是否清除全部缓存");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //调用glide工具类的方法 清除图片全部缓存
                        GlideCacheUtil.getInstance().clearImageAllCache(SetUpActivity.this);
                        setUpMb.setText("0.00M");
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();


                break;
            case R.id.setUp_F:
           startActivity(new Intent(SetUpActivity.this, FeedbackActivity.class));
                break;
            case R.id.setUp_C:
                Toast.makeText(this,"已经是最新版本！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setUp_H:
                Toast.makeText(this,"不给好评砍死你！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setUp_G:
                startActivity(new Intent(SetUpActivity.this, GYActivity.class));
                break;
        }
    }
}
