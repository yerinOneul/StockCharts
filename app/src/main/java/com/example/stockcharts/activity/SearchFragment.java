package com.example.stockcharts.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.SearchView;

import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stockcharts.R;
import com.example.stockcharts.data.listData;
import com.example.stockcharts.data.getData;
import com.example.stockcharts.data.listAdapter;


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

        ListView listView = (ListView)view.findViewById(R.id.listView);
        listAdapter adapter = new listAdapter(getContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listData item = (listData) adapter.getItem(i);
                MainActivity.navView.setSelectedItemId(R.id.navigation_charts);
                MainActivity.code = item.getCode();
            }
        });

        SearchView searchView = (SearchView)view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.clear();
                new getData(getContext(),s,adapter).execute(1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.clear();
                new getData(getContext(),s,adapter).execute(1);
                return false;
            }
        });



    }

}
