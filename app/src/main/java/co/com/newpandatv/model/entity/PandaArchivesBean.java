package co.com.newpandatv.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaArchivesBean {


    /**
     * video : [{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/09/07/0a4f2c371ee64fdd8063bfd79eaaf2aa-129.jpg?p=2&h=120","len":"00:05:12","order":"17","ptime":"2017-09-07 13:56:10","t":"《熊猫档案》 20170907 成长外挂第七期：大侠奇好方","url":"http://tv.cntv.cn/video/VSET100340574858/0a4f2c371ee64fdd8063bfd79eaaf2aa","vid":"0a4f2c371ee64fdd8063bfd79eaaf2aa","vsid":"VSET100340574858"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/08/31/e6c80dae83884dc3a18bbf279b1815b0-189.jpg?p=2&h=120","len":"00:06:05","order":"16","ptime":"2017-08-31 15:49:32","t":"《熊猫档案》 20170831 认猫插件第七期：坐拥20亿流量的短腿女王","url":"http://tv.cntv.cn/video/VSET100340574858/e6c80dae83884dc3a18bbf279b1815b0","vid":"e6c80dae83884dc3a18bbf279b1815b0","vsid":"VSET100340574858"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/08/31/953186779c424e27b7bcb9e50779c15d-189.jpg?p=2&h=120","len":"00:06:05","order":"15","ptime":"2017-08-31 15:32:44","t":"《熊猫档案》 20170831 第14期 奇一-认猫插件","url":"http://tv.cntv.cn/video/VSET100340574858/953186779c424e27b7bcb9e50779c15d","vid":"953186779c424e27b7bcb9e50779c15d","vsid":"VSET100340574858"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/08/17/6c93df1719914c068428f0a06a7d168f-129.jpg?p=2&h=120","len":"00:04:37","order":"14","ptime":"2017-08-17 14:42:18","t":"《熊猫档案》 20170817 成长外挂第六期：体操公主雅韵","url":"http://tv.cntv.cn/video/VSET100340574858/6c93df1719914c068428f0a06a7d168f","vid":"6c93df1719914c068428f0a06a7d168f","vsid":"VSET100340574858"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/08/10/be4097612e7d488abb49bc86afb021da-129.jpg?p=2&h=120","len":"00:04:50","order":"13","ptime":"2017-08-10 15:43:17","t":"《熊猫档案》 20170810 认猫插件第六期：别找了，你要的freestyle这里都有","url":"http://tv.cntv.cn/video/VSET100340574858/be4097612e7d488abb49bc86afb021da","vid":"be4097612e7d488abb49bc86afb021da","vsid":"VSET100340574858"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/07/27/e450275281984788833bc978f47eabdc-130.jpg?p=2&h=120","len":"00:05:12","order":"12","ptime":"2017-07-27 13:54:07","t":"《熊猫档案》 20170727 成长外挂第五期：雅竹","url":"http://tv.cntv.cn/video/VSET100340574858/e450275281984788833bc978f47eabdc","vid":"e450275281984788833bc978f47eabdc","vsid":"VSET100340574858"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/07/20/03ddbe69099441b09961bd37d8a8f782-189.jpg?p=2&h=120","len":"00:06:08","order":"11","ptime":"2017-07-20 17:25:10","t":"《熊猫档案》 20170720 认猫插件第五期：国际范\u201c雅竹\u201d","url":"http://tv.cntv.cn/video/VSET100340574858/03ddbe69099441b09961bd37d8a8f782","vid":"03ddbe69099441b09961bd37d8a8f782","vsid":"VSET100340574858"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。","dy":"","enname":"其他","fcl":"","fl":"熊猫直播","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg","js":"","name":"熊猫档案","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100340574858","vsid":"VSET100340574858","yz":"","zcr":"","zy":""},"count":"17"}
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
         * 0 : {"bj":"","cd":"","desc":"请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。","dy":"","enname":"其他","fcl":"","fl":"熊猫直播","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg","js":"","name":"熊猫档案","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100340574858","vsid":"VSET100340574858","yz":"","zcr":"","zy":""}
         * count : 17
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
             * desc : 请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。
             * dy :
             * enname : 其他
             * fcl :
             * fl : 熊猫直播
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg
             * js :
             * name : 熊猫档案
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj :
             * url : http://tv.cntv.cn/videoset/VSET100340574858
             * vsid : VSET100340574858
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
         * img : http://p3.img.cctvpic.com/fmspic/2017/09/07/0a4f2c371ee64fdd8063bfd79eaaf2aa-129.jpg?p=2&h=120
         * len : 00:05:12
         * order : 17
         * ptime : 2017-09-07 13:56:10
         * t : 《熊猫档案》 20170907 成长外挂第七期：大侠奇好方
         * url : http://tv.cntv.cn/video/VSET100340574858/0a4f2c371ee64fdd8063bfd79eaaf2aa
         * vid : 0a4f2c371ee64fdd8063bfd79eaaf2aa
         * vsid : VSET100340574858
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
