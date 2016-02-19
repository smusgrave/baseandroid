package com.smusgrave.app.baseandroid.ui.fragment;

import android.os.Bundle;

import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.R;
import com.smusgrave.app.baseandroid.common.BaseFragment;
import com.smusgrave.app.baseandroid.common.BasePresenter;
import com.smusgrave.app.baseandroid.component.DaggerMainComponent;
import com.smusgrave.app.baseandroid.module.MainModule;
import com.smusgrave.app.baseandroid.presenter.MainPresenter;
import com.smusgrave.app.baseandroid.ui.view.MainView;

import javax.inject.Inject;

public class MainFragment extends BaseFragment implements MainView {

    @Inject
    MainPresenter presenter;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void setUpComponent(AppComponent component) {
        DaggerMainComponent.builder()
                .appComponent(component)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

}
