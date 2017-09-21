package co.com.newpandatv.model.pandabroadcast;


import co.com.newpandatv.config.Urls;
import co.com.newpandatv.model.entity.PandaBroadCastBean;
import co.com.newpandatv.model.entity.PandaBroadcastInfoBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * 作者：Liyuxing on 2017/9/14 09:12
 * 邮箱：3226974614@qq.com
 */

public class PBDCModelImpl implements IPDBCModel {

    @Override
    public void getPDNC(MyNetWorkCallback<PandaBroadCastBean> callback) {
        iHttp.get(Urls.PANDABROADCAST,null,callback);

    }

    @Override
    public void getPDBCinfo(MyNetWorkCallback<PandaBroadcastInfoBean> callback) {
        iHttp.get(Urls.PANDABROADCASTINFO,null,callback);
    }


}
