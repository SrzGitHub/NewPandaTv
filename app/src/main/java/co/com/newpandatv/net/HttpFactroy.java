package co.com.newpandatv.net;


public class HttpFactroy {
    public static IHttp create(){
        return OkHttpUtils.getInstance();
    }
}
