package com.example.autobot1.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autobot1.R;
import com.example.autobot1.adapters.ProductAdapter;
import com.example.autobot1.databinding.FragmentSpecificShopBinding;
import com.example.autobot1.models.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class SpecificShopFragment extends Fragment {
    private FragmentSpecificShopBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SpecificShopFragment() {
        // Required empty public constructor
    }


    public static SpecificShopFragment newInstance(String param1, String param2) {
        SpecificShopFragment fragment = new SpecificShopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSpecificShopBinding.inflate(inflater, container, false);
        List<ProductItem> productItems = new ArrayList<>();
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", "https://variety.com/wp-content/uploads/2021/06/Rick-and-Morty-Merch.jpg"));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        productItems.add(new ProductItem("Title", "Description", "1500", String.valueOf(R.drawable.bot1)));
        ProductAdapter adapter = new ProductAdapter(productItems);
        binding.shopRecycler.hasFixedSize();
        binding.shopRecycler.setClipToPadding(false);
        binding.shopRecycler.setClipToPadding(false);
        binding.shopRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.shopRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new ProductAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(requireContext(), "Item on position "+productItems.get(position)+" was clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return binding.getRoot();
    }
}