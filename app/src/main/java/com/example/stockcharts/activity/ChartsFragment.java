package com.example.stockcharts.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.stockcharts.R;
import com.github.mikephil.charting.charts.CandleStickChart;

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

    }

}