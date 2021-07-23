package com.example.autobot1.activities.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.autobot1.models.ProductItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private LiveData<List<ProductItem>> products;
    public MainViewModel(@NonNull Application application) {
        super(application);
        products = new MutableLiveData<>();
    }

    public List<ProductItem> getProducts(){
        List<ProductItem> productItems = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference("products")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull  DataSnapshot snapshot) {
                        for (DataSnapshot ds:snapshot.getChildren()){
                            ProductItem productItem = ds.getValue(ProductItem.class);
                            if (productItem!=null){
                                productItems.add(productItem);
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        return productItems;
    }
}
