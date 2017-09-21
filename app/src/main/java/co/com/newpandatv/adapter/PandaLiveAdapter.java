package co.com.newpandatv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaLiveAdapter extends FragmentPagerAdapter {

    String[] str = {"直播","精彩一刻","当熊不让","超萌滚滚","熊猫档案","熊猫TOP榜","熊猫那些事","特别节目","原创新闻"};

    ArrayList<Fragment> list ;
    public PandaLiveAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
