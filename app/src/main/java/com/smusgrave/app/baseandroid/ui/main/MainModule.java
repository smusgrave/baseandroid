package com.smusgrave.app.baseandroid.ui.main;

import com.smusgrave.app.baseandroid.di.scope.PerFeature;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    @PerFeature
    public MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenter();
    }

    @Provides
    @PerFeature
    public MainFragmentPresenter provideMainFragmentPresenter() {
        return new MainFragmentPresenter();
    }

}
