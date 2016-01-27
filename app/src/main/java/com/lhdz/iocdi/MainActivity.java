package com.lhdz.iocdi;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {
    private TextView tv_dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        volley_get();
//      volley_post();

    }



    private void init() {
        tv_dis = (TextView) findViewById(R.id.tv_dis);
        Message msg = new Message();
        msg.what = 1;
        HandlerUtil hand=new HandlerUtil(this);
        hand.sendMessage(msg);



    }



    private void volley_get() {
        String url = "http://www.imxiexie.com/Information/index.html";


        VolleyRequest.RequstGet(this, url, "test", new VolleyInterface(this, VolleyInterface.listener, VolleyInterface.errorListener) {
            @Override
            public void onMySuccess(String result) {
//                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                tv_dis.setText(result);

            }

            @Override
            public void onMyError(VolleyError error) {
//                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

    private void volley_post() {
        String url = "http://www.imxiexie.com/Information/index.html";
        Map<String, String> params = new HashMap<>();
//        params.put("body","");

        VolleyRequest.RequstPost(url, "postRequst", params, new VolleyInterface(this, VolleyInterface.listener, VolleyInterface.errorListener) {
            @Override
            public void onMySuccess(String result) {
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMyError(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VolleyUtil.getRequestQueue().cancelAll("postRequst");
    }
}
