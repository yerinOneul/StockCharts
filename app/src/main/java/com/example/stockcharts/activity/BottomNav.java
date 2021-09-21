package com.example.stockcharts.activity;

import android.view.MenuItem;

import androidx.fragment.app.FragmentManager;

import com.example.stockcharts.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNav implements BottomNavigationView.OnItemSelectedListener{
    private FragmentManager fm;

    public BottomNav(FragmentManager fragmentManager){
        fm = fragmentManager;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navigation_search:
                fm.beginTransaction().replace(R.id.container, new SearchFragment()).commit();

                return true;

            case R.id.navigation_charts:
                fm.beginTransaction().replace(R.id.container, new ChartsFragment()).commit();
                return true;

        }
        return false;

    }

}

