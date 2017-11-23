package com.alizhezi.douyu.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by gavin
 * Time 2017/11/23  15:47
 * Email:molu_clown@163.com
 */

public class DYApplication extends Application {

    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();

        context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
