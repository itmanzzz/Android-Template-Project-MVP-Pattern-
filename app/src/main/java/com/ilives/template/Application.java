package com.ilives.template;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDexApplication;

import com.ilives.template.api.HttpsTrustManager;
import com.ilives.template.api.RestAPI;
import com.ilives.template.feature.login.view.LoginActivity;

/**
 * Copyright © 2016 Neo-Lab Co.,Ltd.
 * Created by VuLT on 24/10/2016.
 */
public class Application extends MultiDexApplication {

    private static Application mApp;

    SharedPreferences sharedPreferences;

    public static Application getAppInstance(){
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        HttpsTrustManager.allowAllSSL();
        RestAPI.init(getApplicationContext());
        RestAPI.setClazzInvalidToken(LoginActivity.class);
    }

    public void setSharedPreferences(Context context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public SharedPreferences getSharedPreferences(){
        return sharedPreferences;
    }
}
