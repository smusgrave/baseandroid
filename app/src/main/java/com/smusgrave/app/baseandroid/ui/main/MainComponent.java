package com.smusgrave.app.baseandroid.ui.main;

import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.scope.PerFragment;

import dagger.Component;

@PerFragment
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {

    void inject(MainFragment mainFragment);

    MainPresenterImpl getPresenter();

}
