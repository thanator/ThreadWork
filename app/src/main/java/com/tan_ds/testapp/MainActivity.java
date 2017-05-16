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
        mHandler.sendEmptyMessage(100500);
        Message msg = Message.obtain();
        msg.what = 42;
        msg.arg1 = 24;
        msg.arg2 = 1;

        mHandler.sendMessage(msg);

        //mHandler.removeMessages(42);

    }
    private class HandlerCallBack implements Handler.Callback{

        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what){
                case 42:
                    break;
                case 100500:
                    Log.v("Thread work", "ILITA: " + msg);
                    break;
                default:
                    break;
            }

            Log.v("Thread work", "handlmsg: " + msg);
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
