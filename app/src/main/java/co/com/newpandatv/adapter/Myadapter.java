package co.com.newpandatv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

import javax.security.auth.login.LoginException;

import co.com.newpandatv.model.entity.LiveChinabean;
import co.com.newpandatv.model.entity.ZhiBoChina;

import static com.umeng.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login;

/**
 * Created by lenovo on 2017/9/13.
 */

public class Myadapter extends FragmentPagerAdapter {
    private List<LiveChinabean.TablistBean> tablistBeen;
    private  List<Fragment> fragmentList;

    public Myadapter(FragmentManager fm, List<LiveChinabean.TablistBean> tablistBeen, List<Fragment> fragmentList) {
        super(fm);
        this.tablistBeen = tablistBeen;
        this.fragmentList = fragmentList;
    }



    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tablistBeen.get(position).getTitle();
    }
}
