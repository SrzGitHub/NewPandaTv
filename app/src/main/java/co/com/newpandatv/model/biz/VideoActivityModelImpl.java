package co.com.newpandatv.model.biz;

import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.VideoBeans;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import co.com.newpandatv.view.activity.VideoActivity;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class VideoActivityModelImpl implements VideoActivityModel {
    @Override
    public void getVideoActivity(MyNetWorkCallback<VideoBeans> callback) {
        iHttp.get(UrlsUtils.URLK+ VideoActivity.vid,null,callback);
    }
}
