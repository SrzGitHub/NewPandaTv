package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.DonModel;
import co.com.newpandatv.model.biz.DonModelImpl;
import co.com.newpandatv.model.entity.DonBean;
import co.com.newpandatv.module.home.contract.DonModelContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class DonModelPresnter implements DonModelContract.DonPresnter {


    private DonModel donModel;
    private DonModelContract.View conTractView;
    public DonModelPresnter(DonModelContract.View conTractView){
        this.conTractView =conTractView;
        conTractView.setPresenter(this);
        donModel  =new DonModelImpl();

    }

    @Override
    public void start() {
        conTractView.showProgressDialog();
        donModel.getDonModel(new MyNetWorkCallback<DonBean>() {
            @Override
            public void onSuccess(DonBean donBean) {
                conTractView.setResult(donBean);
                conTractView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                conTractView.showMessage(errorMsg);
            }
        });
    }
}
