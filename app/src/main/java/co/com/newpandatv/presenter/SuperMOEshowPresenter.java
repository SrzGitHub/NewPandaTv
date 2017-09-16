package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.SuperMOEshowModel;
import co.com.newpandatv.model.biz.SuperMOEshowModelImpl;
import co.com.newpandatv.model.entity.SuperMOEshowBean;
import co.com.newpandatv.module.home.contract.SuperMOEshowContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class SuperMOEshowPresenter implements SuperMOEshowContract.SuperPresnter {

    private SuperMOEshowModel superMOEshowModel;
    private SuperMOEshowContract.View superMOEshowContractView;
    public SuperMOEshowPresenter(SuperMOEshowContract.View superMOEshowContractView){
        this.superMOEshowContractView =superMOEshowContractView;
        this.superMOEshowContractView.setPresenter(this);
        superMOEshowModel = new SuperMOEshowModelImpl();
    }

    @Override
    public void start() {
        superMOEshowContractView.showProgressDialog();
        superMOEshowModel.getSuperMOEshow(new MyNetWorkCallback<SuperMOEshowBean>() {
            @Override
            public void onSuccess(SuperMOEshowBean superMOEshowBean) {
                superMOEshowContractView.setResult(superMOEshowBean);
                superMOEshowContractView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                superMOEshowContractView.showMessage(errorMsg);
            }
        });

    }
}
