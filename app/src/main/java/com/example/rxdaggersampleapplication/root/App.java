package com.example.rxdaggersampleapplication.root;

import android.app.Application;

import com.example.rxdaggersampleapplication.http.ApiModule;
import com.example.rxdaggersampleapplication.login.LoginModel;
import com.example.rxdaggersampleapplication.login.LoginModule;

import dagger.android.DaggerApplication;

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
