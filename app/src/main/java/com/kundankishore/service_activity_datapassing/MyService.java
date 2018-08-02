package com.kundankishore.service_activity_datapassing;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Caliber on 24-07-2018.
 */

public class MyService extends Service {
    public static String MY_ACTION = "MY_ACTION";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MyThread myThead = new MyThread();
        myThead.start();
        return START_NOT_STICKY;
    }
    public class MyThread extends Thread {
        @Override
        public void run() {
            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(5000);
                    Intent intent = new Intent();
                    intent.setAction(MY_ACTION);
                    intent.putExtra("DATAPASSED",i);
                    sendBroadcast(intent);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            stopSelf();
        }
    }
}
