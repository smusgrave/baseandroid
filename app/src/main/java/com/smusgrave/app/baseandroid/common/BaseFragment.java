package com.smusgrave.app.baseandroid.common;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smusgrave.app.baseandroid.App;
import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseFragment extends Fragment implements BasePresenter.View {

    protected Context context;
    protected View view;
    @Bind(R.id.progress_bar)
    View progressBar;

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
        initializePresenter();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getPresenter() != null) {
            getPresenter().onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getPresenter() != null) {
            getPresenter().onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
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

    protected BasePresenter getPresenter() {
        return null;
    }

    private void injectDependencies() {
        setupComponent(App.getApp(getActivity()).getComponent());
    }

    protected void initializePresenter() {
    }

    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    private void unbindViews() {
        ButterKnife.unbind(this);
    }

    protected abstract void setupComponent(AppComponent component);

    @Override
    public void showMessage(String message, boolean longer) {
        int duration = longer ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT;
        Snackbar.make(view, message, duration).show();
    }

    @Override
    public void showProgress() {
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }

}
