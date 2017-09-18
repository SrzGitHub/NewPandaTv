package co.com.newpandatv.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.com.newpandatv.R;
import co.com.newpandatv.model.entity.LiveChinabean;

/**
 * Created by Administrator on 2017/7/17.
 */
//////////
public class More_GridView_Adapter extends BaseAdapter {
    FragmentActivity activity;
    ArrayList<LiveChinabean.AlllistBean> alllistBeen;
    public More_GridView_Adapter(FragmentActivity activity, ArrayList<LiveChinabean.AlllistBean> alllistBeen) {
        this.activity=activity;
        this.alllistBeen = alllistBeen;
    }

    @Override
    public int getCount() {
        return alllistBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return alllistBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        My_view my_view = null;
        if(convertView==null){
            convertView = LayoutInflater.from(activity).inflate(R.layout.gridview_item,null);

            my_view= new My_view();

            my_view.content = (TextView) convertView.findViewById(R.id.gridview_item_content);


            convertView.setTag(my_view);

        }else{
            my_view= (My_view) convertView.getTag();
        }

        my_view.content.setText(alllistBeen.get(position).getTitle());


        return convertView;
    }
    class My_view{
        private TextView content;

    }

}
