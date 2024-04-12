package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.base.BaseViewModel;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.model.User;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.navigator.MainNavigator;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.repository.MainRepository;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.rx.SchedulerProvider;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends BaseViewModel<MainNavigator> {

    private MainRepository mainRepository;

    public MutableLiveData<User> onUserLoggedIn = new MutableLiveData<>();

    @Inject
    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }


    public void login() {
        User user = new User("test@gmail.com", "12341234");

        mainRepository.login(user, onUserLoggedIn, compositeDisposable, getNavigator());

    }


}
