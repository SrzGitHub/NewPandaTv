package co.com.newpandatv.model.biz;

import co.com.newpandatv.app.App;
import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.WonderfuMomentBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import co.com.newpandatv.view.fragment.pandalive_fragment.WonderfulMoment;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class WonderfulMomentModelImpl implements WonderfulMomentModel {


    @Override
    public void getWonderFu(MyNetWorkCallback<WonderfuMomentBean> callback) {
       int pagr =1;
        iHttp.get(UrlsUtils.Wonderful+ App.PAGER,null,callback);
    }
}
