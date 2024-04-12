package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.base;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.rx.SchedulerProvider;

public abstract class BaseRepository {


    public SchedulerProvider schedulerProvider;

    public BaseRepository(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }
}
