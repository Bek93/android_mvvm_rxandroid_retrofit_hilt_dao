package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.repository;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.base.BaseRepository;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.db.UserDao;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.model.User;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.navigator.MainNavigator;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.remote.MainApi;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.rx.SchedulerProvider;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.utils.PreferenceManager;

import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainRepository extends BaseRepository {

    private MainApi mainApi;
    private UserDao userDao;
    private PreferenceManager preferenceManager;

    @Inject
    public MainRepository(SchedulerProvider schedulerProvider, MainApi mainApi, PreferenceManager preferenceManager, UserDao userDao) {
        super(schedulerProvider);
        this.mainApi = mainApi;
        this.userDao = userDao;
        this.preferenceManager = preferenceManager;
    }

    public void login(User user, MutableLiveData<User> onLoggedIn, CompositeDisposable compositeDisposable, MainNavigator navigator) {
        Single<User> call = mainApi.login(user);
        navigator.showLoadingBar();
        call.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui()).subscribe(new SingleObserver<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(@NonNull User user) {
                onLoggedIn.setValue(user);

                userDao.insertAll(user).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui()).subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        Log.d("DB", "User is inserted");
                        navigator.hideLoadingBar();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (navigator != null)
                            navigator.hideLoadingBar();
                    }
                });

            }

            @Override
            public void onError(@NonNull Throwable e) {
                navigator.hideLoadingBar();
            }
        });

    }
}
