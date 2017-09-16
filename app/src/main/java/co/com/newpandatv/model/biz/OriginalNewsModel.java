package co.com.newpandatv.model.biz;

import co.com.newpandatv.model.entity.OriginalNewsBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface OriginalNewsModel extends BaseModel{
    void getOriginalNews(MyNetWorkCallback<OriginalNewsBean> callback);

}
