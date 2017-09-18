package co.com.newpandatv.shaer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.shareboard.SnsPlatform;

import java.util.ArrayList;
import java.util.Map;

import co.com.newpandatv.R;


public class AutoAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<SnsPlatform> platforms;
    private Activity auto;
    public AutoAdapter(Context context, ArrayList<SnsPlatform> platforms) {
        this.mContext = context;
        this.platforms = platforms;
        this.auto = (AutoActivity) context;
    }

    @Override
    public int getCount() {
        return platforms.size();
    }

    @Override
    public Object getItem(int position) {
        return platforms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.app_authadapter, null);
        }
        final boolean isauth = UMShareAPI.get(mContext).isAuthorize(auto, platforms.get(position).mPlatform);
        ImageView img =  convertView.findViewById(R.id.adapter_image);
        img.setImageResource(ResContainer.getResourceId(mContext, "drawable", platforms.get(position).mIcon));
        TextView tv =  convertView.findViewById(R.id.name);
        tv.setText(ResContainer.getResourceId(mContext, "string", platforms.get(position).mShowWord));
        TextView authBtn =  convertView.findViewById(R.id.auth_button);
        if (isauth) {
            authBtn.setText("删除授权");
        } else {
            authBtn.setText("授权");
        }
        authBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isauth) {
                    UMShareAPI.get(mContext).deleteOauth(auto, platforms.get(position).mPlatform, authListener);
                } else {
                    UMShareAPI.get(mContext).doOauthVerify(auto, platforms.get(position).mPlatform, authListener);
                }
            }
        });
        if (position == platforms.size() - 1) {
            convertView.findViewById(R.id.divider).setVisibility(View.GONE);
        } else {
            convertView.findViewById(R.id.divider).setVisibility(View.VISIBLE);
        }
//
        return convertView;
    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(mContext, "成功了", Toast.LENGTH_LONG).show();
            notifyDataSetChanged();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(mContext, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(mContext, "取消了", Toast.LENGTH_LONG).show();
        }
    };
}
