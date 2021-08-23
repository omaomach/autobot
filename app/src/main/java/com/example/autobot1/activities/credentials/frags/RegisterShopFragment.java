package com.example.autobot1.activities.credentials.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.autobot1.databinding.FragmentRegisterShopBinding;

public class RegisterShopFragment extends Fragment {
    private FragmentRegisterShopBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegisterShopBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
