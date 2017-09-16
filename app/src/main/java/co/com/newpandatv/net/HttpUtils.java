package co.com.newpandatv.net;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtils {
    //TODO 创建OKHttp对象
    private static OkHttpClient client = null;

    //TODO 构造方法
    public HttpUtils() {
    }

    public static OkHttpClient getInstance() {
        if (client == null) {
            synchronized (HttpUtils.class) {
                if (client == null) {
                    client = new OkHttpClient();
                }
            }
        }
        //TODO 返回client
        return client;
    }

    //TODO Get请求
    public static void doGet(String url, Callback callback) {
        CacheControl cc = new CacheControl.Builder()
                //不使用缓存，但是会保存缓存数据
                //.noCache()
                //不使用缓存，同时也不保存缓存数据
                // .noStore()
                //只使用缓存，（如果我们要加载的数据本身就是本地数据时，可以使用这个，不过目前尚未发现使用场景）
                //.onlyIfCached()
                //手机可以接收响应时间小于当前时间加上10s的响应
                .minFresh(10, TimeUnit.SECONDS)
                //手机可以接收有效期不大于10s的响应
                .maxAge(10, TimeUnit.SECONDS)
                //手机可以接收超出5s的响应
                .maxStale(5, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .cacheControl(cc)
                .url(url)
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);
    }
    //// TODO: 2017/8/9  Post 发送键值对数据

    public static void doPost(String url, Map<String, String> mapParams, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : mapParams.keySet()) {
            builder.add(key, mapParams.get(key));

        }

        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);

    }


    // TODO: 2017/8/9 Post请求发送JSON数据
    public static void doPost(String url, String jsonParams, Callback callback) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);
    }
}