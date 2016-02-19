package com.smusgrave.app.baseandroid.ui.main;

public class MainPresenterImpl implements MainPresenter {

    MainView view;

    @Override
    public void bindView(MainView view) {
        this.view = view;
    }

    @Override
    public MainView getView() {
        return view;
    }

    @Override
    public void onStart() {
        // Nothing to start
    }

    @Override
    public void onStop() {
        // Nothing to stop
    }

    @Override
    public void handleButtonClick() {
        view.showMessage("Test button clicked!", false);
    }
}
