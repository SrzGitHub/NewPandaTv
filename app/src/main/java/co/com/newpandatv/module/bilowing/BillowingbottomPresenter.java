package co.com.newpandatv.module.bilowing;

import co.com.newpandatv.model.biz.BillowingbottomModel;
import co.com.newpandatv.model.biz.BillowingbottomModelImpl;
import co.com.newpandatv.model.entity.BillowingItemBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/20.
 */

public class BillowingbottomPresenter implements BillowingbottomContract.Presenter {

    BillowingbottomContract.View billowingbottomView;
    private final BillowingbottomModel billowingbottomModel;

    public BillowingbottomPresenter(BillowingbottomContract.View billowingbottomView) {
        this.billowingbottomView = billowingbottomView;
        this.billowingbottomView.setPresenter(this);

        billowingbottomModel = new BillowingbottomModelImpl();
    }

    @Override
    public void start() {

        billowingbottomModel.getBillowingbottomModel(new MyNetWorkCallback<BillowingItemBean>() {
            @Override
            public void onSuccess(BillowingItemBean billowingItemBean) {
                billowingbottomView.setResult(billowingItemBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                billowingbottomView.showMessage(errorMsg);
            }
        });
    }
}
