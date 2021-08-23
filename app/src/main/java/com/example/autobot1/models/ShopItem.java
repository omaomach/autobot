package com.example.autobot1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ShopItem implements Parcelable {
    private String title,location, description,imageUrl;

    public ShopItem(String title, String location, String description,String imageUrl) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    protected ShopItem(Parcel in) {
        title = in.readString();
        location = in.readString();
        description = in.readString();
        imageUrl = in.readString();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(location);
        dest.writeString(description);
        dest.writeString(imageUrl);
    }
}
