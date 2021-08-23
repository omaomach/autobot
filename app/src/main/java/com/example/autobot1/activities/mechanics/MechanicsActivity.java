package com.example.autobot1.activities.mechanics;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.autobot1.R;
import com.example.autobot1.activities.mechanics.frags.ScheduleFragment;
import com.example.autobot1.activities.mechanics.frags.BookingFragment;
import com.example.autobot1.activities.mechanics.frags.MechanicShopsFragment;
import com.example.autobot1.activities.mechanics.frags.NotificationsFragment;
import com.example.autobot1.activities.mechanics.models.FragComponent;
import com.example.autobot1.adapters.MechanicPageAdapter;
import com.example.autobot1.databinding.ActivityMechanicsBinding;
import com.google.android.material.tabs.TabLayout;

public class MechanicsActivity extends AppCompatActivity {
    private ActivityMechanicsBinding binding;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle saveInstanceBundle) {
        super.onCreate(saveInstanceBundle);
        binding = ActivityMechanicsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = binding.toolbar;
        viewPager = binding.mechanicsNavController;
        binding.tabLayout.setSelectedTabIndicatorColor(Color.GRAY);
        setUpAdapter();
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getId() == R.id.shop_tab) {
                    toolbar.setTitle("Shops");
                    binding.tabLayout.selectTab(tab);
                } else if (tab.getId() == R.id.notifications_tab) {
                    toolbar.setTitle("Notifications");
                    binding.tabLayout.selectTab(tab);
                } else if (tab.getId() == R.id.booking_tab) {
                    toolbar.setTitle("Booking");
                    binding.tabLayout.selectTab(tab);
                }else if (tab.getId()==R.id.schedule){
                    toolbar.setTitle("Schedules");
                    binding.tabLayout.selectTab(tab);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpAdapter() {
        MechanicPageAdapter adapter = new MechanicPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragComponent(new MechanicShopsFragment(), "Shops"));
        adapter.addFragment(new FragComponent(new NotificationsFragment(), "Notification"));
        adapter.addFragment(new FragComponent(new BookingFragment(), "Booking"));
        adapter.addFragment(new FragComponent(new ScheduleFragment(), "Schedules"));
        viewPager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(viewPager);
    }
}
