package co.com.newpandatv.module.pandabroadcast.vedio;


import co.com.newpandatv.model.entity.PDBCInfotwoBean;
import co.com.newpandatv.model.pandabroadcast.vedio.PDBCInfoModel;
import co.com.newpandatv.model.pandabroadcast.vedio.PDBCInfoModelImpl;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * 作者：Liyuxing on 2017/9/16 14:30
 * 邮箱：3226974614@qq.com
 */

public class PDBCInfoPresenter implements PDBCInfoContract.Presenter {

    private PDBCInfoModel ipdbcModel;
    private PDBCInfoContract.View homeview;


    public PDBCInfoPresenter(PDBCInfoContract.View homeview) {
        this.homeview = homeview;
        this.homeview.setPresenter(this);
        ipdbcModel = new PDBCInfoModelImpl();
    }


    @Override
    public void start() {
        ipdbcModel.getPDBCinfo(new MyNetWorkCallback<PDBCInfotwoBean>() {
            @Override
            public void onSuccess(PDBCInfotwoBean pdbcInfotwoBean) {
                homeview.setResult(pdbcInfotwoBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeview.showMessage(errorMsg);
            }
        });
    }
}
