package com.smusgrave.app.baseandroid.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.smusgrave.app.baseandroid.AppComponent;
import com.smusgrave.app.baseandroid.R;
import com.smusgrave.app.baseandroid.common.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String FRAGMENT_TAG = "main_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = MainFragment.newInstance();
        setupFragment(FRAGMENT_TAG);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        // No dependencies
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
