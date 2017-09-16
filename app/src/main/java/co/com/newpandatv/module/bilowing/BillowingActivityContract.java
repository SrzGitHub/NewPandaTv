package co.com.newpandatv.module.bilowing;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.BillowingMoveBean;

/**
 * Created by 小七七 on 2017/9/15.
 */

public interface BillowingActivityContract {

    interface View extends BaseView<Presenter>{

        void setResult(BillowingMoveBean billowingMoveBean);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter{

    }
}
