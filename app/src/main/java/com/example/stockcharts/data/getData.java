package com.example.stockcharts.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockcharts.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;

public class getData extends AsyncTask<Integer,Void,Void> {
    Context context;
    String issue;
    listAdapter adapter;

    public getData(Context context, String issue, listAdapter adapter){

        this.context = context;
        this.issue = issue;
        this.adapter = adapter;
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        for  (Integer page:integers) {
            query(issue,page);
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void v) {
        adapter.notifyDataSetChanged();
    }

    private void query(String issue,int page){
        String url = context.getResources().getString(R.string.query_url);

        try {
            Document doc = Jsoup.connect(url + URLEncoder.encode(issue,"euc-kr") + "&page="+page).get();
            Elements elements = doc.select("tbody").select("tr");
            for (Element element : elements){
                String tit = element.select("tr td[class=tit] a").text();
                String code = element.select("tr td[class=tit] a").attr("href").split("code=")[1];
                String currentPrice = element.select("tr td").next().first().text();
                String upDown = element.select("tr td[class=num2 down]").text();
                if (element.select("tr td[class=num2 down] img").attr("alt").equals("하락")){
                    upDown = "-"+upDown;
                }
                String  upDownRate = element.select("tr td[class=num3 down]").text();

                adapter.addItem(new listData(tit,code,currentPrice,upDown,upDownRate));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
