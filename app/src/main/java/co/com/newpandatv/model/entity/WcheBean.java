package co.com.newpandatv.model.entity;

/**
 * Created by Administrator on 2017/9/15.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class WcheBean {
    String name;
    String title;
    String tim;
    String log;

    public WcheBean() {

    }
    public WcheBean(String name, String title, String tim, String log) {
        this.name = name;
        this.title = title;
        this.tim = tim;
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
