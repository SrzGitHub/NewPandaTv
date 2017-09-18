package co.com.newpandatv.model.entity;

import java.util.List;

/**
 * Created by lenovo on 2017/9/14.
 */

public class MostZhiboChina {
    private List<AlllistBean> alllist;

    public List<AlllistBean> getAlllist() {
        return alllist;
    }

    public void setAlllist(List<AlllistBean> alllist) {
        this.alllist = alllist;
    }

    public static class AlllistBean {
        /**
         * order : 1
         * title : 凤凰古城
         * type :
         * url : http://www.ipanda.com/kehuduan/liebiao/fenghuanggucheng/index.json
         */

        private String order;
        private String title;
        private String type;
        private String url;

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
    }
}
