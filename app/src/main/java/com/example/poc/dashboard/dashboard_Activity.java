package com.example.poc.dashboard;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.poc.R;

public class dashboard_Activity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private dashboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        adapter = new dashboardAdapter(getSupportFragmentManager());
        BottomNavigationView bottomNav = findViewById(R.id.btm_nav);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //add fragment
        adapter.Addfragment(new request_Fragment(),"Request");
        adapter.Addfragment(new progress_Fragment(),"In Progress");
        adapter.Addfragment(new complete_Fragment(),"Completed");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
//    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                    Fragment selectedFragment = null;
//
//                    switch (menuItem.getItemId()){
//                        case R.id.nav_request:
//                            selectedFragment = new request_Fragment();
//                            break;
//                        case R.id.nav_progress:
//                            selectedFragment = new progress_Fragment();
//                            break;
//                        case R.id.nav_completed:
//                            selectedFragment = new complete_Fragment();
//                            break;
//                    }
//
//                    getSupportFragmentManager().beginTransaction();
//                    return true;
//                }
//            };
}
