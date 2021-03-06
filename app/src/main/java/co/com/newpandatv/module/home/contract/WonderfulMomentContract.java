package co.com.newpandatv.module.home.contract;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.WonderfuMomentBean;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface WonderfulMomentContract {
    interface View extends BaseView<WonderPresenter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(WonderfuMomentBean wonderfuMomentBean);
        void showMessage(String msg);
    }

    interface WonderPresenter extends BasePresenter {

    }
}
