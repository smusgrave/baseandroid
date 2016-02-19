package com.smusgrave.app.baseandroid.common;

public interface BasePresenter<V extends BaseView> {

    void bindView(V view);

    V getView();

    void onStart();

    void onStop();

}
