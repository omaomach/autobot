package com.example.autobot1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autobot1.R;
import com.example.autobot1.models.ShopItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private final List<ShopItem> shopItems;

    public ShopAdapter(List<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ShopViewHolder holder, int position) {
        holder.bind(shopItems.get(position));
    }

    @Override
    public int getItemCount() {
        return shopItems.size();
    }

    static class ShopViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView location;
        private final TextView description;
        private final ImageView shopImage;
        public ShopViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.shop_title_text_view);
            location = itemView.findViewById(R.id.shop_location_text_view);
            description = itemView.findViewById(R.id.shop_description_text_view);
            shopImage = itemView.findViewById(R.id.shop_item_image_view);
        }
        public void bind(ShopItem shopItem){
            title.setText(shopItem.getTitle());
            location.setText(shopItem.getLocation());
            description.setText(shopItem.getDescription());
            Picasso.get().load(shopItem.getImageUrl()).placeholder(R.drawable.bot).into(shopImage);
        }
    }
}
