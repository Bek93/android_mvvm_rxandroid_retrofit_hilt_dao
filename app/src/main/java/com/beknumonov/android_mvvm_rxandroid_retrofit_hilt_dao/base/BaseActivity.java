package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.utils.LoadingBarDialog;

public abstract class BaseActivity<VB extends ViewBinding, VM extends BaseViewModel> extends AppCompatActivity implements BaseNavigator {

    public VB binding;
    public VM viewModel;

    protected abstract VB inflateView(LayoutInflater inflater);

    protected abstract VM getViewModel();

    private LoadingBarDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflateView(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = getViewModel();
        dialog=new LoadingBarDialog(this);
    }

    @Override
    public void showLoadingBar() {
        if (!dialog.isShowing())
            dialog.show();
    }

    @Override
    public void hideLoadingBar() {
        dialog.hide();
    }
}
