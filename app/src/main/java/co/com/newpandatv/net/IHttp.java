package co.com.newpandatv.net;



import java.util.Map;

import co.com.newpandatv.net.callback.MyNetWorkCallback;


public interface IHttp {

    <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    void upload();
    void download();
    void loadImage();

}
