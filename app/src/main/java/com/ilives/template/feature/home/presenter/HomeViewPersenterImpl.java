package com.ilives.template.feature.home.presenter;

import android.content.Context;

import com.ilives.template.feature.home.view.HomeView;

/**
 * Copyright © 2016 Neo-Lab Co.,Ltd.
 * Created by VuLT on 24/10/2016.
 */

public class HomeViewPersenterImpl implements HomeViewPresenter {
    private Context mContext;
    private HomeView mView;

    public HomeViewPersenterImpl(Context context, HomeView view) {
        this.mContext = context;
        this.mView = view;
    }
}
