package co.com.newpandatv.model.biz;


import co.com.newpandatv.config.Urls;
import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.model.entity.home_video_bean.PandaLiveLiuBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;


public class PandaLiveModelImpl implements IPandaLiveModel {

    @Override
    public void getPadDaLive(MyNetWorkCallback<PandaLiveLiuBean> callback) {
        //发送网络请求
        iHttp.get(Urls.PANDALIVE,null,callback);

    }
}
