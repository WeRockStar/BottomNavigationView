package com.werockstar.bottomnavigationview.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.werockstar.bottomnavigationview.R;
import com.werockstar.bottomnavigationview.fragment.AboutFragment;
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
        setSupportActionBar(toolbar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        changeFragment(new SettingFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        changeFragment(new HomeFragment());
                        break;
                    case R.id.menu_settings:
                        changeFragment(new SettingFragment());
                        break;
                    default:
                        changeFragment(new AboutFragment());
                }
                return true;
            }
        });
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentFragment, fragment)
                .commit();
    }
}
