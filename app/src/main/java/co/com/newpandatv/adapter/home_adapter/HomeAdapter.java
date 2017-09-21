package co.com.newpandatv.adapter.home_adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import co.com.newpandatv.R;
import co.com.newpandatv.model.entity.home_video_bean.BillowingvideoLiuBean;
import co.com.newpandatv.model.entity.home_video_bean.PandaLiveLiuBean;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;
import co.com.newpandatv.view.activity.homeactivity.AreaHomeActivity;
import co.com.newpandatv.view.activity.homeactivity.BigImgHomeActivity;
import co.com.newpandatv.view.activity.homeactivity.HomeWebActivity;
import co.com.newpandatv.view.activity.homeactivity.ListHomeActivity;
import co.com.newpandatv.view.activity.homeactivity.PandaliveActivity;
import co.com.newpandatv.view.activity.homeactivity.VideoLiuActivity;

/**
 * Created by dell on 2017/9/13.
 */

public class HomeAdapter extends RecyclerView.Adapter {
    Context context;
    List<PandaLiveLiuBean.DataBean> list;

    public HomeAdapter(Context context, List<PandaLiveLiuBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else if (position==2){
            return 2;
        }else if (position==3){
            return 3;
        }else if(position==4){
            return 4;
        }else if(position==5){
            return 5;
        }else {
            return position;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        if(viewType==0){
            View inflate = LinearLayout.inflate(context, R.layout.item_home_one, null);
            holder=new ViewHolder1(inflate);
        }else if (viewType==1){
            View inflate = LinearLayout.inflate(context, R.layout.item_home_two, null);
            holder=new ViewHolder2(inflate);
        }else if (viewType==2){
            View inflate = LinearLayout.inflate(context, R.layout.item_home_three, null);
            holder=new ViewHolder3(inflate);
        }else if(viewType==3){
            View inflate = LinearLayout.inflate(context, R.layout.item_home_four, null);
            holder=new ViewHolder4(inflate);
        }else if(viewType==4){
            View inflate = LinearLayout.inflate(context, R.layout.item_home_five, null);
            holder=new ViewHolder5(inflate);
        }else if(viewType==5){
            View inflate = LinearLayout.inflate(context, R.layout.item_home_six, null);
            holder=new ViewHolder6(inflate);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        PandaLiveLiuBean.DataBean dataBean = list.get(position);
        if(itemViewType==0){
            ViewHolder1 holder1= (ViewHolder1) holder;
            //设置图片加载器
            holder1.banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            final List<PandaLiveLiuBean.DataBean.BigImgBean> bigImg = dataBean.getBigImg();
            PandaLiveLiuBean.DataBean.BigImgBean bigImgBean = bigImg.get(0);
            PandaLiveLiuBean.DataBean.BigImgBean bigImgBean2 = bigImg.get(1);
            PandaLiveLiuBean.DataBean.BigImgBean bigImgBean3 = bigImg.get(2);
            PandaLiveLiuBean.DataBean.BigImgBean bigImgBean4 = bigImg.get(3);
            String image = bigImgBean.getImage();
            String image2 = bigImgBean2.getImage();
            String image3 = bigImgBean3.getImage();
            String image4 = bigImgBean4.getImage();
            List<String > listImage=new ArrayList<>();
            listImage.add(image);
            listImage.add(image2);
            listImage.add(image3);
            listImage.add(image4);
            holder1.banner.setImages(listImage);
            List<String > listTitle=new ArrayList<>();
            listTitle.add(bigImgBean.getTitle());
            listTitle.add(bigImgBean2.getTitle());
            listTitle.add(bigImgBean3.getTitle());
            listTitle.add(bigImgBean4.getTitle());
            holder1.banner.setBannerTitles(listTitle);

            holder1.banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    if(position==0){
                        Intent intent=new Intent(context, HomeWebActivity.class);
                        intent.putExtra("web",bigImg.get(position).getUrl());
                        intent.putExtra("webImage",bigImg.get(position).getImage());
                        context.startActivity(intent);
                    }else {
                        Intent intent=new Intent(context, BigImgHomeActivity.class);
                        intent.putExtra("bigimg",bigImg.get(position).getPid());
                        intent.putExtra("bigimg_image",bigImg.get(position).getImage());
                        context.startActivity(intent);
                    }
                }
            });

            //banner设置方法全部调用完毕时最后调用
            holder1.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            holder1.banner.isAutoPlay(true);
            //设置banner动画效果
            holder1.banner.setBannerAnimation(Transformer.DepthPage);

            holder1.banner.start();
        }else if (itemViewType==1){
            ViewHolder2 holder2= (ViewHolder2) holder;
            final PandaLiveLiuBean.DataBean.PandaeyeBean pandaeye = dataBean.getPandaeye();
            holder2.text_two.setText(pandaeye.getTitle());
            Glide.with(context).load(pandaeye.getPandaeyelogo()).into(holder2.image2);
            holder2.btn1.setText(pandaeye.getItems().get(0).getBrief());
            holder2.btn2.setText(pandaeye.getItems().get(1).getBrief());
            holder2.text1.setText(pandaeye.getItems().get(0).getTitle());
            holder2.text2.setText(pandaeye.getItems().get(1).getTitle());
            holder2.text1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, VideoLiuActivity.class);
                    intent.putExtra("pandaeye",pandaeye.getItems().get(0).getPid());
                    intent.putExtra("pandaeye_image",pandaeye.getItems().get(0).getUrl());
                    context.startActivity(intent);
                }
            });
            holder2.text2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, VideoLiuActivity.class);
                    intent.putExtra("pandaeye",pandaeye.getItems().get(1).getPid());
                    context.startActivity(intent);
                }
            });

        }else if (itemViewType==2){
            ViewHolder3 holder3= (ViewHolder3) holder;
            final PandaLiveLiuBean.DataBean.PandaliveBean pandalive = dataBean.getPandalive();
            holder3.text_three.setText(pandalive.getTitle());
            List<PandaLiveLiuBean.DataBean.PandaliveBean.ListBeanX> lista = pandalive.getList();
            MyGlideAdapter myGlideAdapter = new MyGlideAdapter(context, lista);
            holder3.gridView.setAdapter(myGlideAdapter);

            holder3.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(context, PandaliveActivity.class);
                    intent.putExtra("chinalivename",pandalive.getList().get(i).getTitle());
                    intent.putExtra("pandalive",pandalive.getList().get(i).getId());
                    intent.putExtra("pandalive_image",pandalive.getList().get(i).getImage());
                    context.startActivity(intent);
                }
            });
            /**
             * http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hdxiongmao06&amp;client=androidapp
             */

        }else if(itemViewType==3){
            ViewHolder4 holder4= (ViewHolder4) holder;
            PandaLiveLiuBean.DataBean.AreaBean area = dataBean.getArea();
            holder4.text_four.setText(area.getTitle());
            final List<PandaLiveLiuBean.DataBean.AreaBean.ListscrollBean> listscroll = area.getListscroll();
            List<PandaLiveLiuBean.DataBean.AreaBean.ListscrollBean> listscrol2=new ArrayList<>();
            listscrol2.add(listscroll.get(0));
            listscrol2.add(listscroll.get(1));
            listscrol2.add(listscroll.get(2));
            listscrol2.add(listscroll.get(3));
            holder4.gridView_four.setAdapter(new MyGridAdapter2(context,listscrol2));
            holder4.gridView_four.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int positionx, long id) {
                    Intent intent=new Intent(context, AreaHomeActivity.class);
                    intent.putExtra("area",listscroll.get(positionx).getPid());
                    intent.putExtra("area_image",listscroll.get(positionx).getImage());
                    context.startActivity(intent);
                }
            });

        }else if(itemViewType==4){
            final List<BillowingvideoLiuBean.ListBean> list_billowingvideoBean=new ArrayList();
            ViewHolder5 holder5= (ViewHolder5) holder;
            List<PandaLiveLiuBean.DataBean.ListBeanXXX> list = dataBean.getList();
            PandaLiveLiuBean.DataBean.ListBeanXXX listBeanXXX = list.get(0);
            String listUrl = listBeanXXX.getListUrl();
            String title = listBeanXXX.getTitle();
            holder5.text_five.setText(title);

            OkHttpUtils.getInstance().get(listUrl, null, new MyNetWorkCallback<BillowingvideoLiuBean>() {
                @Override
                public void onSuccess(BillowingvideoLiuBean billowingvideoLiuBean) {
                    list_billowingvideoBean.addAll(billowingvideoLiuBean.getList());
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }
            });
            holder5.listView_five.setAdapter(new MyListAdapter(context,list_billowingvideoBean));
            holder5.listView_five.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int positionx, long id) {
                    Intent intent=new Intent(context, ListHomeActivity.class);
                    intent.putExtra("list",list_billowingvideoBean.get(positionx).getPid());
                    intent.putExtra("list_image",list_billowingvideoBean.get(positionx).getImage());
                    context.startActivity(intent);
                }
            });

        }else if(itemViewType==5){
            ViewHolder6 holder6= (ViewHolder6) holder;
            final PandaLiveLiuBean.DataBean.ChinaliveBean chinalive = dataBean.getChinalive();
            holder6.text_six.setText(chinalive.getTitle());
            List<PandaLiveLiuBean.DataBean.ChinaliveBean.ListBean> list6 = chinalive.getList();
            holder6.gridView_six.setAdapter(new MyGridAdapter3(context,list6));
            holder6.gridView_six.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(context, PandaliveActivity.class);
                    intent.putExtra("chinalivename",chinalive.getList().get(i).getTitle());
                    intent.putExtra("pandalive",chinalive.getList().get(i).getId());
                    intent.putExtra("pandalive_image",chinalive.getList().get(i).getImage());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        Banner banner;
        public ViewHolder1(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView text_two;
        ImageView image2;
        Button btn1;
        Button btn2;
        TextView text1;
        TextView text2;
        public ViewHolder2(View itemView) {
            super(itemView);
            text_two = (TextView) itemView.findViewById(R.id.home_two_text);
            image2 = (ImageView) itemView.findViewById(R.id.home_two_image);
            btn1 = (Button) itemView.findViewById(R.id.home_two_btn1);
            btn2 = (Button) itemView.findViewById(R.id.home_two_btn2);
            text1 = (TextView) itemView.findViewById(R.id.home_two_text1);
            text2 = (TextView) itemView.findViewById(R.id.home_two_text2);
        }
    }
    public class ViewHolder3 extends RecyclerView.ViewHolder {
        TextView text_three;
        GridView gridView;
        public ViewHolder3(View itemView) {
            super(itemView);
            text_three = (TextView) itemView.findViewById(R.id.home_three_text);
            gridView= (GridView) itemView.findViewById(R.id.home_three_grid);
        }
    }
    public class ViewHolder4 extends RecyclerView.ViewHolder {
        TextView text_four;
        GridView gridView_four;
        public ViewHolder4(View itemView) {
            super(itemView);
            text_four = (TextView) itemView.findViewById(R.id.home_four_tv);
            gridView_four= (GridView) itemView.findViewById(R.id.home_four_grid);
        }
    }
    public class ViewHolder5 extends RecyclerView.ViewHolder {
        TextView text_five;
        ListView listView_five;
        public ViewHolder5(View itemView) {
            super(itemView);
            text_five = (TextView) itemView.findViewById(R.id.home_five_text);
            listView_five= (ListView) itemView.findViewById(R.id.list_five);
        }
    }
    public class ViewHolder6 extends RecyclerView.ViewHolder {
        TextView text_six;
        GridView gridView_six;
        public ViewHolder6(View itemView) {
            super(itemView);
            text_six = (TextView) itemView.findViewById(R.id.home_six_text);
            gridView_six= (GridView) itemView.findViewById(R.id.home_six_grid);
        }
    }

}
