package co.com.newpandatv.module.bilowing;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.BillowingItemBean;

/**
 * Created by 小七七 on 2017/9/20.
 */

public interface BillowingbottomContract {

    interface View extends BaseView<Presenter> {

        void setResult(BillowingItemBean billowingItemBean);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter {

    }
}
