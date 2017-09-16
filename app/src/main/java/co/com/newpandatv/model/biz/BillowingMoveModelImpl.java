package co.com.newpandatv.model.biz;


import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.BillowingMoveBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/15.
 */

public class BillowingMoveModelImpl implements BillowMovwModel {

    @Override
    public void getBillowMovmModel(MyNetWorkCallback<BillowingMoveBean> callback) {
        iHttp.get(UrlsUtils.MOVIE,null,callback);
    }
}
