package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;


@HiltAndroidApp
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
