package com.lhdz.iocdi;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

/**
 * Created by 李南 on 2016/1/26  15:59
 * Email:fengyunzhinan@163.com
 */
public class VolleyRequest extends Request {
    public static StringRequest requst;
    private Context context;

    public VolleyRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    public static void RequstGet(Context context, String url, String tag, VolleyInterface vif) {
        MyApplication.getRequstQueue().cancelAll(tag);
        final String TYPE_UTF8_CHARSET = "charset=UTF-8";
        requst = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.loadingErrorListener());
        requst.setTag(tag);
        MyApplication.getRequstQueue().add(requst);
        MyApplication.getRequstQueue().start();

    }

    public static void RequstPost() {

    }

    @Override
    public int compareTo(Object another) {
        return 0;
    }

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


    @Override
    protected void deliverResponse(Object o) {

    }
}
