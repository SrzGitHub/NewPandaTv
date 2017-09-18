package co.com.newpandatv.livefragment.contract_presenter;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.model.entity.WcheBean;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface WatchAndChatModelContract {
    interface View extends BaseView<WatchAndPresenter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(WcheBean wcheBean);
        void showMessage(String msg);
    }

    interface WatchAndPresenter extends BasePresenter {

    }
}
