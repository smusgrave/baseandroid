package com.smusgrave.app.baseandroid;

import android.content.Context;
import android.content.SharedPreferences;

import com.smusgrave.app.baseandroid.scope.PerApp;

import dagger.Component;

@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getContext();

    SharedPreferences getSharedPreferences();

}
