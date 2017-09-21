package co.com.newpandatv.model.pandabroadcast;


import co.com.newpandatv.model.biz.BaseModel;
import co.com.newpandatv.model.entity.PandaBroadCastBean;
import co.com.newpandatv.model.entity.PandaBroadcastInfoBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * 作者：Liyuxing on 2017/9/14 09:10
 * 邮箱：3226974614@qq.com
 */

public interface IPDBCModel extends BaseModel {

    void getPDNC(MyNetWorkCallback<PandaBroadCastBean> callback);
    void getPDBCinfo(MyNetWorkCallback<PandaBroadcastInfoBean> callback);

}
