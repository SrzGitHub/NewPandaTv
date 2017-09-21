package co.com.newpandatv.view.activity.setup;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;


public class FeedbackActivity extends AppCompatActivity {

    @BindView(R.id.one_IMG)
    ImageView oneIMG;
    @BindView(R.id.fee_Tyl)
    TabLayout feeTyl;
    @BindView(R.id.fee_Vip)
    ViewPager feeVip;
    ArrayList<Fragment> feeList = new ArrayList<>();
    FeeAdapter feeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        feeList.add(new FeedbackFrgmentOne());
        feeList.add(new FeedbackFrgmentTwo());
       feeAdapter = new FeeAdapter(getSupportFragmentManager(),feeList);
        feeVip.setAdapter(feeAdapter);
        feeTyl.setTabMode(TabLayout.MODE_FIXED);

        feeTyl.setupWithViewPager(feeVip);

    }
}
