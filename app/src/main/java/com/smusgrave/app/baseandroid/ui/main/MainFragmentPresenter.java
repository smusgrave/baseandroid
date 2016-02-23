package com.smusgrave.app.baseandroid.ui.main;

import com.smusgrave.app.baseandroid.common.BasePresenter;

public class MainFragmentPresenter extends BasePresenter<MainFragmentPresenter.View> {

    public void onButtonClick() {
        getView().showMessage("Something was done. But not really.", false);
    }

    public interface View extends BasePresenter.View {

        void onButtonClicked();

    }

}
