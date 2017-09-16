package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.PandaArchivesModel;
import co.com.newpandatv.model.biz.PandaArchivesModelImpl;
import co.com.newpandatv.model.entity.PandaArchivesBean;
import co.com.newpandatv.module.home.contract.PandaArchivesModeContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaArchivesModelPresenter implements PandaArchivesModeContract.PandaArchivesPresenter {

   private PandaArchivesModel pandaArchivesModel;
    private PandaArchivesModeContract.View pandaArchivesView;
    public PandaArchivesModelPresenter(PandaArchivesModeContract.View pandaArchivesView){
        this.pandaArchivesView =pandaArchivesView;
        this.pandaArchivesView.setPresenter(this);
        pandaArchivesModel = new PandaArchivesModelImpl();


    }

    @Override
    public void start() {
        pandaArchivesView.showProgressDialog();
        pandaArchivesModel.getPandaArchivesModel(new MyNetWorkCallback<PandaArchivesBean>() {
            @Override
            public void onSuccess(PandaArchivesBean pandaArchivesBean) {
                pandaArchivesView.setResult(pandaArchivesBean);
                pandaArchivesView.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandaArchivesView.showMessage(errorMsg);
            }
        });
    }
}
