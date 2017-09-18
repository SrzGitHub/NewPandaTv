package co.com.newpandatv.model.entity.home_video_bean;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 * 首页  滚滚视频
 *
 * http://www.ipanda.com/kehuduan/shipinliebieye/guangyingzhongguo/index.json
 */

public class BillowingvideoLiuBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * daytime : 2017-02-27
         * id : TITE1488182767919809
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/02/23/2017022316521539147.jpg
         * order : 1
         * pid : 046b651d08244f59818540a0b88bd97a
         * title : 张家界：云雾飘渺绕峰峦
         * type : 2
         * url : http://livechina.ipanda.com/2017/02/23/VIDE4c6LCDz662fn59Z2FnnT170223.shtml
         * vid :
         * videoLength : 00:57
         */

        private String daytime;
        private String id;
        private String image;
        private String order;
        private String pid;
        private String title;
        private String type;
        private String url;
        private String vid;
        private String videoLength;

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }
    }
}
