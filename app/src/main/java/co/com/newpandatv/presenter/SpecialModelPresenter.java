package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.SpecialModel;
import co.com.newpandatv.model.biz.SpecialModelImpl;
import co.com.newpandatv.model.entity.SpecialBean;
import co.com.newpandatv.module.home.contract.SpecialModelContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class SpecialModelPresenter implements SpecialModelContract.SpeciaPresnter {

    private SpecialModel specialModel;
    private SpecialModelContract.View   specialModelContractView;
    public SpecialModelPresenter(SpecialModelContract.View   specialModelContractView){
        this.specialModelContractView =specialModelContractView;
        this.specialModelContractView.setPresenter(this);
        specialModel = new SpecialModelImpl();

    }
    @Override
    public void start() {
        specialModelContractView.showProgressDialog();
        specialModel.getSpecialModel(new MyNetWorkCallback<SpecialBean>() {
            @Override
            public void onSuccess(SpecialBean specialBean) {
                specialModelContractView.setResult(specialBean);
                specialModelContractView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                specialModelContractView.showMessage(errorMsg);
            }
        });


    }
}
