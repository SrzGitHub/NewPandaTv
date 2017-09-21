package co.com.newpandatv.model.biz;

import co.com.newpandatv.model.entity.BillowingItemBean;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by 小七七 on 2017/9/20.
 */

public interface BillowingbottomModel extends BaseModel {

    void getBillowingbottomModel(MyNetWorkCallback<BillowingItemBean> callback);
}
