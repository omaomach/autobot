package com.example.autobot1.activities.landing.viewmodels;

import android.app.Application;

import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.autobot1.models.ShopItem;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MechShopsViewModel extends AndroidViewModel {
    ArrayList<ShopItem> shops;
    MutableLiveData<List<ShopItem>> mShops;

    public MechShopsViewModel(Application application) {
        super(application);
        shops = new ArrayList<>();
        mShops = new MutableLiveData<>();
    }

    public MutableLiveData<List<ShopItem>> getShops() {
        FirebaseFirestore.getInstance().collection("shops")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        assert value != null;
                        if (value.isEmpty()) {
                            shops.add(null);
                        } else {
                            for (DocumentSnapshot qs : value.getDocuments()) {
                                ShopItem item = qs.toObject(ShopItem.class);
                                shops.add(item);
                            }
                        }

                    }
                });
        mShops.setValue(shops);
        return mShops;
    }

}
