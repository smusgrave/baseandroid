package com.smusgrave.app.baseandroid.ui.main;

import android.os.AsyncTask;

import com.smusgrave.app.baseandroid.common.BasePresenter;

public class MainFragmentPresenter extends BasePresenter<MainFragmentPresenter.View> {

    public void workOnSomething() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                getView().showProgress();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                getView().hideProgress();
                getView().showMessage("Something was done. Or was it?", false);
            }
        }.execute();
    }

    public interface View extends BasePresenter.View {

        void doSomething();

    }

}
