package com.lhdz.iocdi;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by 李南 on 2016/1/27  9:53
 * Email:fengyunzhinan@163.com
 */
public class VolleyUtil {
    private static  RequestQueue mRequstQueue;
    public static void initVolley(Context context){
            if(mRequstQueue==null){
                synchronized (VolleyUtil.class){
                    if(mRequstQueue==null){
                        mRequstQueue= Volley.newRequestQueue(context);
                    }
                }
            }
        mRequstQueue.start();
    }
    public static RequestQueue getRequestQueue(){
        if (mRequstQueue==null){
            throw new RuntimeException("未初始化requestQueue");
        }
        return mRequstQueue;
    }
}
