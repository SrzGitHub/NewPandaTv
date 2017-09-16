package co.com.newpandatv.presenter;

import co.com.newpandatv.model.biz.VideoActivityModel;
import co.com.newpandatv.model.biz.VideoActivityModelImpl;
import co.com.newpandatv.model.entity.VideoBeans;
import co.com.newpandatv.module.home.contract.VideoActivityModelContract;
import co.com.newpandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class VideoActivityModelPresenter implements VideoActivityModelContract.ActivityPresnter {

    private VideoActivityModel videoActivityModel;
    private VideoActivityModelContract.View viewModel;
    public VideoActivityModelPresenter(VideoActivityModelContract.View viewModel){
        this.viewModel =viewModel;
        this.viewModel.setPresenter(this);
        videoActivityModel=new VideoActivityModelImpl();

    }

    @Override
    public void start() {

        videoActivityModel.getVideoActivity(new MyNetWorkCallback<VideoBeans>() {
            @Override
            public void onSuccess(VideoBeans videoBeans) {
                viewModel.setResult(videoBeans);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                viewModel.showMessage(errorMsg);
            }
        });
    }
}
