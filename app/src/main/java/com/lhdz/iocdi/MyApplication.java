package com.lhdz.iocdi;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;

/**
 * Created by 李南 on 2016/1/26  15:05
 * Email:fengyunzhinan@163.com
 */
public class MyApplication extends Application {

    private static RequestQueue queue;
    public static  Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtil.initVolley(getContext());


    }

    /**
     * 获取全局context
     *
     * @return
     */
    public Context getContext() {
        context = getApplicationContext();
        return context;
    }


}
