package com.smusgrave.app.baseandroid.ui.main;

import com.smusgrave.app.baseandroid.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    @PerFragment
    public MainFragmentPresenter providePresenter() {
        return new MainFragmentPresenter();
    }

}
