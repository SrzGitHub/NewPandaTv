package co.com.newpandatv.view.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.module.bilowing.BillowingVideoPresenter;
import co.com.newpandatv.module.home.HomeFragment;
import co.com.newpandatv.module.home.HomePresenter;
import co.com.newpandatv.view.fragment.BillowingVideo;
import co.com.newpandatv.view.fragment.LiveChina;
import co.com.newpandatv.view.fragment.PandaBroadcast;
import co.com.newpandatv.view.fragment.PandaLive;

public class TwoActivity extends BaseActivity {
    private long firstTime = 0;
    private int mBackKeyPressedTimes = 0;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    @BindView(R.id.twoTitle)
    TextView twoTitle;
    @BindView(R.id.twoHD)
    ImageView twoHD;
    @BindView(R.id.twoLonge)
    ImageView twoLonge;
    @BindView(R.id.tiao_rll)
    LinearLayout tiaoRll;
    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.twoZH)
    RadioButton twoZH;
    @BindView(R.id.twoZB)
    RadioButton twoZB;
    @BindView(R.id.twoGG)
    RadioButton twoGG;
    @BindView(R.id.twoBB)
    RadioButton twoBB;
    @BindView(R.id.twoZG)
    RadioButton twoZG;
    @BindView(R.id.rgTools)
    RadioGroup rgTools;
    @BindView(R.id.twoImg)
    ImageView twoImg;
    private HomeFragment homeFragment;
    private BillowingVideo billowingVideo;
    private LiveChina liveChina;
    private PandaBroadcast pandaBroadcast;
    private PandaLive pandaLive;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_two;
    }

    @Override
    protected void initView() {
        //获取权限
        checkPermission();
        twoTitle.setVisibility(View.INVISIBLE);

        homeFragment = new HomeFragment();

        new HomePresenter(homeFragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content, homeFragment);
        transaction.commit();

        initDate();
    }


    public void checkPermission() {
        //判断Android版本   获取需要的权限
        //  存储 读写权限
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> permissionStrs = new ArrayList<>();
            int hasWriteSdcardPermission =
                    ContextCompat.checkSelfPermission(
                            TwoActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (hasWriteSdcardPermission !=
                    PackageManager.PERMISSION_GRANTED) {
                permissionStrs.add(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                );
            }

            int hasCameraPermission = ContextCompat.checkSelfPermission(
                    TwoActivity.this,
                    Manifest.permission.CAMERA);
            if (hasCameraPermission != PackageManager.PERMISSION_GRANTED) {
                permissionStrs.add(Manifest.permission.CAMERA);
            }
            String[] stringArray = permissionStrs.toArray(new String[0]);
            if (permissionStrs.size() > 0) {
                requestPermissions(stringArray,
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }
    }

    //权限设置后的回调函数，判断相应设置，requestPermissions传入的参数为几个权限，则permissions和grantResults为对应权限和设置结果
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                //可以遍历每个权限设置情况
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //这里写你需要相关权限的操作
                } else {
                    Toast.makeText(TwoActivity.this,
                            "权限没有开启", Toast.LENGTH_SHORT).show();
                }
        }
        super.onRequestPermissionsResult(requestCode, permissions,
                grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    public void initDate() {

        rgTools.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                showFragmete(transaction);
                if (i == R.id.twoZH) {
                    //正常显示图片
                    twoImg.setVisibility(View.VISIBLE);
                    //隐藏标题Text并保留所占空间
                    twoTitle.setVisibility(View.INVISIBLE);
                    //正常显示图片
                    twoHD.setVisibility(View.VISIBLE);
                    if (homeFragment == null) {

                        homeFragment = new HomeFragment();


                        transaction.add(R.id.content, homeFragment, "HomeFragment");

                    } else {
                        transaction.show(homeFragment);

                    }
                } else if (i == R.id.twoZB) {
                    twoTitle.setVisibility(View.VISIBLE);
                    //隐藏控件并保留控件所占空间
                    twoHD.setVisibility(View.INVISIBLE);
                    twoImg.setVisibility(View.INVISIBLE);
                    twoTitle.setText(R.string.zhibo);
                    if (pandaLive == null) {

                        pandaLive = new PandaLive();
                        transaction.add(R.id.content, pandaLive);

                    } else {
                        transaction.show(pandaLive);
                    }
                } else if (i == R.id.twoGG) {

                    twoTitle.setVisibility(View.VISIBLE);
                    //隐藏控件并保留控件所占空间

                    twoHD.setVisibility(View.INVISIBLE);
                    twoImg.setVisibility(View.INVISIBLE);
                    twoTitle.setText(R.string.gungun);
                    if (billowingVideo == null) {

                        billowingVideo = new BillowingVideo();
                        new BillowingVideoPresenter(billowingVideo);
                        transaction.add(R.id.content, billowingVideo);

                    } else {
                        transaction.show(billowingVideo);

                    }
                } else if (i == R.id.twoBB) {
                    twoTitle.setVisibility(View.VISIBLE);
                    //隐藏控件并保留控件所占空间

                    twoHD.setVisibility(View.INVISIBLE);
                    twoImg.setVisibility(View.INVISIBLE);
                    twoTitle.setText(R.string.bobao);
                    //判断当前Fragment是否存在
                    //如果不存在
                    if (pandaBroadcast == null) {
                        //创建Fragment
                        pandaBroadcast = new PandaBroadcast();
                        //并且添加到FragmentLayout
                        transaction.add(R.id.content, pandaBroadcast);

                    } else {
                        //如果有这个Fragment  那么就直接展示
                        transaction.show(pandaBroadcast);
                    }
                } else if (i == R.id.twoZG) {
                    twoTitle.setVisibility(View.VISIBLE);
                    //隐藏控件并保留控件所占空间

                    twoHD.setVisibility(View.INVISIBLE);
                    twoImg.setVisibility(View.INVISIBLE);
                    twoTitle.setText(R.string.zhongguo);
                    if (liveChina == null) {

                        liveChina = new LiveChina();
                        transaction.add(R.id.content, liveChina);
                    } else {
                        transaction.show(liveChina);
                    }
                }
                transaction.commit();
            }
        });
    }

    public void showFragmete(FragmentTransaction transaction) {
        if (billowingVideo != null) {

            transaction.hide(billowingVideo);
        }
        if (liveChina != null) {
            transaction.hide(liveChina);
        }
        if (pandaBroadcast != null) {
            transaction.hide(pandaBroadcast);

        }
        if (pandaLive != null) {
            transaction.hide(pandaLive);
        }
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }

    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    //如果两次按键时间间隔大于2秒，则不退出
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;//更新firstTime
                    return true;
                } else {                                                    //两次按键小于2秒时，退出应用
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);

    }

    @Override
    public void onBackPressed() {
        if (mBackKeyPressedTimes == 0) {
            Toast.makeText(this, "再按一次退出程序 ", Toast.LENGTH_SHORT).show();
            mBackKeyPressedTimes = 1;
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        mBackKeyPressedTimes = 0;
                    }
                }
            }.start();

        } else {
            App.context.finish();
        }
        super.onBackPressed();
    }

    @OnClick({R.id.twoHD, R.id.twoLonge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.twoHD:
                break;
            case R.id.twoLonge:
                break;
        }
    }
}
