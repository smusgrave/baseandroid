package com.smusgrave.app.baseandroid.ui.main;

import com.smusgrave.app.baseandroid.di.AppComponent;
import com.smusgrave.app.baseandroid.di.scope.PerFeature;

import dagger.Component;

@PerFeature
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {

    void inject(MainActivity mainActivity);

    void inject(MainFragment mainFragment);

}
