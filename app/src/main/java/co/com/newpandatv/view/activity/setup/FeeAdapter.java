package co.com.newpandatv.view.activity.setup;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/20.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class FeeAdapter extends FragmentPagerAdapter {
    String[] frr ={"遇到的问题","常见问题"};
    ArrayList<Fragment> feeList;




    public FeeAdapter(FragmentManager fragmentManager, ArrayList<Fragment> feeList) {
        super(fragmentManager);
        this.feeList=feeList;
    }

    @Override
    public Fragment getItem(int position) {
        return feeList.get(position);
    }

    @Override
    public int getCount() {
        return feeList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return frr[position];
    }
}
