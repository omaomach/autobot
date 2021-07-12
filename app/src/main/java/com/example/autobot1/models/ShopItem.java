package com.example.autobot1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ShopItem implements Parcelable {
    private String title,location,distribution;

    public ShopItem(String title, String location, String distribution) {
        this.title = title;
        this.location = location;
        this.distribution = distribution;
    }

    protected ShopItem(Parcel in) {
        title = in.readString();
        location = in.readString();
        distribution = in.readString();
    }

    public static final Creator<ShopItem> CREATOR = new Creator<ShopItem>() {
        @Override
        public ShopItem createFromParcel(Parcel in) {
            return new ShopItem(in);
        }

        @Override
        public ShopItem[] newArray(int size) {
            return new ShopItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(location);
        dest.writeString(distribution);
    }
}
