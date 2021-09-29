package com.example.stockcharts.data;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stockcharts.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class listAdapter extends BaseAdapter {
    Context context;
    ArrayList<listData> data = new ArrayList<>();

    public listAdapter(Context context){
        this.context = context;
    }

    public void addItem(listData dt){
        data.add(dt);
    }

    public void clear(){
        data.clear();
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public listData getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =  inflater.inflate(R.layout.custom_listview, viewGroup, false);
            TextView issue = (TextView)view.findViewById(R.id.issue);
            TextView currentPrice = (TextView)view.findViewById(R.id.currentPrice);
            TextView upDown = (TextView)view.findViewById(R.id.upDown);
            TextView upDownRate = (TextView)view.findViewById(R.id.upDownRate);

            issue.setText(data.get(i).getIssue());
            currentPrice.setText(data.get(i).getCurrentPrice());
            upDown.setText(data.get(i).getUpDown());
            upDownRate.setText(String.valueOf(data.get(i).getUpDownRate()));

        }


        return view;
    }
}
