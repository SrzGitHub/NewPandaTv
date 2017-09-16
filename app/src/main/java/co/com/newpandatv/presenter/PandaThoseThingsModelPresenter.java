package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.PandaThoseThingsModel;
import co.com.newpandatv.model.biz.PandaThoseThingsModelImpl;
import co.com.newpandatv.model.entity.PandaThoseThingsBean;
import co.com.newpandatv.module.home.contract.PandaThoseThingsModelContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaThoseThingsModelPresenter implements PandaThoseThingsModelContract.ThosePresnter {

    private PandaThoseThingsModelContract.View pandaThoseThingsModelContractView;
    private PandaThoseThingsModel pandaThoseThingsModel;
    public PandaThoseThingsModelPresenter(PandaThoseThingsModelContract.View pandaThoseThingsModelContractView){
        this.pandaThoseThingsModelContractView =pandaThoseThingsModelContractView;
        this.pandaThoseThingsModelContractView.setPresenter(this);
        pandaThoseThingsModel = new PandaThoseThingsModelImpl();

    }
    @Override
    public void start() {
        pandaThoseThingsModelContractView.showProgressDialog();
        pandaThoseThingsModel.getPandaThoseThings(new MyNetWorkCallback<PandaThoseThingsBean>() {
            @Override
            public void onSuccess(PandaThoseThingsBean pandaThoseThingsBean) {
                pandaThoseThingsModelContractView.setResult(pandaThoseThingsBean);
                pandaThoseThingsModelContractView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandaThoseThingsModelContractView.showMessage(errorMsg);
            }
        });
    }
}
