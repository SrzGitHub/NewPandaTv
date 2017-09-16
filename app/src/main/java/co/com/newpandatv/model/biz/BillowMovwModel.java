package co.com.newpandatv.model.biz;

import co.com.newpandatv.model.entity.BillowingMoveBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/15.
 */

public interface BillowMovwModel extends BaseModel {

    void getBillowMovmModel(MyNetWorkCallback<BillowingMoveBean> callback);
}
