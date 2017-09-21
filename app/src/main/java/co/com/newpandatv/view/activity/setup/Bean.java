package co.com.newpandatv.view.activity.setup;

/**
 * Created by Administrator on 2017/9/20.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class Bean {
    int name;
    int agr;

    public Bean(int name, int agr) {
        this.name = name;
        this.agr = agr;
    }
    public Bean() {
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAgr() {
        return agr;
    }

    public void setAgr(int agr) {
        this.agr = agr;
    }
}
