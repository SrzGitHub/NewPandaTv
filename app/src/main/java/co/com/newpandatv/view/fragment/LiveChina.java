package co.com.newpandatv.view.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.adapter.GridView_Adapter;
import co.com.newpandatv.adapter.More_GridView_Adapter;
import co.com.newpandatv.adapter.Myadapter;
import co.com.newpandatv.base.BaseFragment;
import co.com.newpandatv.config.UrlsUtils;
import co.com.newpandatv.model.entity.LiveChinabean;
import co.com.newpandatv.model.entity.ZhiBoChina;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import co.com.newpandatv.view.fragment.pandalive_fragment.GoodFragment;


import static co.com.newpandatv.config.UrlsUtils.LIVECHINA;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class LiveChina extends BaseFragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imageView;
    private List<Fragment>fragmentList;
    private List<ZhiBoChina.TablistBean> list1;
    private ArrayList<LiveChinabean.AlllistBean> alllistBeen=new ArrayList<>();
    private ArrayList<LiveChinabean.TablistBean> tablistBeen=new ArrayList<>();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 300:
                    myadapter.notifyDataSetChanged();
                    break;

                case 400:
                    gridView_adapter.notifyDataSetChanged();
                    more_gridView_adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private Myadapter myadapter;
    private TextView enit_text;
    private GridView gridView;
    private GridView more_gridView;
    private View inflate;
    private GridView_Adapter gridView_adapter;
    private More_GridView_Adapter more_gridView_adapter;
    private LinearLayout loginChinaLiveRelation;

    @Override
    protected int getLayoutId() {
        return R.layout.livechina_fragment;
    }

    @Override
    protected void init(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.mTablayout);
        viewPager = (ViewPager) view.findViewById(R.id.VP_viewpager);
        imageView = (ImageView) view.findViewById(R.id.jiadongxi);


    }

    @Override
    protected void loadData() {
        fragmentList=new ArrayList<>();
        list1=new ArrayList<>();

        OkHttpUtils.getInstance().get(LIVECHINA, null, new MyNetWorkCallback<ZhiBoChina>() {
            @Override
            public void onSuccess(ZhiBoChina zhiBoChina) {
                list1.addAll(zhiBoChina.getTablist());

                for (int i = 0; i <list1.size(); i++) {
                    fragmentList.add(new GoodFragment());
                }
                myadapter = new Myadapter(getActivity().getSupportFragmentManager(),list1,fragmentList);
                viewPager.setAdapter(myadapter);
                tabLayout.setupWithViewPager(viewPager);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
        OkHttpUtils.getInstance().get(UrlsUtils.LIVECHINA, null, new MyNetWorkCallback<LiveChinabean>() {
            @Override
            public void onSuccess(LiveChinabean liveChinabean) {
                alllistBeen.addAll(liveChinabean.getAlllist());

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
        OkHttpUtils.getInstance().get(UrlsUtils.LIVECHINA, null, new MyNetWorkCallback<LiveChinabean>() {
            @Override
            public void onSuccess(LiveChinabean liveChinabean) {
                tablistBeen.addAll(liveChinabean.getTablist());

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                inflate = LayoutInflater.from(getContext()).inflate(R.layout.popupwindwo, null);
                enit_text = (TextView) inflate.findViewById(R.id.edtix_button);

                gridView = (GridView) inflate.findViewById(R.id.Switch_the_section_gridview);
                more_gridView = (GridView) inflate.findViewById(R.id.more_Switch_the_section_gridview);
                final PopupWindow popupWindow=new PopupWindow(inflate, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);

                popupWindow.setTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
                popupWindow.update();

                ImageView imageView1 = (ImageView) inflate.findViewById(R.id.live_china_delect);
                imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

                gridView.setEnabled(false);
                enit_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (int i = 0; i < tablistBeen.size(); i++) {
                            tablistBeen.get(i).setFlg(true);
                        }
                        handler.sendEmptyMessage(400);

                        if (enit_text.getText().equals("编辑")) {
                            enit_text.setText("完成");
                            gridView.setEnabled(true);
                            if (enit_text.getText().equals("完成")){
                                more_gridView.setEnabled(true);
                            }else if(enit_text.getText().equals("编辑")){
                                more_gridView.setEnabled(false);
                            }
//                    切换内容的点击事件
                            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    if (tablistBeen.size() > 4) {
                                        LiveChinabean.AlllistBean down_array = new LiveChinabean.AlllistBean();

                                        down_array.setTitle(tablistBeen.get(position).getTitle());
                                        down_array.setOrder(tablistBeen.get(position).getOrder());
                                        down_array.setType(tablistBeen.get(position).getType());
                                        down_array.setUrl(tablistBeen.get(position).getUrl());

                                        alllistBeen.add(down_array);
                                        tablistBeen.remove(position);

                                        handler.sendEmptyMessage(400);

                                    }

                                    gridView_adapter.notifyDataSetChanged();

                                }
                            });

                            more_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View Qview, int DOposition, long id) {

                                    LiveChinabean.TablistBean UP_array = new LiveChinabean.TablistBean();

                                    UP_array.setTitle(alllistBeen.get(DOposition).getTitle());
                                    UP_array.setOrder(alllistBeen.get(DOposition).getOrder());
                                    UP_array.setFlg(true);
                                    UP_array.setType(alllistBeen.get(DOposition).getType());
                                    UP_array.setUrl(alllistBeen.get(DOposition).getUrl());

                                    tablistBeen.add(UP_array);

                                    alllistBeen.remove(DOposition);

                                    handler.sendEmptyMessage(400);
                                }
                            });


//不可编辑
                        } else {

                            enit_text.setText("编辑");

                            gridView.setEnabled(false);
                            more_gridView.setEnabled(false);
                            for (int i = 0; i < tablistBeen.size(); i++) {
                                tablistBeen.get(i).setFlg(false);
                            }
//                        重新 NEW  Fragment
//                            fargmet_array.clear();
//                            for (int i = 0; i < tablistBeen.size(); i++) {
//                                Path_Fragment path_fragment = new Path_Fragment(tablistBeen.get(i).getUrl());
//                                fargmet_array.add(path_fragment);
//                            }
//                            tablay_adapter.notifyDataSetChanged();
                            handler.sendEmptyMessage(400);
                        }
                    }
                });

                handler.sendEmptyMessage(400);
                Log.e("TAG","+++++++++++++++++++++++"+tablistBeen.size());
                gridView_adapter = new GridView_Adapter(getActivity(),tablistBeen);
                gridView.setAdapter(gridView_adapter);
                Log.e("TAG","+++++++++++++++++++++++"+alllistBeen.size());
                more_gridView_adapter = new More_GridView_Adapter(getActivity(),alllistBeen );
                more_gridView.setAdapter(more_gridView_adapter);

            }

        });
    }
}
