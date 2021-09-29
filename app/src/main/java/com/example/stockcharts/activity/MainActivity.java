package com.example.stockcharts.activity;

import android.os.Bundle;

import com.example.stockcharts.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    public static BottomNavigationView navView;
    public static String code = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        // Add bottom navigation menu listener
        navView = (BottomNavigationView)findViewById(R.id.bottommenu);
        navView.setOnItemSelectedListener(new BottomNav(fragmentManager));
        navView.setSelectedItemId(R.id.navigation_search);

    }

}