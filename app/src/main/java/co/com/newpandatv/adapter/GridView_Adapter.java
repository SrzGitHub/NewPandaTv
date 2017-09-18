package co.com.newpandatv.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.com.newpandatv.R;
import co.com.newpandatv.model.entity.LiveChinabean;


/**
 * Created by Administrator on 2017/7/17.
 */
///////////
public class GridView_Adapter extends BaseAdapter {

    FragmentActivity activity;
    ArrayList<LiveChinabean.TablistBean> tablistBeen;

    public GridView_Adapter(FragmentActivity activity, ArrayList<LiveChinabean.TablistBean> tablistBeen) {
        this.activity = activity;
        this.tablistBeen = tablistBeen;


    }

    @Override
    public int getCount() {
        return tablistBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return tablistBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        My_view my_view = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.gridview_item, null);

            my_view = new My_view();

            my_view.content = (TextView) convertView.findViewById(R.id.gridview_item_content);
            my_view.delete = (ImageView) convertView.findViewById(R.id.gridview_item_delete_gary);

            convertView.setTag(my_view);

        } else {
            my_view = (My_view) convertView.getTag();
        }

        my_view.content.setText(tablistBeen.get(position).getTitle());

        if (tablistBeen.get(position).getFlg() == true) {

            my_view.delete.setVisibility(View.VISIBLE);

        } else {

            my_view.delete.setVisibility(View.GONE);

        }


        return convertView;
    }
    public void swap(int i, int j) {
        if (j < i) {
            LiveChinabean.TablistBean tablistBean = tablistBeen.get(i);

            tablistBeen.add(j,tablistBean);
            tablistBeen.remove(i + 1);
        } else if (i < j) {
            LiveChinabean.TablistBean tablistBean = tablistBeen.get(i);
            tablistBeen.add(j + 1, tablistBean);
            tablistBeen.remove(i);
        }
    }


    class My_view {
        private TextView content;
        private ImageView delete;


    }

}
