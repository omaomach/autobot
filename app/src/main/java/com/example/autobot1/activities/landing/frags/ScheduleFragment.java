package com.example.autobot1.activities.landing.frags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.autobot1.R;
import com.example.autobot1.adapters.ScheduleAdapter;
import com.example.autobot1.databinding.FragmentScheduleBinding;
import com.example.autobot1.models.ScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {
    private FragmentScheduleBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
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
        binding = FragmentScheduleBinding.inflate(inflater,container,false);
        List<ScheduleItem> scheduleItems = new ArrayList<>();
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        scheduleItems.add(new ScheduleItem("Schedule 1","Haile selassie ave",String.valueOf(R.drawable.auto1)));
        ScheduleAdapter adapter = new ScheduleAdapter(scheduleItems);
        binding.lvShedules.setAdapter(adapter);
        binding.lvShedules.setClipToPadding(false);
        binding.lvShedules.hasFixedSize();
        binding.lvShedules.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false));
        return binding.getRoot();
    }

    //todo: add functionality to return to maps Fragment
}