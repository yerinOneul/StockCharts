package com.example.stockcharts.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stockcharts.R;
import com.example.stockcharts.data.getData;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class SearchFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return (ViewGroup) inflater.inflate(
                R.layout.fragment_search, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView text = (TextView) view.findViewById(R.id.text_search);
        Button search_btn = (Button) view.findViewById(R.id.search_btn);


        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new getData(getContext()).execute();
            }
        });

    }

}
