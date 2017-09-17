package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.TionModel;
import co.com.newpandatv.model.biz.TionModelImpl;
import co.com.newpandatv.model.entity.TionBean;
import co.com.newpandatv.module.home.contract.TionModelContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/16.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class TionModelPresenter implements TionModelContract.TionPresenter {

    private TionModel tionModel;
    private TionModelContract.View tionModelContractView;

    public TionModelPresenter(TionModelContract.View tionModelContractView){
        this.tionModelContractView= tionModelContractView;
        this.tionModelContractView.setPresenter(this);
        tionModel = new TionModelImpl();

    }

    @Override
    public void start() {
        tionModel.getTionModel(new MyNetWorkCallback<TionBean>() {
            @Override
            public void onSuccess(TionBean tionBean) {
                tionModelContractView.setResult(tionBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                tionModelContractView.showMessage(errorMsg);
            }
        });

    }
}
