package co.com.newpandatv.model.entity;

import java.util.List;

/**
 * Created by lenovo on 2017/9/13.
 */

public class TaiShanBean {
    private List<LiveBean> live;

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public static class LiveBean {
        /**
         * brief : 泰山位于山东省中部，总面积426平方公里，主峰玉皇顶海拔1545米，气势雄伟磅礴，有“五岳独尊”之称。泰山融雄伟壮丽的自然风光与悠久灿烂的历史文化于一体，是中国首例世界文化与自然双遗产、世界地质公园、首批全国文明风景旅游区、首批国家5A级旅游景区。
         * id : taishan01
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451291429381_140.jpg
         * order : 1
         * title : 泰山主峰
         */

        private String brief;
        private String id;
        private String image;
        private String order;
        private String title;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
