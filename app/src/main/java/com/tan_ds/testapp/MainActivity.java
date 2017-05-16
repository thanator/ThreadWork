package com.tan_ds.testapp;

import android.app.Activity;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
    AsyncTaskimpl astask;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler(new HandlerCallBack());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.v("Thread work", "ILITA");
                mHandler.postDelayed(this, 2000);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    private class HandlerCallBack implements Handler.Callback{

        @Override
        public boolean handleMessage(Message msg) {

            Log.v("Thread work", "handlmsg: ");
            return false;
        }
    }



    private class AsyncTaskimpl extends AsyncTask <String, Integer, Double>{

        @Override
        protected Double doInBackground(String... params) {
            SystemClock.sleep(5000);
            List<String> listParams = Arrays.asList(params);

            Log.v("Thread work", "back: " + Thread.currentThread().getId());
            Log.v("Thread work", "back: " + listParams);

            for (Integer i = 0; i < 10 ; i++){
                publishProgress(i, i+1);
            }

            Random random = new Random();
            return random.nextDouble();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.v("Thread work", "update: " + Arrays.toString(values));
        }

        @Override
        protected void onPostExecute(Double result) {
            super.onPostExecute(result);
            Log.v("Thread work", "Post execute: " + result);

            Log.v("Thread work", "Post execute: " + Thread.currentThread().getId());
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.v("Thread work", "Pre execute: " + Thread.currentThread().getId());
        }
    }


}
