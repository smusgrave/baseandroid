package com.smusgrave.app.baseandroid.ui.main;

import com.smusgrave.app.baseandroid.common.BasePresenter;

public class MainActivityPresenter extends BasePresenter<BasePresenter.View> {

    public void onFabClicked() {
        getView().showMessage("Fabulous click of the Fab.", false);
    }
    public interface View extends BasePresenter.View {

        void onFabClick();

    }

}
