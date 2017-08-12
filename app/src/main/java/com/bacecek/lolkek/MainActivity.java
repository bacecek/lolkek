package com.bacecek.lolkek;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.bacecek.lolkek.navigation.AppNavigator;
import com.bacecek.lolkek.navigation.BackButtonListener;
import com.bacecek.lolkek.navigation.Screen;
import com.bacecek.lolkek.navigation.command.Replace;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;

public class MainActivity extends AppCompatActivity {

    @Inject NavigatorHolder navigatorHolder;

    private AppNavigator navigator;
    // ---------------------------------------- lifecycle -------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((KekApplication) getApplication()).getApplicationComponent().inject(this);
        setContentView(R.layout.activity_main);

        navigator = new AppNavigator(this, R.id.fragment_container);

        if (savedInstanceState == null) {
            navigator.applyCommand(new Replace(Screen.SCREEN_MEM, null));
        }
    }


    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment != null && fragment instanceof BackButtonListener) {
            ((BackButtonListener) fragment).onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}
