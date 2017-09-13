package co.com.newpandatv.model.biz;


import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

public interface IPandaLiveModel extends BaseModel{

    void getPadDaLive(MyNetWorkCallback<PandaLiveBean> callback);
}
