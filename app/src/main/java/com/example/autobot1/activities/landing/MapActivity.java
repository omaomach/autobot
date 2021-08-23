package com.example.autobot1.activities.landing;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.autobot1.R;
import com.example.autobot1.activities.landing.frags.MapMyFragment;
import com.example.autobot1.activities.landing.frags.MechShopsFragment;
import com.example.autobot1.activities.landing.frags.SchedFragment;
import com.example.autobot1.activities.landing.frags.SpecifShopFragment;
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
                .add(R.id.frame_layout,new MapMyFragment())
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
            inflateFragContainer(new MechShopsFragment());
        }else if (item.getItemId() == R.id.schedule) {
            inflateFragContainer(new SchedFragment());
        }else if (item.getItemId() == R.id.favorites) {
            inflateFragContainer(new MechShopsFragment());
        }else if (item.getItemId()==R.id.shop_parts){
            inflateFragContainer(new SpecifShopFragment());
        }else if (item.getItemId()==R.id.map){
            inflateFragContainer(new MapMyFragment());
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