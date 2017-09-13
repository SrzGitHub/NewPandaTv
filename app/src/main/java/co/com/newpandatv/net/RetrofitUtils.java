package co.com.newpandatv.net;


import java.util.Map;

import co.com.newpandatv.net.callback.MyNetWorkCallback;


public class RetrofitUtils implements IHttp {
    @Override
    public <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback) {

    }

    @Override
    public <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback) {

    }

    @Override
    public void upload() {

    }

    @Override
    public void download() {

    }

    @Override
    public void loadImage() {

    }
}
