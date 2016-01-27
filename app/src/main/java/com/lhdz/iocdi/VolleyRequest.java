package com.lhdz.iocdi;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by 李南 on 2016/1/26  15:59
 * Email:fengyunzhinan@163.com
 */
public class VolleyRequest {
    public static StringRequest requst;
    private Context context;



    public static void RequstGet(Context context, String url, String tag, VolleyInterface vif) {
        VolleyUtil.getRequestQueue().cancelAll(tag);
        requst = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.loadingErrorListener()){
            //解决服务端不是用UTF-8编码带来的乱码问题
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String str = null;
                try {
                    str = new String(response.data, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return Response.success(str,
                        HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        requst.setTag(tag);
        VolleyUtil.getRequestQueue().add(requst);
//        VolleyUtil.getRequestQueue().start();

    }

    public static void RequstPost(String url, String tag, final Map<String, String> params, VolleyInterface vif) {
        VolleyUtil.getRequestQueue().cancelAll(tag);
        requst = new StringRequest(Request.Method.POST, url, vif.loadingListener(), vif.loadingErrorListener()) {
            @Override
            //post请求要传递参数
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        requst.setTag(tag);
        VolleyUtil.getRequestQueue().add(requst);
        VolleyUtil.getRequestQueue().start();


    }

//    @Override
//    public int compareTo(Object another) {
//        return 0;
//    }
//
//    @Override
//    protected Response<String> parseNetworkResponse(NetworkResponse response) {
//        String str = null;
//        try {
//            str = new String(response.data, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return Response.success(str,
//                HttpHeaderParser.parseCacheHeaders(response));
//    }
//
//
//    @Override
//    protected void deliverResponse(Object o) {
//
//    }
}
