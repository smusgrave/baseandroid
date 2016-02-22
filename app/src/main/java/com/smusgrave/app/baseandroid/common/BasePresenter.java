package com.smusgrave.app.baseandroid.common;

public abstract class BasePresenter<V extends BasePresenter.View> {

    private V view;

    public void bindView(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    public interface View {

        void showMessage(String message, boolean longer);

        void showProgress(String message);

        void hideProgress();

    }

}
