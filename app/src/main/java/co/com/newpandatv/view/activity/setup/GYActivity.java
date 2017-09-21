package co.com.newpandatv.view.activity.setup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;

public class GYActivity extends AppCompatActivity {

    @BindView(R.id.gy_Name)
    TextView gyName;
    @BindView(R.id.gy_IMG)
    ImageView gyIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gy);
        ButterKnife.bind(this);
        gyName.setText(R.string.guanyu);
    }

    @OnClick(R.id.gy_IMG)
    public void onViewClicked() {
        finish();
    }
}
