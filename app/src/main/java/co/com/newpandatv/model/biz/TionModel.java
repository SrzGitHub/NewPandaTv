package co.com.newpandatv.model.biz;

import co.com.newpandatv.model.entity.TionBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/16.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface TionModel extends BaseModel {
    void getTionModel(MyNetWorkCallback<TionBean> callback);

}
