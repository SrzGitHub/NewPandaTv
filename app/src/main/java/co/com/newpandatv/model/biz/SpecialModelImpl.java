package co.com.newpandatv.model.biz;

import co.com.newpandatv.app.App;
import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.SpecialBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class SpecialModelImpl implements SpecialModel {
    @Override
    public void getSpecialModel(MyNetWorkCallback<SpecialBean> callback) {
        iHttp.get(UrlsUtils.PROGREM+ App.PAGER,null,callback);
    }
}
