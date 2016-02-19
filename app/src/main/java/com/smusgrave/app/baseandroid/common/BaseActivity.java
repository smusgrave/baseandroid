package com.smusgrave.app.baseandroid.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smusgrave.app.baseandroid.App;
import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.R;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    protected Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(getLayout());
        injectDependencies();
        injectViews();
        setupToolbar();
    }

    protected void setupFragment(String tag) {
        if (findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment, tag)
                    .commit();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();

        if (getPresenter() != null) {
            getPresenter().onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    private void setupToolbar() {
        toolbar = ButterKnife.findById(this, R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    protected abstract int getLayout();

    protected abstract BasePresenter getPresenter();

    private void injectDependencies() {
        setupComponent(App.getApp(this).getComponent());
    }

    private void injectViews() {
        ButterKnife.bind(this);
    }

    public abstract void setupComponent(AppComponent appComponent);

}
