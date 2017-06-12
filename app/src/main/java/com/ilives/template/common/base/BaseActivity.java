package com.ilives.template.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ilives.template.Application;
import com.ilives.template.common.view.DialogMessage;
import com.ilives.template.common.view.LoadingView;

/**
 * Copyright © 2016 Neo-Lab Co.,Ltd.
 * Created by VuLT on 24/10/2016.
 */
public class BaseActivity extends AppCompatActivity implements IBaseActivity {

    private LoadingView mLoading;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mLoading = new LoadingView(this);
        Application.getAppInstance().setSharedPreferences(this);
    }

    @Override
    public DialogMessage showDialogSuccess(String msg) {
        DialogMessage dialogMessage = new DialogMessage(this, msg);
        dialogMessage.show();
        return dialogMessage;
    }

    @Override
    public void forceDismissLoading() {
        this.mLoading.forceDismiss();
    }

    @Override
    public DialogMessage showDialogError(String msg) {
        DialogMessage dialogMessage = new DialogMessage(this, msg);
        dialogMessage.show();
        return dialogMessage;
    }

    @Override
    public void dismissLoading() {
        this.mLoading.dismiss();
    }

    @Override
    public void showLoading() {
        this.mLoading.show();
    }

    @Override
    public void showDialogPermission(String msg) {
        showDialogSuccess(msg);
    }
}
