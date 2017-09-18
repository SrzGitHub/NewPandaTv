package co.com.newpandatv.model.pandabroadcast.vedio;

import co.com.newpandatv.config.Urls;
import co.com.newpandatv.model.entity.PDBCInfotwoBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * 作者：Liyuxing on 2017/9/16 14:26
 * 邮箱：3226974614@qq.com
 */

public class PDBCInfoModelImpl implements PDBCInfoModel{
    @Override
    public void getPDBCinfo(MyNetWorkCallback<PDBCInfotwoBean> callback) {
        iHttp.get(Urls.PDBCINFOURL,null,callback);
    }
}
