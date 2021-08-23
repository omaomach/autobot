package com.example.autobot1.activities.landing.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.autobot1.models.ProductItem;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class SpecifShopViewModel extends AndroidViewModel {
    private List<ProductItem> productItems;
    private MutableLiveData<List<ProductItem>> mutableProducts;

    public SpecifShopViewModel(Application application) {
        super(application);
        productItems = new ArrayList<>();
        mutableProducts = new MutableLiveData<>();
    }

    public MutableLiveData<List<ProductItem>> getShopProducts(String name) {
        FirebaseFirestore.getInstance().collection("shops/" + name + "/products")
                .addSnapshotListener((value, error) -> {
                    for (DocumentSnapshot ds : value.getDocuments()) {
                        ProductItem item = ds.toObject(ProductItem.class);
                        productItems.add(item);
                    }
                });
        mutableProducts.postValue(productItems);
        return mutableProducts;
    }

}
