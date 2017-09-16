package co.com.newpandatv.model.biz;

import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.BillowingVideoBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/14.
 */

public class BillowingModelImpl implements BillowingModel {

    @Override
    public void getBillowingModel(MyNetWorkCallback<BillowingVideoBean> callback) {
        iHttp.get(UrlsUtils.GUNGUN,null,callback);
    }
}
