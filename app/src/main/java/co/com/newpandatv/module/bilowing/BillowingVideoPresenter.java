package co.com.newpandatv.module.bilowing;

import co.com.newpandatv.model.biz.BillowingModel;
import co.com.newpandatv.model.biz.BillowingModelImpl;
import co.com.newpandatv.model.entity.BillowingVideoBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/14.
 */

public class BillowingVideoPresenter implements BilowingVideoContract.Presenter {

    private BilowingVideoContract.View bilowingVideoContractView;
    private BillowingModel model;

    public BillowingVideoPresenter(BilowingVideoContract.View bilowingVideoContractView) {
        this.bilowingVideoContractView = bilowingVideoContractView;
        this.bilowingVideoContractView.setPresenter(this);
        model = new BillowingModelImpl();

    }

    @Override
    public void start() {

        model.getBillowingModel(new MyNetWorkCallback<BillowingVideoBean>() {
            @Override
            public void onSuccess(BillowingVideoBean billowingVideoBean) {
                bilowingVideoContractView.setResult(billowingVideoBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                bilowingVideoContractView.showMessage(errorMsg);
            }
        });
    }
}
