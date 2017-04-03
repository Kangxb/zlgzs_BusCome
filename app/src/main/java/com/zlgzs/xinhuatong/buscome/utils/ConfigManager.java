package com.zlgzs.xinhuatong.buscome.utils;

import java.util.HashMap;
import java.util.Map;
/**
 * 类说明：
 *
 * @author kangxb
 * @version 1.0
 * @date 2017/4/3
 * @modfiy
 */
public class ConfigManager {

    //是否开启log输出 ，上线版本置为 false
    public static final boolean LOG_ENABLE = true;
    //是否开启log打印到文件 ，上线版本置为 false
    public static final boolean LOG_SDCARD_ENABLE = true;
    //调试开关
    public static final boolean DEBUG_SWITCH = true;
    //Log文件名
    public static final String LOG_FILE_NAME = "FootballAppLog.txt";

    //服务器地址
    public static final String HTTP_BASE_URL_RELEASE = ""; //上线环境
    public static final String HTTP_BASE_URL_HUIDU = "";//灰度环境
    public static final String HTTP_BASE_URL_TEST = "http://10.10.8.138:9091/"; //测试环境

    public static String BASE_URL = HTTP_BASE_URL_TEST;

    public static String getBaseUrl(){
        return BASE_URL;
    }


    //最终页测试地址
    public static final String NEWS_DETAIL_BASE_URL_TEST = "http://www.21cn.com/";
    //公告页测试地址
    public static final String BULLETIN_BASE_URL_TEST = "http://www.21cn.com/";
    //登录页测试地址
    public static final String LOGIN_BASE_URL_TEST = "http://admin.hd.21cn.com/";

    //俱乐部各项跳转地址,暂定,测试用
    public static final String CLUB_INTRODUCTION_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=24";
    public static final String CLUB_HISTORY_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=36";
    public static final String CLUB_HOME_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=37";
    public static final String CLUB_CLOTHES_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=38";
    public static final String CLUB_MASCOT_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=39";
    public static final String CLUB_RECORD_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=4";
    public static final String CLUB_NOTEBOOK_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=5";
    public static final String CLUB_CUP_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=40";
    public static final String CLUB_TRANSFER_URL = "http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=41";
    public static final String CLUB_LOGO_URL = "";

    //球队跳转地址,测试用
    public static final Map<String,String> TEAM_MAP_CONFIG=new HashMap(){
        {
            put("教练组","http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/alist&type=8");
            put("门将","http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/alist&type=9");
            put("后卫","http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/alist&type=10");
            put("中场","http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/alist&type=11");
            put("前锋","http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/alist&type=12");
            put("外租球员","http://121.40.39.6/hengda/appbackend/Admin/index.php?s=/Api/show&id=68");
        }
    };

}
