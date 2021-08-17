package com.example.autobot1.activities.landing.frags;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autobot1.activities.landing.viewmodels.SpecificShopViewModel;
import com.example.autobot1.adapters.ProductAdapter;
import com.example.autobot1.databinding.FragmentSpecificShopBinding;
import com.example.autobot1.models.ProductItem;

import java.util.List;

public class SpecificShopFragment extends Fragment {
    private FragmentSpecificShopBinding binding;
    private SpecificShopViewModel viewModel;

    private static final String NAME = "name";

    private String name;

    public SpecificShopFragment() {
        // Required empty public constructor
    }


    public static SpecificShopFragment newInstance(String name) {
        SpecificShopFragment fragment = new SpecificShopFragment();
        Bundle args = new Bundle();
        args.putString(NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(SpecificShopViewModel.class);
        if (getArguments() != null) {
            name = getArguments().getString(NAME);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSpecificShopBinding.inflate(inflater, container, false);
        MutableLiveData<List<ProductItem>> productItems = viewModel.getShopProducts(name);
        productItems.observe(getViewLifecycleOwner(),productItemList -> {
            ProductAdapter adapter = new ProductAdapter(productItemList);
            binding.shopRecycler.hasFixedSize();
            binding.shopRecycler.setClipToPadding(false);
            binding.shopRecycler.setClipToPadding(false);
            binding.shopRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
            binding.shopRecycler.setAdapter(adapter);
            adapter.setOnItemClickListener(position -> Toast.makeText(requireContext(), "Item on position "+productItemList.get(position)+" was clicked", Toast.LENGTH_SHORT).show());
        });

        return binding.getRoot();
    }
}