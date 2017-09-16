package co.com.newpandatv.module.home.contract;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.DonBean;
import co.com.newpandatv.model.entity.PandaLiveBean;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface LiveFrgmentModelContract {
    interface  View extends BaseView<LivePresnter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(PandaLiveBean pandaLiveBean);
        void showMessage(String msg);

    }
    interface  LivePresnter extends BasePresenter {

    }
}
