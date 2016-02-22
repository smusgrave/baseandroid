package com.smusgrave.app.baseandroid.ui.main;

import com.smusgrave.app.baseandroid.common.BasePresenter;

public class MainPresenter extends BasePresenter<MainPresenter.View> {

    public void handleButtonClick() {
        getView().showMessage("Test button clicked!", false);
    }

    public interface View extends BasePresenter.View {

    }

}
