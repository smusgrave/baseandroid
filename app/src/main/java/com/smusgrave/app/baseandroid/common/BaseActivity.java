package com.smusgrave.app.baseandroid.common;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.smusgrave.app.baseandroid.App;
import com.smusgrave.app.baseandroid.R;
import com.smusgrave.app.baseandroid.di.AppComponent;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity implements BasePresenter.View {

    private Toolbar toolbar;
    protected Fragment fragment;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(getLayout());
        injectDependencies();
        initializePresenter();
        injectViews();
        initializeToolbar();
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
    protected void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (getPresenter() != null) {
            getPresenter().onPause();
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
    protected void onDestroy() {
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
        super.onDestroy();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    private void initializeToolbar() {
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

    protected abstract void initializePresenter();

    private void injectViews() {
        ButterKnife.bind(this);
    }

    public abstract void setupComponent(AppComponent component);

    @Override
    public void showMessage(String message, boolean longer) {
        View view = ButterKnife.findById(this, R.id.coordinator_layout);
        if (view == null) {
            view = findViewById(android.R.id.content);
        }
        int duration = longer ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT;
        Snackbar.make(view, message, duration).show();
    }

    @Override
    public void showProgress(String message) {
        progressDialog = ProgressDialog.show(this, null, message, true);
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

}
