package com.example.autobot1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ScheduleItem implements Parcelable {
    private String title,location,imageUrl;

    public ScheduleItem(String title, String location, String imageUrl) {
        this.title = title;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    protected ScheduleItem(Parcel in) {
        title = in.readString();
        location = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<ScheduleItem> CREATOR = new Creator<ScheduleItem>() {
        @Override
        public ScheduleItem createFromParcel(Parcel in) {
            return new ScheduleItem(in);
        }

        @Override
        public ScheduleItem[] newArray(int size) {
            return new ScheduleItem[size];
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
        dest.writeString(imageUrl);
    }
}
