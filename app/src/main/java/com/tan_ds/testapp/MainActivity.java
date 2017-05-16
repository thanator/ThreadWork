package com.tan_ds.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      Log.v("curr create act", "" + Thread.currentThread().getId());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();*/

  Thread thread = new Thread (new MakeMeGreatAgain());
        thread.start();



    }

private class MakeMeGreatAgain implements Runnable{

    @Override
    public void run() {
        Log.v("Thread work", "Worker: " + Thread.currentThread().getId());


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.v("Thread work", "callback: " + Thread.currentThread().getId());
                Toast.makeText(MainActivity.this, "Task ended!", Toast.LENGTH_SHORT);
            }
        }, 5000);
        handler.removeCallbacksAndMessages(null);

    }
}
}
