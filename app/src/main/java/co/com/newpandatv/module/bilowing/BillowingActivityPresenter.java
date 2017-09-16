package co.com.newpandatv.module.bilowing;

import co.com.newpandatv.model.biz.BillowMovwModel;
import co.com.newpandatv.model.biz.BillowingMoveModelImpl;
import co.com.newpandatv.model.entity.BillowingMoveBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/15.
 */

public class BillowingActivityPresenter implements BillowingActivityContract.Presenter {

    BillowingActivityContract.View billowingActivity;
    private final BillowMovwModel billowMovwModel;


    public BillowingActivityPresenter(BillowingActivityContract.View billowingActivity) {
        this.billowingActivity = billowingActivity;
        this.billowingActivity.setPresenter(this);

        billowMovwModel = new BillowingMoveModelImpl();
    }

    @Override
    public void start() {

        billowMovwModel.getBillowMovmModel(new MyNetWorkCallback<BillowingMoveBean>() {
            @Override
            public void onSuccess(BillowingMoveBean billowingMoveBean) {
                billowingActivity.setResult(billowingMoveBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                billowingActivity.showMessage(errorMsg);
            }
        });
    }
}
