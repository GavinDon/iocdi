package com.lhdz.iocdi;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by 李南 on 2016/1/26  15:59
 * Email:fengyunzhinan@163.com
 */
public class VolleyRequest {
    public static StringRequest requst;
    private Context context;

    public static void RequstGet(Context context, String url, String tag, VolleyInterface vif) {
        MyApplication.getRequstQueue().cancelAll(tag);
        requst = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.loadingErrorListener());
        requst.setTag(tag);
        MyApplication.getRequstQueue().add(requst);
        MyApplication.getRequstQueue().start();
    }

    public static void RequstPost() {

    }
}
