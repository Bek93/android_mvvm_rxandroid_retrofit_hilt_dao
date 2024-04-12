package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.rx;

import io.reactivex.rxjava3.core.Scheduler;

public interface SchedulerProvider {

    Scheduler io(); // background

    Scheduler ui(); // foreground
}
