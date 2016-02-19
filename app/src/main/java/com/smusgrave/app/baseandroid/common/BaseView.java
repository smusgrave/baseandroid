package com.smusgrave.app.baseandroid.common;

public interface BaseView {

    void showMessage(String message, boolean longer);

    void showProgress(String message);

    void hideProgress();

}
