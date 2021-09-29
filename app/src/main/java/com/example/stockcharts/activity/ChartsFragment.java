package com.example.stockcharts.activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.stockcharts.R;
import com.example.stockcharts.data.candleData;
import com.example.stockcharts.data.getCandleData;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ChartsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return (ViewGroup) inflater.inflate(
                R.layout.fragment_charts, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        CandleStickChart chart = (CandleStickChart) view.findViewById(R.id.chart);
        ArrayList<CandleEntry> data = new ArrayList<>();

        if (MainActivity.code.length() > 0) {
            try {
                data = (ArrayList<CandleEntry>) new getCandleData(getContext(), MainActivity.code).execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            drawChart(chart,data);





        }

    }


    private void drawChart(CandleStickChart chart, ArrayList<CandleEntry> data){

        CandleDataSet set = new CandleDataSet(data,"label");

        //심지
        set.setShadowColor(Color.LTGRAY);
        set.setShadowWidth(1f);
        //음봉
        set.setDecreasingColor(Color.BLUE);
        set.setIncreasingPaintStyle(Paint.Style.FILL);
        //양봉
        set.setIncreasingColor(Color.RED);
        set.setIncreasingPaintStyle(Paint.Style.FILL);
        //변동x
        set.setNeutralColor(Color.DKGRAY);
        //y축 보이기
        set.setDrawValues(true);
        //터치 시 노란선 제거?
        set.setHighLightColor(Color.TRANSPARENT);

        CandleData candle = new CandleData();
        candle.addDataSet(set);

        chart.setData(candle);
        chart.invalidate();


    }

}