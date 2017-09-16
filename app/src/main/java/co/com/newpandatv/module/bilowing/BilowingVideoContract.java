package co.com.newpandatv.module.bilowing;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.BillowingVideoBean;

/**
 * Created by 小七七 on 2017/9/14.
 */

public interface BilowingVideoContract {

    interface View extends BaseView<Presenter>{
        void showProgressDialog();
        void dismissDialog();
        void setResult(BillowingVideoBean billowingVideoBean);
        void showMessage(String msg);
    }
    interface Presenter extends BasePresenter{

    }
}
