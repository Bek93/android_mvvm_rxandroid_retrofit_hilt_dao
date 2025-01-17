package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.BuildConfig;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.model.User;
import com.google.gson.Gson;


public class PreferenceManager implements PreferenceHelper {

    private static String SHARED_PREFERENCE_NAME = BuildConfig.APPLICATION_ID + ".local";

    private SharedPreferences mPreference;

    private static PreferenceManager mInstance;

    public PreferenceManager(Context context) {
        mPreference = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static PreferenceManager getInstance(Context context) {
        if (mInstance == null)
            mInstance = new PreferenceManager(context);

        return mInstance;
    }


    @Override
    public void setValue(String key, Object value) {

        if (value.getClass().equals(String.class)) {
            mPreference.edit().putString(key, (String) value).apply();
        } else if (value.getClass().equals(Boolean.class)) {
            mPreference.edit().putBoolean(key, (Boolean) value).apply();
        } else if (value.getClass().equals(User.class)) {
            String json = new Gson().toJson(value);
            setValue(key, json);
        }
    }

    @Override
    public <T> Object getValue(Class<T> aClass, String key, Object defaultValue) {
        if (aClass.equals(String.class)) {
            return mPreference.getString(key, (String) defaultValue);
        } else if (aClass.equals(Boolean.class)) {
            return mPreference.getBoolean(key, (Boolean) defaultValue);
        } else if (aClass.equals(User.class)) {
            String json = mPreference.getString(key, "");
            if (!json.isEmpty()) {
                return new Gson().fromJson(json, User.class);
            }
        }
        return defaultValue;
    }

    @Override
    public void removeKey(String key) {
        mPreference.edit().remove(key).apply();
    }

    @Override
    public void clear() {
        mPreference.edit().clear().apply();
    }
}
