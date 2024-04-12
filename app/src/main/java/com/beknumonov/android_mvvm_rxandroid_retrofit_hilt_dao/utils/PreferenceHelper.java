package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.utils;

public interface PreferenceHelper {

    void setValue(String key, Object value);

    <T> Object getValue(Class<T> aClass, String key, Object defaultValue);

    void removeKey(String key);

    void clear();

}
