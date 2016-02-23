package com.smusgrave.app.baseandroid.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.smusgrave.app.baseandroid.R;
import com.smusgrave.app.baseandroid.common.BaseActivity;
import com.smusgrave.app.baseandroid.common.BasePresenter;
import com.smusgrave.app.baseandroid.di.AppComponent;

import javax.inject.Inject;

import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainActivityPresenter.View {

    @Inject MainActivityPresenter presenter;

    private static final String FRAGMENT_TAG = "main_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = MainFragment.newInstance();
        setupFragment(FRAGMENT_TAG);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void initializePresenter() {
        presenter.setView(this);
    }

    @Override
    public void setupComponent(AppComponent component) {
        DaggerMainComponent.builder()
                .appComponent(component)
                .mainModule(new MainModule())
                .build()
                .inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    @Override
    public void onFabClick() {
        presenter.onFabClicked();
    }
}
