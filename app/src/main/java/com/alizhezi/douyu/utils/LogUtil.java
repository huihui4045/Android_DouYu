package com.alizhezi.douyu.utils;

import android.content.Context;
import android.util.Log;


/**
 * log日志管理
 * Author: gavin
 * Date: 2016/4/28
 * Time: 16:58
 * Email:2415580905@qq.com
 * <p/>
 * true ：打开log日志
 * false:关闭log日志
 */
public class LogUtil {


    static boolean LOG = false;

    /**
     * 是否打印log日志
     *
     * @param LOG
     */
    public static void setLOG(boolean LOG) {
        LogUtil.LOG = LOG;
    }

    public static void json(String string) {
        //if (LOG)
        // Logger.json(string);
    }


    public static void i(String tag, String string) {
        if (LOG) Log.i(tag, string);
    }

    public static void e(String tag, String string) {
        if (LOG) Log.e(tag, string);
    }

    public static void e(Context context, String string) {
        e(context.getClass().getSimpleName(), string);
    }

    public static void d(String tag, String string) {
        if (LOG) Log.d(tag, string);
    }

    public static void v(String tag, String string) {
        if (LOG) Log.v(tag, string);
    }

    public static void w(String tag, String string) {
        if (LOG) Log.w(tag, string);
    }
}
