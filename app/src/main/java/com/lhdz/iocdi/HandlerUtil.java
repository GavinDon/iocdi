package com.lhdz.iocdi;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by 李南 on 2016/1/27  10:38
 * Email:fengyunzhinan@163.com
 */
public class HandlerUtil<T> extends Handler {
    /**
     * 为了解决在activity中提示
     * Handler 类应该应该为static类型，否则有可能造成泄露。
     * 在程序消息队列中排队的消息保持了对目标Handler类的应用。
     * 如果Handler是个内部类，那 么它也会保持它所在的外部类的引用。
     * 为了避免泄露这个外部类，应该将Handler声明为static嵌套类，
     * 并且使用对外部类的弱应用。
     */
    public WeakReference<T> myActivity;

    public HandlerUtil(T t) {
        myActivity = new WeakReference<>(t);


    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        T second = myActivity.get();
        if (second == null) {
            return;
        }
        switch (msg.what) {
            case 1:
                Log.i("what", msg.what + "---------");
        }
    }
}
