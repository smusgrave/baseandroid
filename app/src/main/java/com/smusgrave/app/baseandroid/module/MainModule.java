package com.smusgrave.app.baseandroid.module;

import com.smusgrave.app.baseandroid.presenter.MainPresenter;
import com.smusgrave.app.baseandroid.ui.view.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    public MainView provideView() {
        return view;
    }

    @Provides
    public MainPresenter providePresenter(MainView view) {
        return new MainPresenter(view);
    }

}
