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

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssyncTaskimpl ass = new AssyncTaskimpl();
        ass.execute("AAAAA", "ccccc");


    }

    private class AssyncTaskimpl extends AsyncTask <String, Integer, Double>{

        @Override
        protected Double doInBackground(String... params) {
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
            Log.v("Thread work", "Postexecute: " + result);

            Log.v("Thread work", "Postexecute: " + Thread.currentThread().getId());
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.v("Thread work", "Preexecute: " + Thread.currentThread().getId());
        }
    }


}
