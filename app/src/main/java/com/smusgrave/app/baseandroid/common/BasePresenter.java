package com.smusgrave.app.baseandroid.common;

public abstract class BasePresenter<V extends BasePresenter.View> {

    private V view;

    public void setView(V view) {
        this.view = view;
        onLoad();
    }

    protected V getView() {
        return view;
    }

    protected void onLoad() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
        setView(null);
    }

    public interface View {

        void showMessage(String message, boolean longer);

        void showProgress(String message);

        void hideProgress();

    }

}
