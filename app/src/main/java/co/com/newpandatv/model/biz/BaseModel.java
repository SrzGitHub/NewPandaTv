package co.com.newpandatv.model.biz;


import co.com.newpandatv.net.HttpFactroy;
import co.com.newpandatv.net.IHttp;

public interface BaseModel {
    public static IHttp iHttp = HttpFactroy.create();
}
