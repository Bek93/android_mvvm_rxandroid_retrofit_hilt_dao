package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
