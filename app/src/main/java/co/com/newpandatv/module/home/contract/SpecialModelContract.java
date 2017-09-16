package co.com.newpandatv.module.home.contract;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.model.entity.SpecialBean;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface SpecialModelContract {
    interface  View extends BaseView<SpeciaPresnter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(SpecialBean specialBean);
        void showMessage(String msg);

    }
    interface  SpeciaPresnter extends BasePresenter {

    }
}
