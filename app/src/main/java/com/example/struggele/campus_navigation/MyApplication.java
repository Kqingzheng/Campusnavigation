package com.example.struggele.campus_navigation;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class MyApplication extends Application {
    private static Context context;
    private static MyApplication sInstance;
    public static MyApplication getInstance() {
        return sInstance;
    }

    /**
     * 在主线程中刷新UI的方法
     *
     * @param r
     */
    public static void runOnUIThread(Runnable r) {
        MyApplication.getMainHandler().post(r);
    }
    /**
     * app的入口函数
     */
    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
        sInstance = this;
        //初始化handler
        mHandler = new Handler();
    }
    public static Context getContext(){
        return context;
    }
    private static Handler mHandler;

    public static Handler getMainHandler() {
        return mHandler;
    }
}
