package co.com.newpandatv.model.biz;


import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.model.entity.home_video_bean.PandaLiveLiuBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

public interface IPandaLiveModel extends BaseModel{

    void getPadDaLive(MyNetWorkCallback<PandaLiveLiuBean> callback);
}
