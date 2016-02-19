package com.smusgrave.app.baseandroid.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smusgrave.app.baseandroid.App;
import com.smusgrave.app.baseandroid.AppComponent;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseFragment extends Fragment implements BaseView {

    protected Context context;
    protected View view;
    protected ProgressDialog progressDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getFragmentLayout(), container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbindViews();
    }

    protected abstract int getFragmentLayout();

    protected abstract BasePresenter getPresenter();

    private void injectDependencies() {
        setUpComponent(App.getApp(getActivity()).getComponent());
    }

    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    private void unbindViews() {
        ButterKnife.unbind(this);
    }

    protected abstract void setUpComponent(AppComponent component);

    @Override
    public void showMessage(String message, boolean longer) {
        int duration = longer ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT;
        Snackbar.make(view, message, duration).show();
    }

    @Override
    public void showProgress(String message) {
        progressDialog = ProgressDialog.show(getActivity(), null, message, true);
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
