package co.com.newpandatv.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class OriginalNewsBean {

    /**
     * video : [{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120","len":"00:01:31","order":"548","ptime":"2017-08-24 15:36:16","t":"《原创新闻》 20170824 熊猫快讯：大熊猫名门千金\u201c宝宝\u201d迎来四岁生日","url":"http://tv.cntv.cn/video/VSET100219009515/9668c35873f447278bf1fc9285fed95a","vid":"9668c35873f447278bf1fc9285fed95a","vsid":"VSET100219009515"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/08/03/d2615bb73fd24961b7e55fc1eb6d854b-50.jpg?p=2&h=120","len":"00:01:14","order":"547","ptime":"2017-08-03 17:38:00","t":"《原创新闻》 20170803 熊猫快讯：23岁大熊猫\u201c海子\u201d产下双胞胎","url":"http://tv.cntv.cn/video/VSET100219009515/d2615bb73fd24961b7e55fc1eb6d854b","vid":"d2615bb73fd24961b7e55fc1eb6d854b","vsid":"VSET100219009515"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/07/25/536d60986ad745f19f6e0a167c4bb55d-38.jpg?p=2&h=120","len":"00:00:56","order":"546","ptime":"2017-07-25 15:38:42","t":"《原创新闻》 20170725 成都大熊猫\u201c二巧\u201d顺利产仔","url":"http://tv.cntv.cn/video/VSET100219009515/536d60986ad745f19f6e0a167c4bb55d","vid":"536d60986ad745f19f6e0a167c4bb55d","vsid":"VSET100219009515"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/07/17/d3532d1b5196448bac4d93c175695162-70.jpg?p=2&h=120","len":"00:01:49","order":"545","ptime":"2017-07-17 18:36:50","t":"《原创新闻》 20170717 熊猫快讯： 海归大熊猫\u201c林冰\u201d再次产下龙凤胎","url":"http://tv.cntv.cn/video/VSET100219009515/d3532d1b5196448bac4d93c175695162","vid":"d3532d1b5196448bac4d93c175695162","vsid":"VSET100219009515"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/07/11/2cc9ad105fb6444fa49f2f3af4507411-50.jpg?p=2&h=120","len":"00:01:19","order":"544","ptime":"2017-07-11 16:20:20","t":"《原创新闻》 20170711 海归大熊猫\u201c泰山\u201d12岁庆生","url":"http://tv.cntv.cn/video/VSET100219009515/2cc9ad105fb6444fa49f2f3af4507411","vid":"2cc9ad105fb6444fa49f2f3af4507411","vsid":"VSET100219009515"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/05/11/03ddb4c26db24aa7bce27368bb64e838-50.jpg","len":"00:01:21","order":"543","ptime":"2017-05-11 16:50:16","t":"《特别节目》 20170511 中国大熊猫保护研究\u201c九寨\u201d杯国际摄影大赛开赛","url":"http://tv.cntv.cn/video/VSET100219009515/03ddb4c26db24aa7bce27368bb64e838","vid":"03ddb4c26db24aa7bce27368bb64e838","vsid":"VSET100219009515"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/04/25/45104f84f3084adb89d7381cec35ca3e-99.jpg","len":"00:02:57","order":"542","ptime":"2017-04-25 15:46:35","t":"《原创新闻》 20170425 熊猫快讯：揭秘大熊猫野外引种试验的主角--大熊猫\u201c草草\u201d","url":"http://tv.cntv.cn/video/VSET100219009515/45104f84f3084adb89d7381cec35ca3e","vid":"45104f84f3084adb89d7381cec35ca3e","vsid":"VSET100219009515"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"熊猫频道原创新闻高清内容。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg","js":"","name":"熊猫频道-原创新闻（高清）","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100219009515","vsid":"VSET100219009515","yz":"","zcr":"","zy":""},"count":"547"}
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"bj":"","cd":"","desc":"熊猫频道原创新闻高清内容。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg","js":"","name":"熊猫频道-原创新闻（高清）","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100219009515","vsid":"VSET100219009515","yz":"","zcr":"","zy":""}
         * count : 547
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * bj :
             * cd :
             * desc : 熊猫频道原创新闻高清内容。
             * dy :
             * enname : 其他
             * fcl :
             * fl :
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg
             * js :
             * name : 熊猫频道-原创新闻（高清）
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj :
             * url : http://tv.cntv.cn/videoset/VSET100219009515
             * vsid : VSET100219009515
             * yz :
             * zcr :
             * zy :
             */

            private String bj;
            private String cd;
            private String desc;
            private String dy;
            private String enname;
            private String fcl;
            private String fl;
            private String img;
            private String js;
            private String name;
            private String nf;
            private String playdesc;
            private String relvsid;
            private String sbpd;
            private String sbsj;
            private String url;
            private String vsid;
            private String yz;
            private String zcr;
            private String zy;

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }
        }
    }

    public static class VideoBean {
        /**
         * em : CM01
         * img : http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120
         * len : 00:01:31
         * order : 548
         * ptime : 2017-08-24 15:36:16
         * t : 《原创新闻》 20170824 熊猫快讯：大熊猫名门千金“宝宝”迎来四岁生日
         * url : http://tv.cntv.cn/video/VSET100219009515/9668c35873f447278bf1fc9285fed95a
         * vid : 9668c35873f447278bf1fc9285fed95a
         * vsid : VSET100219009515
         */

        private String em;
        private String img;
        private String len;
        private String order;
        private String ptime;
        private String t;
        private String url;
        private String vid;
        private String vsid;

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }
    }
}
