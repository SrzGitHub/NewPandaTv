package co.com.newpandatv.model.biz;

import co.com.newpandatv.model.entity.VideoBeans;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface VideoActivityModel extends BaseModel {
    void getVideoActivity(MyNetWorkCallback<VideoBeans> callback);

}
