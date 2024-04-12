package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.R;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.base.BaseActivity;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.databinding.ActivityMainBinding;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.model.User;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.navigator.MainNavigator;
import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.vm.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    @Override
    protected ActivityMainBinding inflateView(LayoutInflater inflater) {
        return ActivityMainBinding.inflate(inflater);
    }

    @Override
    protected MainViewModel getViewModel() {
        return new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewModel.login();
            }
        });

        viewModel.onUserLoggedIn.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Toast.makeText(MainActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
            }
        });
    }

}