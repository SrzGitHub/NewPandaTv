package co.com.newpandatv.config;


import co.com.newpandatv.view.activity.PDBCActivity;

public class Urls {

    //服务器地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";

    //熊猫直播
    public static final String PANDALIVE = BASEURL+"PAGE14501769230331752/index.json";
    //熊猫播报
    public static final String PANDABROADCAST = "http://www.ipanda.com/kehuduan/news/index.json";
    //熊猫播报的re
    public static final String PANDABROADCASTINFO = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda";
    //熊猫播报跳转界面的第二个界面的服务器地址
    public static  final  String PDBCINFOBASEURL = "http://api.cntv.cn/article/contentinfo?id=";

    //     http://api.cntv.cn/article/contentinfo?id=ARTIqx8nsLeWCFKAee59LPCx170911&serviceId=panda
//    http://api.cntv.cn/article/contentinfo?id=ARTIRZA94zBmXIioIreYt1jR170914&serviceId=panda
    public static String PDBCINFOURL = PDBCINFOBASEURL + PDBCActivity.id + "&serviceId=panda";

//http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=2
}
