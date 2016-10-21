package com.werockstar.bottomnavigationview.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.werockstar.bottomnavigationview.R;
import com.werockstar.bottomnavigationview.fragment.HomeFragment;
import com.werockstar.bottomnavigationview.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        setSupportActionBar(toolbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFragment, new HomeFragment())
                                .commit();
                        break;
                    case R.id.menu_settings:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFragment, new SettingFragment())
                                .commit();
                        break;
                }
                return false;
            }
        });
    }
}
