package co.com.newpandatv.module.home.contract;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.DonBean;
import co.com.newpandatv.model.entity.PandaArchivesBean;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface PandaArchivesModeContract {

    interface View extends BaseView<PandaArchivesPresenter>{
        void showProgressDialog();
        void dismissDialog();
        void setResult(PandaArchivesBean pandaArchivesBean);
        void showMessage(String msg);
    }
    interface  PandaArchivesPresenter extends BasePresenter{

    }

}
