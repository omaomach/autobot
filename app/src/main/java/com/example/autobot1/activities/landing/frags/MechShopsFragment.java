package com.example.autobot1.activities.landing.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.autobot1.R;

import com.example.autobot1.activities.landing.viewmodels.MechShopsViewModel;
import com.example.autobot1.adapters.ShopAdapter;
import com.example.autobot1.databinding.FragmentMechanicShopsBinding;
import com.example.autobot1.models.ShopItem;

import java.util.List;


public class MechShopsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView shopsRecycler;
    private FragmentMechanicShopsBinding binding;
    private MechShopsViewModel viewModel;

    public MechShopsFragment() {
        // Required empty public constructor
    }

    public static MechShopsFragment newInstance(String param1, String param2) {
        MechShopsFragment fragment = new MechShopsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MechShopsViewModel.class);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMechanicShopsBinding.inflate(inflater, container, false);
        MutableLiveData<List<ShopItem>> shops = viewModel.getShops();
        shops.observe(getViewLifecycleOwner(), shopItems -> {
            if (shopItems.isEmpty()) {
                binding.emptyTrayIv.setVisibility(View.VISIBLE);
                binding.emptyTrayTv.setVisibility(View.VISIBLE);
                binding.shopsRecycler.setVisibility(View.INVISIBLE);
            } else {
                shopsRecycler = binding.shopsRecycler;
                ShopAdapter shopAdapter = new ShopAdapter(shopItems);
                shopsRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));
                shopsRecycler.setClipToPadding(false);
                shopsRecycler.hasFixedSize();
                shopsRecycler.setAdapter(shopAdapter);
                shopAdapter.setOnItemClickListener(new ShopAdapter.OnItemClick() {
                    @Override
                    public void onItemClick(int position) {
                        requireActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.nav_host_fragment_container,
                                        SpecifShopFragment.newInstance(shopItems.get(position).getTitle()));
                    }
                });
            }
        });

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        requireActivity().getMenuInflater().inflate(R.menu.mechanic_shop_menu, menu);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}