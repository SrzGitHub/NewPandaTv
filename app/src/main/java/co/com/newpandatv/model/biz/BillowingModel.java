package co.com.newpandatv.model.biz;

import co.com.newpandatv.model.entity.BillowingVideoBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/14.
 */

public interface BillowingModel extends BaseModel {

    void getBillowingModel(MyNetWorkCallback<BillowingVideoBean> callback);
}
