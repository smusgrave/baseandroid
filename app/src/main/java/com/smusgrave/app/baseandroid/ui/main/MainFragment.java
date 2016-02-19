package com.smusgrave.app.baseandroid.ui.main;

import android.os.Bundle;

import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.R;
import com.smusgrave.app.baseandroid.common.BaseFragment;
import com.smusgrave.app.baseandroid.common.BasePresenter;

import javax.inject.Inject;

import butterknife.OnClick;

public class MainFragment extends BaseFragment implements MainView {

    @Inject
    MainPresenterImpl presenter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
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

    @Override
    protected void bindView() {
        presenter.bindView(this);
    }

    @OnClick(R.id.button)
    void buttonClick() {
        presenter.handleButtonClick();
    }

}
