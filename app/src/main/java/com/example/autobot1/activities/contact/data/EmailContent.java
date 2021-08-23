package com.example.autobot1.activities.contact.data;

import android.os.Parcel;
import android.os.Parcelable;

public class EmailContent implements Parcelable {
    private String emailAddress, subject, description;

    public EmailContent(String emailAddress, String subject, String description) {
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.description = description;
    }

    protected EmailContent(Parcel in) {
        emailAddress = in.readString();
        subject = in.readString();
        description = in.readString();
    }

    public static final Creator<EmailContent> CREATOR = new Creator<EmailContent>() {
        @Override
        public EmailContent createFromParcel(Parcel in) {
            return new EmailContent(in);
        }

        @Override
        public EmailContent[] newArray(int size) {
            return new EmailContent[size];
        }
    };

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(emailAddress);
        dest.writeString(subject);
        dest.writeString(description);
    }
}
