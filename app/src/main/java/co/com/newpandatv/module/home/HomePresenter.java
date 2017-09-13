package co.com.newpandatv.module.home;


import co.com.newpandatv.model.biz.IPandaLiveModel;
import co.com.newpandatv.model.biz.PandaLiveModelImpl;
import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

public class HomePresenter implements HomeContract.Presenter {

    private IPandaLiveModel pandaLiveModel;
    private HomeContract.View homeView;

    public HomePresenter(HomeContract.View homeView){
        this.homeView = homeView;
        this.homeView.setPresenter(this);
        pandaLiveModel = new PandaLiveModelImpl();
    }

    @Override
    public void start() {

        pandaLiveModel.getPadDaLive(new MyNetWorkCallback<PandaLiveBean>() {
            @Override
            public void onSuccess(PandaLiveBean pandaLiveBean) {

                homeView.setResult(pandaLiveBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                homeView.showMessage(errorMsg);
            }
        });
    }
}
