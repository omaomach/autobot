package com.example.autobot1.activities.landing.frags;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import com.example.autobot1.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

public class MapFragment extends Fragment {

    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    public static final String TAG = "Map fragment";
    FusedLocationProviderClient client;
    SupportMapFragment fragment;
    private String latitude;
    private String longitude;

    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance(String latitude, String longitude) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(LATITUDE, latitude);
        args.putString(LONGITUDE, longitude);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = LocationServices.getFusedLocationProviderClient(requireActivity());

        if (getArguments() != null) {
            latitude = getArguments().getString(LATITUDE);
            longitude = getArguments().getString(LONGITUDE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        fragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Task<Location> task = client.getLastLocation();
            task.addOnSuccessListener(location -> {
                if (location != null) {
                    fragment.getMapAsync(googleMap -> {
                        LatLng pos = new LatLng(location.getLatitude(), location.getLongitude());
                        Log.i(TAG, "onMapReady: lat:" + location.getLatitude() + " long:" + location.getLongitude());
                        MarkerOptions options = new MarkerOptions();
                        options.position(pos);
                        options.title("My position");
                        options.snippet("Iam here");
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 15));
                        googleMap.addMarker(options);
                    });
                }
            });
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 800);
        }
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            //todo: Logout will be handled here
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /***
     * @author jamie@fortnox we will handle the search queries here
     */
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.map_view_client_menu,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setQueryHint("Search by name or character...");
        searchView.setPadding(10,0,10,0);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            /***
             * @author jamie@fortnox Logout will be handled here
             */
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 800 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            @SuppressLint("MissingPermission") Task<Location> task = client.getLastLocation();
            task.addOnSuccessListener(location -> {
                if (location != null) {
                    fragment.getMapAsync(googleMap -> {
                        LatLng pos = new LatLng(location.getLatitude(), location.getLongitude());
                        Log.i(TAG, "onMapReady: lat:" + location.getLatitude() + " long:" + location.getLongitude());
                        MarkerOptions options = new MarkerOptions();
                        options.position(pos);
                        options.title("My position");
                        options.snippet("Iam here");
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 10));
                        googleMap.addMarker(options);
                    });
                }
            });
        }
    }
}