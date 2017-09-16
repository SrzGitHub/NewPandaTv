package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.TopModel;
import co.com.newpandatv.model.biz.TopModelImpl;
import co.com.newpandatv.model.entity.TopBean;
import co.com.newpandatv.module.home.contract.TopContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class TopModelPresnter implements TopContract.TopPresnter {

    private TopContract.View topContractView;
    private TopModel topModel;

    public TopModelPresnter(TopContract.View topContractView){
        this.topContractView = topContractView;
        this.topContractView.setPresenter(this);
        topModel = new TopModelImpl();
    }
    @Override
    public void start() {
        topContractView.showProgressDialog();
        topModel.getTopModel(new MyNetWorkCallback<TopBean>() {
            @Override
            public void onSuccess(TopBean topBean) {
                topContractView.setResult(topBean);
                topContractView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                topContractView.showMessage(errorMsg);
            }
        });

    }
}
