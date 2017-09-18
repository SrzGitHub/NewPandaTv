package co.com.newpandatv.adapter.home_adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by dell on 2017/9/15.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceTop;
    private int space;

    public SpaceItemDecoration(int spaceTop,int space) {
        this.spaceTop = spaceTop;
        this.space=space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(parent.getChildPosition(view)!=0){
            outRect.top=spaceTop;
            outRect.left=space;
            outRect.right=space;
        }
    }
}
