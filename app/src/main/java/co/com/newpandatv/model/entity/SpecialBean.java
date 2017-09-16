package co.com.newpandatv.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class SpecialBean {


    /**
     * videoset : {"0":{"vsid":"VSET100167308855","relvsid":"","name":"熊猫频道-特别节目","img":"http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167308855","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"2013-05-01","sbpd":"其他","desc":"熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。","playdesc":"","zcr":"","fcl":""},"count":"268"}
     * video : [{"vsid":"VSET100167308855","order":"262","vid":"b2be1af5436f4896b139f9cf57650385","t":"《特别节目》 20170913 精彩集锦：你瞅啥？瞅你咋的！","url":"http://tv.cntv.cn/video/VSET100167308855/b2be1af5436f4896b139f9cf57650385","ptime":"2017-09-13 11:02:48","img":"http://p3.img.cctvpic.com/fmspic/2017/09/13/b2be1af5436f4896b139f9cf57650385-50.jpg?p=2&h=120","len":"00:01:13","em":"CM01"},{"vsid":"VSET100167308855","order":"261","vid":"6060544b8f574f9aa087b7b4be0ba385","t":"《萌出血！新生大熊猫奶声奶气，紧急呼叫医疗兵！》 20170912","url":"http://tv.cntv.cn/video/VSET100167308855/6060544b8f574f9aa087b7b4be0ba385","ptime":"2017-09-12 12:00:01","img":"http://p5.img.cctvpic.com/fmspic/2017/09/12/6060544b8f574f9aa087b7b4be0ba385-2049.jpg?p=2&h=120","len":"01:07:39","em":"CM01"},{"vsid":"VSET100167308855","order":"260","vid":"be7bb2d5383c47d0b84362018e17646b","t":"《特别节目》 20170906 你能忍住不咽口水吗","url":"http://tv.cntv.cn/video/VSET100167308855/be7bb2d5383c47d0b84362018e17646b","ptime":"2017-09-06 09:51:53","img":"http://p5.img.cctvpic.com/fmspic/2017/09/06/be7bb2d5383c47d0b84362018e17646b-50.jpg?p=2&h=120","len":"00:01:19","em":"CM01"},{"vsid":"VSET100167308855","order":"259","vid":"b56abfff86e34160a0400fc22a95f8ab","t":"《特别节目》 20170905 七喜七巧在鄂尔多斯的日常","url":"http://tv.cntv.cn/video/VSET100167308855/b56abfff86e34160a0400fc22a95f8ab","ptime":"2017-09-05 16:59:01","img":"http://p3.img.cctvpic.com/fmspic/2017/09/05/b56abfff86e34160a0400fc22a95f8ab-76.jpg?p=2&h=120","len":"00:02:12","em":"CM01"},{"vsid":"VSET100167308855","order":"258","vid":"ccc1af08aaf449149fe40bb0ca32d429","t":"《特别节目》 20170830 熊家的party时间","url":"http://tv.cntv.cn/video/VSET100167308855/ccc1af08aaf449149fe40bb0ca32d429","ptime":"2017-08-30 13:38:59","img":"http://p5.img.cctvpic.com/fmspic/2017/08/30/ccc1af08aaf449149fe40bb0ca32d429-24.jpg?p=2&h=120","len":"00:00:29","em":"CM01"},{"vsid":"VSET100167308855","order":"257","vid":"416b349ded9c4b7cbd4751d99e8891d3","t":"《超治愈！新生大熊猫宝宝萌炸了》 20170829","url":"http://tv.cntv.cn/video/VSET100167308855/416b349ded9c4b7cbd4751d99e8891d3","ptime":"2017-08-29 15:53:00","img":"http://p1.img.cctvpic.com/fmspic/2017/08/29/416b349ded9c4b7cbd4751d99e8891d3-2529.jpg?p=2&h=120","len":"01:23:50","em":"CM01"},{"vsid":"VSET100167308855","order":"256","vid":"7d826d24b4e443ad88dd59ad03d50dfe","t":"《特别节目》 20170828 大熊猫竟然每天都要干这些事情无数次！","url":"http://tv.cntv.cn/video/VSET100167308855/7d826d24b4e443ad88dd59ad03d50dfe","ptime":"2017-08-28 14:56:34","img":"http://p3.img.cctvpic.com/fmspic/2017/08/28/7d826d24b4e443ad88dd59ad03d50dfe-43.jpg?p=2&h=120","len":"00:01:05","em":"CM01"}]
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
         * 0 : {"vsid":"VSET100167308855","relvsid":"","name":"熊猫频道-特别节目","img":"http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167308855","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"2013-05-01","sbpd":"其他","desc":"熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。","playdesc":"","zcr":"","fcl":""}
         * count : 268
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
             * vsid : VSET100167308855
             * relvsid :
             * name : 熊猫频道-特别节目
             * img : http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167308855
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167308855
         * order : 262
         * vid : b2be1af5436f4896b139f9cf57650385
         * t : 《特别节目》 20170913 精彩集锦：你瞅啥？瞅你咋的！
         * url : http://tv.cntv.cn/video/VSET100167308855/b2be1af5436f4896b139f9cf57650385
         * ptime : 2017-09-13 11:02:48
         * img : http://p3.img.cctvpic.com/fmspic/2017/09/13/b2be1af5436f4896b139f9cf57650385-50.jpg?p=2&h=120
         * len : 00:01:13
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
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

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
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

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
