package com.example.autobot1.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.autobot1.activities.mechanics.models.FragComponent;

import java.util.ArrayList;
import java.util.List;

public class MechanicPageAdapter extends FragmentPagerAdapter {

    private final List<FragComponent> fragmentsList = new ArrayList<>();

    public MechanicPageAdapter(FragmentManager supportFragmentManager){
        super(supportFragmentManager);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsList.get(position).getTitle();
    }

    public void addFragment(FragComponent component){
        fragmentsList.add(component);
    }
}
