package com.smusgrave.app.baseandroid.common;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.smusgrave.app.baseandroid.App;
import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.R;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Toolbar toolbar;
    protected Fragment fragment;
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(getLayout());
        injectDependencies();
        bindToPresenter();
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

    @SuppressWarnings("unchecked")
    private void bindToPresenter() {
        if (getPresenter() != null) {
            getPresenter().bindView(this);
        }
    }

    private void injectViews() {
        ButterKnife.bind(this);
    }

    public abstract void setupComponent(AppComponent appComponent);

    @Override
    public void showMessage(String message, boolean longer) {
        View rootView = this.findViewById(android.R.id.content).getRootView();
        int duration = longer ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT;
        Snackbar.make(rootView, message, duration).show();
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
