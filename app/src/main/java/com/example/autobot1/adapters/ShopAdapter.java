package com.example.autobot1.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autobot1.models.ShopItem;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private List<ShopItem> shopItems;

    public ShopAdapter(List<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ShopViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return shopItems.size();
    }

    static class ShopViewHolder extends RecyclerView.ViewHolder {
        public ShopViewHolder(View itemView) {
            super(itemView);
        }
    }
}
