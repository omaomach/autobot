package com.example.autobot1.models;

public class User {
    private String name,email,accountTYpe;

    public User(String name, String email, String accountTYpe) {
        this.name = name;
        this.email = email;
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

    public String getAccountTYpe() {
        return accountTYpe;
    }

    public void setAccountTYpe(String accountTYpe) {
        this.accountTYpe = accountTYpe;
    }
}
