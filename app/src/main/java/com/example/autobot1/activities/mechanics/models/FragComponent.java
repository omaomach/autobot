package com.example.autobot1.activities.mechanics.models;

import androidx.fragment.app.Fragment;

public class FragComponent {
    private Fragment fragment;
    private String title;

    public FragComponent(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
