package com.example.autobot1.activities.mechanics.frags;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.autobot1.R;
import com.example.autobot1.activities.mechanics.models.Bookings;
import com.example.autobot1.activities.mechanics.viewmodels.BookingsViewModel;
import com.example.autobot1.adapters.BookingsAdapter;
import com.example.autobot1.databinding.FragmentBookingBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class BookingFragment extends Fragment {
    private FragmentBookingBinding binding;
    private BookingsViewModel bookingsViewModel;
    private BookingsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookingsViewModel = new ViewModelProvider(requireActivity()).get(BookingsViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBookingBinding.inflate(inflater, container, false);
        inflateList();
        getBookings().observe(getViewLifecycleOwner(), bookings -> adapter.notifyDataSetChanged());
        binding.meetUpTimeEt.setOnFocusChangeListener(((v, hasFocus) -> {
            if (v.getId() == R.id.meet_up_time_et) {
                showDialog((TextView) v);
            }
        }));
        binding.pickUpTimeEt.setOnFocusChangeListener(((v, hasFocus) -> {
            if (v.getId() == R.id.pick_up_time_et) {
                showDialog((TextView) v);
            }
        }));
        return binding.getRoot();
    }

    private void inflateList() {
        ListView listView = binding.lvSchedules;
        int resource = R.layout.booking_item;
        List<Bookings> bookings = getBookings().getValue();
        if (bookings != null) {
            adapter = new BookingsAdapter(requireContext(), resource, bookings);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else {
            Snackbar.make(binding.lvSchedules,"No bookings yet",Snackbar.LENGTH_LONG).show();
        }
    }

    private LiveData<List<Bookings>> getBookings() {
        return bookingsViewModel.getMechanicBookings(FirebaseAuth.getInstance().getUid());
    }

    private void showDialog(TextView tv) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(requireContext(), (view, hourOfDay, minute) -> {
            String time = String.format(Locale.getDefault(), "%d : %d", hourOfDay, minute);
            tv.setText(time);
        }, Calendar.HOUR_OF_DAY, Calendar.MINUTE, true);
        timePickerDialog.create();
        timePickerDialog.show();
    }
}