package co.com.newpandatv.module.home.contract;

import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.TionBean;

/**
 * Created by Administrator on 2017/9/16.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface TionModelContract {
    interface View extends BaseView<TionPresenter>{

        void showProgressDialog();
        void dismissDialog();
        void setResult(TionBean tionBean);
        void showMessage(String msg);

    }


     interface TionPresenter extends BasePresenter{}



}
