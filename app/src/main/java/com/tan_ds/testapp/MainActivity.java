package com.tan_ds.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler = new Handler();
        HandlerThread thread = new HandlerThread("Handler thread ");
        thread.start();
        handler = new Handler(thread.getLooper());
        new Thread (new MakeMeGreatAgain()).start();



    }

private class MakeMeGreatAgain implements Runnable{

    @Override
    public void run() {
        Log.v("Thread work", "Worker: " + Thread.currentThread().getId());


        Runnable callback = new Runnable() {
            @Override
            public void run() {
                Log.v("Thread work", "callback: " + Thread.currentThread().getId());
                Toast.makeText(MainActivity.this, "Task!", Toast.LENGTH_SHORT).show();
            }
        };
        handler.postDelayed(callback, 100);

    }
}
}
