package co.com.newpandatv.view.activity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.app.App;
import co.com.newpandatv.base.BaseActivity;
import co.com.newpandatv.config.UMengUtls;
import co.com.newpandatv.dao.DaoMaster;
import co.com.newpandatv.dao.DaoSession;
import co.com.newpandatv.dao.DaoUtil;
import co.com.newpandatv.dao.SQLBeans;
import co.com.newpandatv.dao.SQLBeansDao;
import co.com.newpandatv.model.entity.PDBCInfotwoBean;
import co.com.newpandatv.model.entity.PandaBroadcastInfoBean;
import co.com.newpandatv.module.pandabroadcast.vedio.PDBCInfoContract;
import co.com.newpandatv.net.OkHttpUtils;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

public class PDBCActivity extends BaseActivity {


    PDBCInfoContract.Presenter presenter;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.image_shoucang)
    CheckBox imageShoucang;
    @BindView(R.id.image_share)
    CheckBox imageShare;
    private Handler handler;
    public static String id;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_pdbc;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        w = DaoUtil.getIn(App.getContext()).getW();
        daoMaster = new DaoMaster(w);
        daoSession = daoMaster.newSession();
        sqlBeansDao = daoSession.getSQLBeansDao();
        sqlBeans = new SQLBeans();
        PandaBroadcastInfoBean.ListBean list = (PandaBroadcastInfoBean.ListBean) getIntent().getSerializableExtra("list");
//        String id = getIntent().getStringExtra("id");
        id = list.getId();

        Log.e("Tag", id);
        final String path = "http://api.cntv.cn/article/contentinfo?id=" + id + "&serviceId=panda";
        OkHttpUtils.getInstance().get(path, null, new MyNetWorkCallback<PDBCInfotwoBean>() {
            @Override
            public void onSuccess(PDBCInfotwoBean pdbcInfotwoBean) {
                final String title1 = pdbcInfotwoBean.getTitle();
                final String pubtime = pdbcInfotwoBean.getPubtime();
                final String logo = pdbcInfotwoBean.getLogo();
                title.setText(title1);
                time.setText(pubtime);
                final String content = pdbcInfotwoBean.getContent();
                text.setMovementMethod(ScrollingMovementMethod.getInstance());
                handler = new Handler() {


                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 0 * 101) {

                            text.setText((CharSequence) msg.obj);
                        }
                    }
                };

                Thread t = new Thread(new Runnable() {
                    Message msg = Message.obtain();

                    @Override
                    public void run() {
                        Html.ImageGetter imageGetter = new Html.ImageGetter() {
                            @Override
                            public Drawable getDrawable(String s) {
                                URL url;
                                Drawable drawable = null;
                                try {
                                    url = new URL(s);
                                    drawable = Drawable.createFromStream(url.openStream(), null);
                                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth()*3, drawable.getIntrinsicHeight()*3);
                                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth()*5, drawable.getIntrinsicHeight()*5);

                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                                return drawable;
                            }
                        };


                        CharSequence test = Html.fromHtml(content, imageGetter, null);
                        msg.what = 0 * 101;
                        msg.obj = test;
                        handler.sendMessage(msg);
                    }

                });
                t.start();
                sqlBeans.setDaoUrl(path);
                sqlBeans.setUrlData(pubtime);
                sqlBeans.setUrlTitle(title1);

                sqlBeansDao.insert(sqlBeans);


                        imageShoucang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(PDBCActivity.this, "亲，我替你收藏了哦", Toast.LENGTH_SHORT).show();


                            }
                        });
                        imageShare.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(PDBCActivity.this, "亲，稍等一会", Toast.LENGTH_SHORT).show();
                                UMImage imgs = new UMImage(App.context, logo);
                                new ShareAction(PDBCActivity.this)
                                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                                        .withText(path)
                                        .withMedia(imgs)
                                        .setCallback(UMengUtls.shareListener)//回调监听器
                                        .share();
                            }
                        });

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }



}
