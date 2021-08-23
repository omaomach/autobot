package com.example.autobot1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autobot1.R;
import com.example.autobot1.adapters.ScheduleAdapter.ScheduleViewHolder;
import com.example.autobot1.databinding.ScheduleItemBinding;

import com.example.autobot1.models.ScheduleItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {
    private List<ScheduleItem> scheduleItemList;

    public ScheduleAdapter(List<ScheduleItem> scheduleItemList){
        this.scheduleItemList = scheduleItemList;
    }
    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ScheduleViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_item,
                        parent,
                        false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return scheduleItemList.size();
    }

    static class ScheduleViewHolder extends RecyclerView.ViewHolder{
        private ScheduleItemBinding binding;
        public ScheduleViewHolder(View itemView){
            super(itemView);
            binding = ScheduleItemBinding.bind(itemView);
        }
        protected void bind(ScheduleItem scheduleItem){
            binding.scheduleNameTv.setText(scheduleItem.getTitle());
            binding.scheduleLocationTv.setText(scheduleItem.getLocation());
            Picasso.get().load(scheduleItem.getImageUrl()).placeholder(R.drawable.account_circle).into(binding.scheduleImageView);
        }
    }
}
