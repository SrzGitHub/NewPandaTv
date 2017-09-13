package co.com.newpandatv.module.home.contract;


import co.com.newpandatv.base.BasePresenter;
import co.com.newpandatv.base.BaseView;
import co.com.newpandatv.model.entity.DonBean;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface DonModelContract {
    interface  View extends BaseView<DonPresnter>{
        void showProgressDialog();
        void dismissDialog();
        void setResult(DonBean donBean);
        void showMessage(String msg);

    }
    interface  DonPresnter extends BasePresenter{

    }

}
