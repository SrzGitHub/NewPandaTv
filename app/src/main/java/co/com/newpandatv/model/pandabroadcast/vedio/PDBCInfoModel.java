package co.com.newpandatv.model.pandabroadcast.vedio;


import co.com.newpandatv.model.biz.BaseModel;
import co.com.newpandatv.model.entity.PDBCInfotwoBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * 作者：Liyuxing on 2017/9/16 09:17
 * 邮箱：3226974614@qq.com
 */

public interface PDBCInfoModel extends BaseModel {

    void getPDBCinfo(MyNetWorkCallback<PDBCInfotwoBean> callback);

}
