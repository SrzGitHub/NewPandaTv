package co.com.newpandatv.module.pandabroadcast.vedio;


import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.PDBCInfotwoBean;

/**
 * 作者：Liyuxing on 2017/9/16 14:28
 * 邮箱：3226974614@qq.com
 */

public interface PDBCInfoContract {
    interface View extends BaseView<PDBCInfoContract.Presenter> {

        void setResult(PDBCInfotwoBean pdbcinfoBean);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter {

    }
}
