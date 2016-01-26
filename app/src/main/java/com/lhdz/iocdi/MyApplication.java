package com.lhdz.iocdi;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by 李南 on 2016/1/26  15:05
 * Email:fengyunzhinan@163.com
 */
public class MyApplication extends Application {

    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());

    }

    public static RequestQueue getRequstQueue() {
        return queue;
    }
}
