package co.com.newpandatv.livefragment.contract_presenter;

import co.com.newpandatv.model.entity.WcheBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class WatchAndChatModelPresenter implements WatchAndChatModelContract.WatchAndPresenter {

    private WatchAndChatModel watchAndChatModel;
    private WatchAndChatModelContract.View  watchAndChatModelContractView;
    public WatchAndChatModelPresenter(WatchAndChatModelContract.View  watchAndChatModelContractView){
        this.watchAndChatModelContractView =watchAndChatModelContractView;
        this.watchAndChatModelContractView.setPresenter(this);
        watchAndChatModel = new WatchAndChatModelImpl();

    }

    @Override
    public void start() {
        watchAndChatModel.getWatchAndChatModel(new MyNetWorkCallback<WcheBean>() {
            @Override
            public void onSuccess(WcheBean wcheBean) {
                watchAndChatModelContractView.setResult(wcheBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                watchAndChatModelContractView.showMessage(errorMsg);
            }
        });

    }
}
