package co.com.newpandatv.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.PandaLiveAdapter;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.presenter.DonModelPresnter;
import co.com.newpandatv.presenter.LiveFrgmentModelPresenter;
import co.com.newpandatv.presenter.OriginalNewsModelPresenter;
import co.com.newpandatv.presenter.PandaArchivesModelPresenter;
import co.com.newpandatv.presenter.PandaThoseThingsModelPresenter;
import co.com.newpandatv.presenter.SpecialModelPresenter;
import co.com.newpandatv.presenter.SuperMOEshowPresenter;
import co.com.newpandatv.presenter.TopModelPresnter;
import co.com.newpandatv.presenter.WonderfulMomentPresenter;
import co.com.newpandatv.view.fragment.pandalive_fragment.DontLetTheMale;
import co.com.newpandatv.view.fragment.pandalive_fragment.LiveFrgment;
import co.com.newpandatv.view.fragment.pandalive_fragment.OriginalNews;
import co.com.newpandatv.view.fragment.pandalive_fragment.PandaArchives;
import co.com.newpandatv.view.fragment.pandalive_fragment.PandaThoseThings;
import co.com.newpandatv.view.fragment.pandalive_fragment.Panda_Top_List;
import co.com.newpandatv.view.fragment.pandalive_fragment.Special;
import co.com.newpandatv.view.fragment.pandalive_fragment.SuperMOEshow;
import co.com.newpandatv.view.fragment.pandalive_fragment.WonderfulMoment;

import static org.xutils.common.util.DensityUtil.dip2px;


/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaLive extends BaseFragment {

    PandaLiveAdapter pandaLiveAdapter;
    ArrayList<Fragment> list = new ArrayList<>();
    @BindView(R.id.pandaLiveTly)
    TabLayout pandaLiveTly;
    @BindView(R.id.pandaLiveVip)
    ViewPager pandaLiveVip;
    Unbinder unbinder;
    LiveFrgment liveFrgment;
    WonderfulMoment wonderfulMoment;
    DontLetTheMale dontLetTheMale;
    SuperMOEshow superMOEshow;
    PandaArchives pandaArchives;
    Panda_Top_List panda_top_list;
    PandaThoseThings pandaThoseThings;
    Special special;
    OriginalNews originalNews;



    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment;
    }

    @Override
    protected void init(View view) {


    }

    @Override
    protected void loadData() {


        wonderfulMoment = new WonderfulMoment();
        liveFrgment = new LiveFrgment();
        dontLetTheMale = new DontLetTheMale();
        superMOEshow = new SuperMOEshow();
        pandaArchives = new PandaArchives();
        panda_top_list = new Panda_Top_List();
        pandaThoseThings = new PandaThoseThings();
        special = new Special();
        originalNews = new OriginalNews();

        new LiveFrgmentModelPresenter(liveFrgment);
        new WonderfulMomentPresenter(wonderfulMoment);
        new DonModelPresnter(dontLetTheMale);
        new SuperMOEshowPresenter(superMOEshow);
        new PandaArchivesModelPresenter(pandaArchives);
        new TopModelPresnter(panda_top_list);
        new PandaThoseThingsModelPresenter(pandaThoseThings);
        new SpecialModelPresenter(special);
        new OriginalNewsModelPresenter(originalNews);


        list.add(liveFrgment);
        list.add(wonderfulMoment);
        list.add(dontLetTheMale);
        list.add(superMOEshow);
        list.add(pandaArchives);
        list.add(panda_top_list);
        list.add(pandaThoseThings);
        list.add(special);
        list.add(originalNews);

        pandaLiveAdapter = new PandaLiveAdapter(getFragmentManager(),list);
        pandaLiveVip.setAdapter(pandaLiveAdapter);
        pandaLiveTly.setTabMode(TabLayout.MODE_SCROLLABLE);

        pandaLiveTly.setupWithViewPager(pandaLiveVip);

       /* LinearLayout linearLayout = (LinearLayout) pandaLiveTly.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));
        linearLayout.setDividerPadding(dip2px(10)); //设置分割线间隔*/

    }
   /* //像素单位转换
    public int dip2px(int dip) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5);
    }*/




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
