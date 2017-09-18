package co.com.newpandatv.module.pandabroadcast;


import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.PandaBroadCastBean;
import co.com.newpandatv.model.entity.PandaBroadcastInfoBean;

/**
 * 作者：Liyuxing on 2017/9/14 09:14
 * 邮箱：3226974614@qq.com
 */

public interface PDBCContract {

    interface View extends BaseView<PDBCContract.Presenter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(PandaBroadCastBean pdbcBean);
        void showMessage(String msg);
        void setInfo(PandaBroadcastInfoBean pdbcInfoBean);
        void setFootInfo(PandaBroadcastInfoBean pdbcInfoBean);
    }

    interface Presenter extends BasePresenter {

    }
}
