package co.com.newpandatv.app;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Config;


import co.com.newpandatv.base.BaseActivity;


/**
 * Created by xingge on 2017/7/11.
 */

public class App extends Application {

    public static BaseActivity context = null;
<<<<<<< HEAD

=======
    public static Context mContext;
    public static int PAGER =1;

    @Override
    public void onCreate() {
        super.onCreate();
//        Config.DEBUG = true;
////        UMShareAPI.get(this);
//
//        PlatformConfig.setQQZone("1106177639","5BiKQxuvirWznDX3");
        mContext =getApplicationContext();
    }



    /**
     * 获取全局的Context
     * @return
     */
    public static Context getContext(){
        return context;
    }
>>>>>>> origin/master
}
