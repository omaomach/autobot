package com.example.autobot1.activities.mechanics.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.autobot1.activities.mechanics.models.Bookings;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookingsViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Bookings>> bookings;
    private static final String TAG = "BookingsViewModel";
    public BookingsViewModel(Application application){
        super(application);
        bookings = new MutableLiveData<List<Bookings>>();
    }
    public LiveData<List<Bookings>> getMechanicBookings(String uid){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("mechanics/"+uid+"/bookings");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Bookings> b = new ArrayList<>();
                for (DataSnapshot ds:snapshot.getChildren()){
                    Bookings booking = ds.getValue(Bookings.class);
                    b.add(booking);
                    bookings.postValue(b);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i(TAG, "onCancelled: getMechanicBookings -> "+error.getMessage());
            }
        });
        return bookings;
    }
    public LiveData<List<Bookings>> getClientsBookings(String uid){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("clients/"+uid+"/bookings");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Bookings> b = new ArrayList<>();
                for (DataSnapshot ds:snapshot.getChildren()){
                    Bookings booking = ds.getValue(Bookings.class);
                    b.add(booking);
                    bookings.postValue(b);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i(TAG, "onCancelled: getMechanicBookings -> "+error.getMessage());
            }
        });
        return bookings;
    }
}
