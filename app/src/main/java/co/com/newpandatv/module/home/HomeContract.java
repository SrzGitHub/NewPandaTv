package co.com.newpandatv.module.home;


import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.home_video_bean.PandaLiveLiuBean;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(PandaLiveLiuBean pandaLiveLiuBean);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter {

    }
}
