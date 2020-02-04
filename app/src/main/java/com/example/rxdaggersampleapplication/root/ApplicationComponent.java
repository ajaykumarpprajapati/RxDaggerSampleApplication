package com.example.rxdaggersampleapplication.root;

import com.example.rxdaggersampleapplication.http.ApiModule;
import com.example.rxdaggersampleapplication.login.LoginActivity;
import com.example.rxdaggersampleapplication.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
//Which module need to connect
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    //Where to inject applicatiocomponent

    void inject(LoginActivity target);

}
