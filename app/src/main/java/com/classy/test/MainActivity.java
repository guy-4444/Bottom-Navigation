package com.classy.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.classy.test.ui.dashboard.DashboardFragment;
import com.classy.test.ui.home.HomeFragment;
import com.classy.test.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    DashboardFragment dashboardFragment;
    HomeFragment homeFragment;
    NotificationsFragment notificationsFragment;
    Fragment activeFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initBottomBar();
    }

    private void initBottomBar() {
        BottomNavigationView navView = findViewById(R.id.nav_view);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        dashboardFragment = new DashboardFragment();
        notificationsFragment = new NotificationsFragment();
        activeFragment = homeFragment;
        updateTile(R.id.navigation_dashboard);

        fragmentManager.beginTransaction().add(R.id.nav_host_fragment, notificationsFragment, "3").hide(notificationsFragment).commit();
        fragmentManager.beginTransaction().add(R.id.nav_host_fragment, dashboardFragment, "2").hide(dashboardFragment).commit();
        fragmentManager.beginTransaction().add(R.id.nav_host_fragment,homeFragment, "1").commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
                        activeFragment = homeFragment;
                        updateTile(item.getItemId());
                        return true;
                    case R.id.navigation_dashboard:
                        fragmentManager.beginTransaction().hide(activeFragment).show(dashboardFragment).commit();
                        activeFragment = dashboardFragment;
                        updateTile(item.getItemId());
                        return true;
                    case R.id.navigation_notifications:
                        fragmentManager.beginTransaction().hide(activeFragment).show(notificationsFragment).commit();
                        activeFragment = notificationsFragment;
                        updateTile(item.getItemId());
                        return true;
                }
                return false;
            }
        });
    }

    private void updateTile(int id) {
        if (id == R.id.navigation_dashboard) {
            getSupportActionBar().setTitle(R.string.title_dashboard);
        }
        else if (id == R.id.navigation_home) {
            getSupportActionBar().setTitle(R.string.title_home);
        }
        else if (id == R.id.navigation_notifications) {
            getSupportActionBar().setTitle(R.string.title_notifications);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            openSettingsPage();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openSettingsPage() {
        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
    }

}