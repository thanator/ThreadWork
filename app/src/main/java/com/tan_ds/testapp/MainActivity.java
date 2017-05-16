package com.tan_ds.testapp;

import android.app.Activity;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssyncTaskimpl ass = new AssyncTaskimpl();
        ass.execute();


    }

    private class AssyncTaskimpl extends AsyncTask <Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {

            Log.v("Thread work", "back: " + Thread.currentThread().getId());
            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.v("Thread work", "execute: " + Thread.currentThread().getId());
        }
    }


}
