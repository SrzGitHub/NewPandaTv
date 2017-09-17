package co.com.newpandatv.view.activity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.newpandatv.R;
import co.com.newpandatv.adapter.daoadapter.SQLAdapter;
import co.com.newpandatv.dao.DaoMaster;
import co.com.newpandatv.dao.DaoSession;
import co.com.newpandatv.dao.DaoUtil;
import co.com.newpandatv.dao.SQLBeans;
import co.com.newpandatv.dao.SQLBeansDao;
import co.com.newpandatv.view.listview.MyListView;

public class SQLActivity extends AppCompatActivity {

    @BindView(R.id.sqlListView)
    MyListView sqlListView;
    SQLAdapter sqlAdapter;
    @BindView(R.id.sql_IMG)
    ImageView sqlIMG;
    private SQLiteDatabase r;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLBeansDao sqlBeansDao;
     List<SQLBeans> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        ButterKnife.bind(this);
        r = DaoUtil.getIn(this).getR();
        daoMaster = new DaoMaster(r);
        daoSession = daoMaster.newSession();
        sqlBeansDao = daoSession.getSQLBeansDao();
        list = sqlBeansDao.queryBuilder().list();


        sqlAdapter = new SQLAdapter(this, R.layout.dao_list_item, list);
        sqlListView.setAdapter(sqlAdapter);


            intiDate();

    }

    private void intiDate() {

        sqlListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SQLActivity.this);
                //设置标题
                builder.setMessage("是否删除数据库?"); //设置内容
                builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //关闭dialog

                        sqlBeansDao.delete(list.get(i));
                        List<SQLBeans> list1 = sqlBeansDao.queryBuilder().build().list();
                        list.clear();
                        list.addAll(list1);
                        sqlAdapter.notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(SQLActivity.this, "取消" + which, Toast.LENGTH_SHORT).show();
                    }
                });
                //参数都设置完成了，创建并显示出来
                builder.create().show();



                return false;
            }
        });
    }

    @OnClick(R.id.sql_IMG)
    public void onViewClicked() {
        finish();
    }
}
