package co.com.newpandatv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import co.com.newpandatv.model.entity.ZhiBoChina;

/**
 * Created by lenovo on 2017/9/13.
 */

public class Myadapter extends FragmentPagerAdapter {
    private List<ZhiBoChina.TablistBean> list1;
    private  List<Fragment> fragmentList;

    public Myadapter(FragmentManager fm, List<ZhiBoChina.TablistBean> list, List<Fragment> fragmentList) {
        super(fm);
        this.list1 = list;
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
        return list1.get(position).getTitle();
    }
}
