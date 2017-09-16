package co.com.newpandatv.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.model.entity.BillowingMoveBean;
import co.com.newpandatv.module.bilowing.BillowingActivityContract;
import co.com.newpandatv.module.bilowing.BillowingActivityPresenter;
import co.com.newpandatv.view.listview.MyListView;

public class BillowingbottomActivity extends BaseActivity implements BillowingActivityContract.View {


    @BindView(R.id.butImg)
    ImageView butImg;
    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.mBillowing_bottom_listview)
    MyListView mBillowingBottomListview;
    @BindView(R.id.mShoucang)
    Button mShoucang;
    @BindView(R.id.mFenxiang)
    Button mFenxiang;
    private BillowingActivityContract.Presenter presenter;
    int ABS =0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_billowingbottom;
    }

    @Override
    protected void initView() {
        presenter = new BillowingActivityPresenter(this);
        presenter.start();


        textName.setText("7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777");
        Log.e("TAG", "initView: "+textName.toString() );
        textName.setVisibility(View.GONE);

    }

    @Override
    public void setPresenter(BillowingActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setResult(BillowingMoveBean billowingMoveBean) {

        Log.e("TAG", "=======" + billowingMoveBean.toString());
    }

    @Override
    public void showMessage(String msg) {

        Toast.makeText(this, "请求失败" + msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.butImg, R.id.mShoucang, R.id.mFenxiang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.butImg:
                switch (ABS){
                    case 0:
                        ABS=1;
                        textName.setText("显示");
                        Log.e("ATG",textName.toString());
                        textName.setVisibility(View.VISIBLE);

                        break;
                    case 1:
                        ABS=0;
                        textName.setText("隐藏");
                        Log.e("ATG",textName.toString());
                        textName.setVisibility(View.GONE);
                        break;
                }
                break;
            case R.id.mShoucang:
                break;
            case R.id.mFenxiang:
                break;
        }
    }
}
