package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import androidx.annotation.NonNull;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.R;

public class LoadingBarDialog extends Dialog {

    public LoadingBarDialog(@NonNull Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.loading_bar);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}
