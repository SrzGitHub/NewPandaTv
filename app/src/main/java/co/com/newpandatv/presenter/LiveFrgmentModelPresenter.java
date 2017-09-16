package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.LiveFrgmentModel;
import co.com.newpandatv.model.biz.LiveFrgmentModelImpl;
import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.module.home.contract.LiveFrgmentModelContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class LiveFrgmentModelPresenter implements LiveFrgmentModelContract.LivePresnter {

   private LiveFrgmentModel liveFrgmentMode;
   private LiveFrgmentModelContract.View  liveFrgmentModelContractView;

   public LiveFrgmentModelPresenter(LiveFrgmentModelContract.View  liveFrgmentModelContractView){
       this.liveFrgmentModelContractView =liveFrgmentModelContractView;
       this.liveFrgmentModelContractView.setPresenter(this);
       liveFrgmentMode = new LiveFrgmentModelImpl();

   }

    @Override
    public void start() {
        liveFrgmentModelContractView.showProgressDialog();
        liveFrgmentMode.getLiveFrgment(new MyNetWorkCallback<PandaLiveBean>() {
            @Override
            public void onSuccess(PandaLiveBean pandaLiveBean) {
                liveFrgmentModelContractView.setResult(pandaLiveBean);
                liveFrgmentModelContractView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                liveFrgmentModelContractView.showMessage(errorMsg);
            }
        });
    }
}
