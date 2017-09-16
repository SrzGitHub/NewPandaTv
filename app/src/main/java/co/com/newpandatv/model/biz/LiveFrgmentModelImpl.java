package co.com.newpandatv.model.biz;

import co.com.newpandatv.config.Urls;
import co.com.newpandatv.model.entity.PandaLiveBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class LiveFrgmentModelImpl implements LiveFrgmentModel {
    @Override
    public void getLiveFrgment(MyNetWorkCallback<PandaLiveBean> callback) {
        iHttp.get(Urls.PANDALIVE,null,callback);
    }
}
