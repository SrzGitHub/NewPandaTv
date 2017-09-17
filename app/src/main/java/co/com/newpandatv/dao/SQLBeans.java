package co.com.newpandatv.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/9/17.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

@Entity
public class SQLBeans {
    @Id(autoincrement = true)
    Long id;

    @Property
    String urlTitle;
    @Property
    String urlImg;
    @Property
    String urlData;
    @Property
    String urlLen;
    @Property
    String daoUrl;
    @Generated(hash = 1451178917)
    public SQLBeans(Long id, String urlTitle, String urlImg, String urlData,
            String urlLen, String daoUrl) {
        this.id = id;
        this.urlTitle = urlTitle;
        this.urlImg = urlImg;
        this.urlData = urlData;
        this.urlLen = urlLen;
        this.daoUrl = daoUrl;
    }
    @Generated(hash = 1842524985)
    public SQLBeans() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrlTitle() {
        return this.urlTitle;
    }
    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle;
    }
    public String getUrlImg() {
        return this.urlImg;
    }
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
    public String getUrlData() {
        return this.urlData;
    }
    public void setUrlData(String urlData) {
        this.urlData = urlData;
    }
    public String getUrlLen() {
        return this.urlLen;
    }
    public void setUrlLen(String urlLen) {
        this.urlLen = urlLen;
    }
    public String getDaoUrl() {
        return this.daoUrl;
    }
    public void setDaoUrl(String daoUrl) {
        this.daoUrl = daoUrl;
    }

}
