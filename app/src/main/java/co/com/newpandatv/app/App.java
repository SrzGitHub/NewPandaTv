package co.com.newpandatv.app;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Config;


import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;

import co.com.newpandatv.base.BaseActivity;


/**
 * Created by xingge on 2017/7/11.
 */

public class App extends Application {

    public static BaseActivity context = null;


    public static Context mContext;
    public static int PAGER =1;

    @Override
    public void onCreate() {
        super.onCreate();


        QueuedWork.isUseThreadPool = false;

        UMShareAPI.get(this);
        com.umeng.socialize.Config.DEBUG =true;

        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "9c29cc8bc30f5edc087bde312ef083a1","http://sns.whalecloud.com");


        mContext =getApplicationContext();
    }



    /**
     * 获取全局的Context
     * @return
     */
    public static Context getContext(){
        return context;
    }

}
