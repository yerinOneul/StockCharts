package com.example.stockcharts.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.stockcharts.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class getData extends AsyncTask {
    Context context;

    public getData(Context context){
        this.context = context;
    }


    @Override
    protected Object doInBackground(Object[] objects) {
        getCode();
        return null;
    }


    private void getCode(){
        String url = context.getResources().getString(R.string.code_url);
        try {
            Document doc = Jsoup.connect(url+1).get();
            Log.e("!!", String.valueOf(doc));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
