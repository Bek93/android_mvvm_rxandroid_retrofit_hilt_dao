package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    private int id;
    private String email;
    private String password;

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
