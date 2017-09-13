package co.com.newpandatv.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class SuperMOEshowBean {


    /**
     * video : [{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/04/09/00362cdfea104d7298feacfbe8b40549-87.jpg","len":"00:02:34","order":"67","ptime":"2017-04-09 17:30:45","t":"《77滚滚秀》 20170409 第六十七期：当时我就震惊了","url":"http://tv.cntv.cn/video/VSET100272959126/00362cdfea104d7298feacfbe8b40549","vid":"00362cdfea104d7298feacfbe8b40549","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/03/31/cea3a33cd54a45988d0512d65b9b2aae-91.jpg","len":"00:02:41","order":"66","ptime":"2017-03-31 18:33:24","t":"《77滚滚秀》 20170331 第六十六期：寻奶大作战","url":"http://tv.cntv.cn/video/VSET100272959126/cea3a33cd54a45988d0512d65b9b2aae","vid":"cea3a33cd54a45988d0512d65b9b2aae","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/03/25/2385afcf3a2b4546a8a205ff81f01d47-87.jpg","len":"00:02:34","order":"65","ptime":"2017-03-25 15:39:07","t":"《77滚滚秀》 20170325 第六十五期：爱挤油的团子","url":"http://tv.cntv.cn/video/VSET100272959126/2385afcf3a2b4546a8a205ff81f01d47","vid":"2385afcf3a2b4546a8a205ff81f01d47","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/03/18/3c6b9ac4badc4b06a0ec5746fcd15ec8-129.jpg","len":"00:04:05","order":"64","ptime":"2017-03-18 19:42:01","t":"《77滚滚秀》 20170318 第六十四期：至尊唱片MV","url":"http://tv.cntv.cn/video/VSET100272959126/3c6b9ac4badc4b06a0ec5746fcd15ec8","vid":"3c6b9ac4badc4b06a0ec5746fcd15ec8","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/03/13/7588082c0abe44e99d006bae0ac926c7-99.jpg","len":"00:02:57","order":"63","ptime":"2017-03-13 13:13:37","t":"《77滚滚秀》 20170313 第六十三期：聪明滚滚一大堆！","url":"http://tv.cntv.cn/video/VSET100272959126/7588082c0abe44e99d006bae0ac926c7","vid":"7588082c0abe44e99d006bae0ac926c7","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/02/24/072081c57c7a412caf97380bd591ad91-92.jpg","len":"00:02:44","order":"62","ptime":"2017-02-24 19:43:57","t":"《77滚滚秀》 20170224 第六十二期：这团子交给你来守护吧！","url":"http://tv.cntv.cn/video/VSET100272959126/072081c57c7a412caf97380bd591ad91","vid":"072081c57c7a412caf97380bd591ad91","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/02/17/3bd6524358714403bf52c3331fc68214-87.jpg","len":"00:02:34","order":"61","ptime":"2017-02-17 17:50:13","t":"《77滚滚秀》 20170217 第六十一期：和滚滚一起趴的周末!","url":"http://tv.cntv.cn/video/VSET100272959126/3bd6524358714403bf52c3331fc68214","vid":"3bd6524358714403bf52c3331fc68214","vsid":"VSET100272959126"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神\u201c技能\u201d，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。","dy":"","enname":"","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg","js":"","name":"77滚滚秀","nf":"","playdesc":"","relvsid":"","sbpd":"","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100272959126","vsid":"VSET100272959126","yz":"","zcr":"","zy":""},"count":"70"}
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
         * 0 : {"bj":"","cd":"","desc":"《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神\u201c技能\u201d，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。","dy":"","enname":"","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg","js":"","name":"77滚滚秀","nf":"","playdesc":"","relvsid":"","sbpd":"","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100272959126","vsid":"VSET100272959126","yz":"","zcr":"","zy":""}
         * count : 70
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
             * desc : 《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神“技能”，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。
             * dy :
             * enname :
             * fcl :
             * fl :
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg
             * js :
             * name : 77滚滚秀
             * nf :
             * playdesc :
             * relvsid :
             * sbpd :
             * sbsj :
             * url : http://tv.cntv.cn/videoset/VSET100272959126
             * vsid : VSET100272959126
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
         * img : http://p2.img.cctvpic.com/fmspic/2017/04/09/00362cdfea104d7298feacfbe8b40549-87.jpg
         * len : 00:02:34
         * order : 67
         * ptime : 2017-04-09 17:30:45
         * t : 《77滚滚秀》 20170409 第六十七期：当时我就震惊了
         * url : http://tv.cntv.cn/video/VSET100272959126/00362cdfea104d7298feacfbe8b40549
         * vid : 00362cdfea104d7298feacfbe8b40549
         * vsid : VSET100272959126
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
