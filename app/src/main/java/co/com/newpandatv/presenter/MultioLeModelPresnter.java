package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.MultioLeModel;
import co.com.newpandatv.model.biz.MultioLeModelImpl;
import co.com.newpandatv.model.entity.MultioLeBeans;
import co.com.newpandatv.module.home.contract.MultioLeModelContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class MultioLeModelPresnter implements MultioLeModelContract.MultioLePresnter {
    private MultioLeModel multioLeModel;
    private MultioLeModelContract.View multioLeModelContractView;
    public MultioLeModelPresnter(MultioLeModelContract.View multioLeModelContractView){
        this.multioLeModelContractView= multioLeModelContractView;
        this.multioLeModelContractView.setPresenter(this);
        multioLeModel = new MultioLeModelImpl();

    }
    @Override
    public void start() {
        multioLeModelContractView.showProgressDialog();
        multioLeModel.getMultioLe(new MyNetWorkCallback<MultioLeBeans>() {
            @Override
            public void onSuccess(MultioLeBeans multioLeBeans) {
                multioLeModelContractView.setResult(multioLeBeans);
                multioLeModelContractView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                multioLeModelContractView.showMessage(errorMsg);
            }
        });

    }
}
