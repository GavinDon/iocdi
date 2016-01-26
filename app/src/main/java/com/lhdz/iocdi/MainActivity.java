package com.lhdz.iocdi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.VolleyError;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volley_get();

    }

    private void volley_get() {
        String url = "http://www.imxiexie.com/Information/index.html";


        VolleyRequest.RequstGet(this, url, "test", new VolleyInterface(this, VolleyInterface.listener, VolleyInterface.errorListener) {
            @Override
            public void onMySuccess(String result) {
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMyError(VolleyError error) {
//                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getRequstQueue().cancelAll("test");
    }
}
