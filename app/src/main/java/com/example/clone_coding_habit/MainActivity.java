package com.example.clone_coding_habit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.clone_coding_habit.fragment.HomeFragment;
import com.example.clone_coding_habit.fragment.RecordFragment;
import com.example.clone_coding_habit.fragment.SearchFragment;
import com.example.clone_coding_habit.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().add(R.id.linearLayout, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()) {
                    case R.id.page_home:
                        transaction.replace(R.id.linearLayout, new HomeFragment()).commitAllowingStateLoss();
                        break;
                    case R.id.page_calender:
                        transaction.replace(R.id.linearLayout, new RecordFragment()).commitAllowingStateLoss();
                        break;
                    case R.id.page_search:
                        transaction.replace(R.id.linearLayout, new SearchFragment()).commitAllowingStateLoss();
                        break;
                    case R.id.page_setting:
                        transaction.replace(R.id.linearLayout, new SettingFragment()).commitAllowingStateLoss();
                        break;
                }

                return true;
            }
        });
    }
}