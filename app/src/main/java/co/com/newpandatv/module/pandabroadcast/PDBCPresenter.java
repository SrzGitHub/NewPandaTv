package co.com.newpandatv.module.pandabroadcast;


import co.com.newpandatv.model.entity.PandaBroadCastBean;
import co.com.newpandatv.model.entity.PandaBroadcastInfoBean;
import co.com.newpandatv.model.pandabroadcast.IPDBCModel;
import co.com.newpandatv.model.pandabroadcast.PBDCModelImpl;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * 作者：Liyuxing on 2017/9/14 09:16
 * 邮箱：3226974614@qq.com
 */

public class PDBCPresenter implements PDBCContract.Presenter {

    private IPDBCModel ipdbcModel;
    private PDBCContract.View homeview;

    public PDBCPresenter(PDBCContract.View homeview) {
        this.homeview = homeview;
        this.homeview.setPresenter(this);
        ipdbcModel = new PBDCModelImpl();
    }

    @Override
    public void start() {
        ipdbcModel.getPDNC(new MyNetWorkCallback<PandaBroadCastBean>() {
            @Override
            public void onSuccess(PandaBroadCastBean pandaBroadCastBean) {
                homeview.setResult(pandaBroadCastBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeview.showMessage(errorMsg);
            }
        });

        ipdbcModel.getPDBCinfo(new MyNetWorkCallback<PandaBroadcastInfoBean>() {
            @Override
            public void onSuccess(PandaBroadcastInfoBean pandaBroadcastInfoBean) {
                homeview.setInfo(pandaBroadcastInfoBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeview.showMessage(errorMsg);
            }
        });

        ipdbcModel.getPDBCFootInfo(new MyNetWorkCallback<PandaBroadcastInfoBean>() {
            @Override
            public void onSuccess(PandaBroadcastInfoBean pandaBroadcastInfoBean) {
                homeview.setFootInfo(pandaBroadcastInfoBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            homeview.showMessage(errorMsg);
            }
        });

    }
}
