package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.di;


import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.db.UserDao;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.remote.MainApi;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.repository.MainRepository;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.rx.SchedulerProvider;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.utils.PreferenceManager;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@Module
@InstallIn(ViewModelComponent.class)
public class ViewModelModule {


    @Provides
    @ViewModelScoped
    MainRepository provideOnboardingRepository(SchedulerProvider schedulerProvider, MainApi mainApi, PreferenceManager preferenceManager, UserDao userDao) {
        return new MainRepository(schedulerProvider, mainApi, preferenceManager, userDao);
    }

}

