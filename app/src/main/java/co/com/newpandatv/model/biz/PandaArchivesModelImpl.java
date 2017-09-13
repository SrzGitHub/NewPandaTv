package co.com.newpandatv.model.biz;

import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.PandaArchivesBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaArchivesModelImpl implements PandaArchivesModel {
    @Override
    public void getPandaArchivesModel(MyNetWorkCallback<PandaArchivesBean> callback) {
        iHttp.get(UrlsUtils.PANDAFILE,null,callback);
    }
}
