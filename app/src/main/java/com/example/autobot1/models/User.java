package com.example.autobot1.models;

public class User {
    private String uid,name,email,imageUrl,phoneNo,accountTYpe;

    public User(String uid,String name, String email,String imageUrl,String phoneNo, String accountTYpe) {
        this.uid=uid;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.phoneNo = phoneNo;
        this.accountTYpe = accountTYpe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAccountTYpe() {
        return accountTYpe;
    }

    public void setAccountTYpe(String accountTYpe) {
        this.accountTYpe = accountTYpe;
    }
}
