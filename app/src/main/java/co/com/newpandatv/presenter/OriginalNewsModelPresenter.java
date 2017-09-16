package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.OriginalNewsModel;
import co.com.newpandatv.model.biz.OriginalNewsModelImpl;
import co.com.newpandatv.model.entity.OriginalNewsBean;
import co.com.newpandatv.module.home.contract.OriginalNewsModelContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class OriginalNewsModelPresenter implements OriginalNewsModelContract.OrNewsPresnter {

    private OriginalNewsModel originalNewsModel;
    private OriginalNewsModelContract.View originalNewsModelContractView;

    public OriginalNewsModelPresenter(OriginalNewsModelContract.View originalNewsModelContractView) {
        this.originalNewsModelContractView =originalNewsModelContractView;
        this.originalNewsModelContractView.setPresenter(this);
        originalNewsModel = new OriginalNewsModelImpl();

    }

    @Override
    public void start() {
        originalNewsModelContractView.showProgressDialog();
    originalNewsModel.getOriginalNews(new MyNetWorkCallback<OriginalNewsBean>() {
        @Override
        public void onSuccess(OriginalNewsBean originalNewsBean) {
            originalNewsModelContractView.setResult(originalNewsBean);
            originalNewsModelContractView.dismissDialog();
        }

        @Override
        public void onError(int errorCode, String errorMsg) {
        originalNewsModelContractView.showMessage(errorMsg);
        }
    });
    }
}
