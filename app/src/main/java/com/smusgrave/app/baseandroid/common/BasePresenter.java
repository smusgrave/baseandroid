package com.smusgrave.app.baseandroid.common;

public abstract class BasePresenter<V extends BasePresenter.View> {

    private V view;

    public void bindView(V view) {
        this.view = view;
        onLoad();
    }

    public void unbindView() {
        this.view = null;
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
        unbindView();
    }

    public interface View {

        void showMessage(String message, boolean longer);

        void showProgress();

        void hideProgress();

    }

}
