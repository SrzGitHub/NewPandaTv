package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.WonderfulMomentModel;
import co.com.newpandatv.model.biz.WonderfulMomentModelImpl;
import co.com.newpandatv.model.entity.WonderfuMomentBean;
import co.com.newpandatv.module.home.contract.WonderfulMomentContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class WonderfulMomentPresenter implements WonderfulMomentContract.WonderPresenter {

   private WonderfulMomentModel wonderfulMomentModel;
   private WonderfulMomentContract.View wonderfulView;

    public  WonderfulMomentPresenter(WonderfulMomentContract.View wonderfulView){
        this.wonderfulView =wonderfulView;
        this.wonderfulView.setPresenter(this);
        wonderfulMomentModel = new WonderfulMomentModelImpl();

    }
    @Override
    public void start() {
            wonderfulView.showProgressDialog();
        wonderfulMomentModel.getWonderFu(new MyNetWorkCallback<WonderfuMomentBean>() {
            @Override
            public void onSuccess(WonderfuMomentBean wonderfuMomentBean) {

                wonderfulView.setResult(wonderfuMomentBean);
                wonderfulView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                wonderfulView.showMessage(errorMsg);
            }
        });

    }
}
