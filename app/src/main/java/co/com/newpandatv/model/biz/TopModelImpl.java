package co.com.newpandatv.model.biz;

import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.TopBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class TopModelImpl implements TopModel {



    @Override
    public void getTopModel(MyNetWorkCallback<TopBean> callback) {
        iHttp.get(UrlsUtils.TOP,null,callback);
    }
}
