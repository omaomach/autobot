package com.example.autobot1.activities.mechanics.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.autobot1.databinding.FragmentNotificationBinding;

public class NotificationsFragment extends Fragment {
    private FragmentNotificationBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}