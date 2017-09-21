package co.com.newpandatv.model.biz;

import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.BillowingItemBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/20.
 */

public class BillowingbottomModelImpl implements BillowingbottomModel{
    @Override
    public void getBillowingbottomModel(MyNetWorkCallback<BillowingItemBean> callback) {
        iHttp.get(UrlsUtils.SPLENDURL,null,callback);
    }
}
