package com.smusgrave.app.baseandroid.ui.main;

import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.R;
import com.smusgrave.app.baseandroid.common.BaseFragment;
import com.smusgrave.app.baseandroid.common.BasePresenter;

import javax.inject.Inject;

import butterknife.OnClick;

public class MainFragment extends BaseFragment implements MainFragmentPresenter.View {

    @Inject MainFragmentPresenter presenter;

    public static MainFragment newInstance() {
        return new MainFragment();
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
    protected void initializePresenter() {
        presenter.bindView(this);
    }

    @Override
    protected void setupComponent(AppComponent component) {
        DaggerMainComponent.builder()
                .appComponent(component)
                .mainModule(new MainModule())
                .build()
                .inject(this);
    }

    @OnClick(R.id.button)
    @Override
    public void doSomething() {
        presenter.workOnSomething();
    }
}
