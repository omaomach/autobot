package com.example.autobot1.activities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.autobot1.R;
import com.example.autobot1.adapters.ShopAdapter;
import com.example.autobot1.models.ShopItem;

import java.util.ArrayList;
import java.util.List;


public class MechanicShopsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView shopsRecycler;

    public MechanicShopsFragment() {
        // Required empty public constructor
    }

    public static MechanicShopsFragment newInstance(String param1, String param2) {
        MechanicShopsFragment fragment = new MechanicShopsFragment();
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
        View view = getLayoutInflater().inflate(R.layout.shop_item,container,false);
        ArrayList<ShopItem> shops = new ArrayList<>();
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shops.add(new ShopItem("Title","Haile Selassie ave","Description about the is found here and all the info about the shop is all there",String.valueOf(R.drawable.bot)));
        shopsRecycler = view.findViewById(R.id.shop_recycler);
        ShopAdapter shopAdapter = new ShopAdapter(shops);
        shopsRecycler.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));
        shopsRecycler.setClipToPadding(false);
        shopsRecycler.hasFixedSize();
        shopsRecycler.setAdapter(shopAdapter);
        return view;
    }
}