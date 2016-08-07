package kr.pe.burt.android.lib.androidkommon.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import statecomponents.support.AndroidStateAppCompatActivity;

public class MainActivity extends AndroidStateAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoadingView();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }
}
