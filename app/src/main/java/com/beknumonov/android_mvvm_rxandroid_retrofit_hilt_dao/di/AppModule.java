package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.di;

import android.content.Context;

import androidx.room.Room;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.db.AppDatabase;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.db.UserDao;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.remote.MainApi;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.rx.AppSchedulerProvider;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.rx.SchedulerProvider;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.utils.ApiService;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.utils.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {


    @Singleton
    @Provides
    MainApi provideMainApi(@ApplicationContext Context context) {
        return ApiService.provideApi(MainApi.class, context);
    }


    @Singleton
    @Provides
    PreferenceManager providePreferenceManager(@ApplicationContext Context context) {
        return PreferenceManager.getInstance(context);
    }

    @Singleton
    @Provides
    UserDao provideDatabase(@ApplicationContext Context context) {
        AppDatabase appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "my_db").build();

        return appDatabase.userDao();
    }


    @Provides
    SchedulerProvider provideSchedulers() {
        return new AppSchedulerProvider();
    }


}
