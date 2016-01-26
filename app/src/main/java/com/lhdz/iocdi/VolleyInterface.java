package com.lhdz.iocdi;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by 李南 on 2016/1/26  16:06
 * Email:fengyunzhinan@163.com
 */
public abstract class VolleyInterface {

    private Context context;
    public static Response.Listener<String> listener;
    public static Response.ErrorListener errorListener;

    public VolleyInterface(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this.context = context;
        this.errorListener = errorListener;
        this.listener = listener;
    }

    public Response.Listener<String> loadingListener() {
        listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                // 在这做一些全局的事情 如：弹出全局对话框，不用在每个请求的地方都写
                onMySuccess(s);

            }
            
        };
        return listener;
    }

    public Response.ErrorListener loadingErrorListener() {
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                // 在这做一些全局的事情 如：提示加载失败
                onMyError(volleyError);
            }
        };
        return errorListener;
    }

    public abstract void onMySuccess(String result);

    public abstract void onMyError(VolleyError error);
}
