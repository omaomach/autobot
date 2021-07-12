package com.example.autobot1.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.autobot1.R;
import com.example.autobot1.activities.fragments.MechanicShopsFragment;
import com.example.autobot1.activities.fragments.ScheduleFragment;
import com.example.autobot1.activities.fragments.SpecificShopFragment;
import com.google.android.material.navigation.NavigationView;

public class MapActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected ActionBarDrawerToggle actionBarDrawerToggle;
    protected DrawerLayout drawerLayout;
    protected Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_map);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout,new MapFragment())
                .commit();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_opened, R.string.drawer_closed);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.recent) {
            inflateFragContainer(new MechanicShopsFragment());
        }else if (item.getItemId() == R.id.schedule) {
            inflateFragContainer(new ScheduleFragment());
        }else if (item.getItemId() == R.id.favorites) {
            inflateFragContainer(new MechanicShopsFragment());
        }else if (item.getItemId()==R.id.shop_parts){
            inflateFragContainer(new SpecificShopFragment());
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void inflateFragContainer(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,
                        fragment)
                .commit();
    }
}