package co.com.newpandatv.view.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.newpandatv.R;
import co.com.newpandatv.base.BaseActivity;
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
        PandaBroadcastInfoBean.ListBean list = (PandaBroadcastInfoBean.ListBean) getIntent().getSerializableExtra("list");
//        String id = getIntent().getStringExtra("id");
        id = list.getId();

        Log.e("Tag", id);
        OkHttpUtils.getInstance().get("http://api.cntv.cn/article/contentinfo?id=" + id + "&serviceId=panda", null, new MyNetWorkCallback<PDBCInfotwoBean>() {
            @Override
            public void onSuccess(PDBCInfotwoBean pdbcInfotwoBean) {
                String title1 = pdbcInfotwoBean.getTitle();
                String pubtime = pdbcInfotwoBean.getPubtime();
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
                                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

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

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageShoucang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(PDBCActivity.this, "亲，我替你收藏了哦", Toast.LENGTH_SHORT).show();
                            }
                        });
                        imageShare.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(PDBCActivity.this, "亲，没有分享哎", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
//
//
//    @Override
//    public void setPresenter(PDBCInfoContract.Presenter presenter) {
//        this.presenter = presenter;
//    }
//
//    @Override
//    public void setResult(PDBCInfotwoBean pdbcinfoBean) {
//        Log.e("urls", Urls.PANDABROADCASTINFO);
//        Toast.makeText(App.context,  Urls.PANDABROADCASTINFO, Toast.LENGTH_SHORT).show();
//        String title1 = pdbcinfoBean.getTitle();
//        String pubtime = pdbcinfoBean.getPubtime();
//        title.setText(title1);
//        time.setText(pubtime);
//        final String content = pdbcinfoBean.getContent();
//        text.setMovementMethod(ScrollingMovementMethod.getInstance());
//        handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                if (msg.what == 0 * 101) {
//                    text.setText((CharSequence) msg.obj);
//                }
//            }
//        };
//
//        Thread t = new Thread(new Runnable() {
//            Message msg = Message.obtain();
//
//            @Override
//            public void run() {
//                Html.ImageGetter imageGetter = new Html.ImageGetter() {
//                    @Override
//                    public Drawable getDrawable(String s) {
//                        URL url;
//                        Drawable drawable = null;
//                        try {
//                            url = new URL(s);
//                            drawable = Drawable.createFromStream(url.openStream(), null);
//                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//
//                        } catch (MalformedURLException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//
//                        return drawable;
//                    }
//                };
//
//
//                CharSequence test = Html.fromHtml(content, imageGetter, null);
//                msg.what = 0 * 101;
//                msg.obj = test;
//                handler.sendMessage(msg);
//            }
//
//        });
//        t.start();
//
//
//        imageShoucang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(PDBCActivity.this, "亲，我替你收藏了哦", Toast.LENGTH_SHORT).show();
//            }
//        });
//        imageShare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(PDBCActivity.this, "亲，没有分享哎", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }
//
//    @Override
//    public void showMessage(String msg) {
//
//    }


}
