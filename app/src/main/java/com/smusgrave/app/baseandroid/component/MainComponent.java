package com.smusgrave.app.baseandroid.component;

import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.module.MainModule;
import com.smusgrave.app.baseandroid.presenter.MainPresenter;
import com.smusgrave.app.baseandroid.scope.PerFragment;
import com.smusgrave.app.baseandroid.ui.fragment.MainFragment;

import dagger.Component;

@PerFragment
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {

    void inject(MainFragment mainFragment);

    MainPresenter getPresenter();

}
