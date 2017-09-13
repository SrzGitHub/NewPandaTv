package co.com.newpandatv.module.home;


import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.PandaLiveBean;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(PandaLiveBean pandaLiveBean);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter {

    }
}
