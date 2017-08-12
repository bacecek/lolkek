package com.bacecek.lolkek;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bacecek.lolkek.navigation.AppNavigator;
import com.bacecek.lolkek.navigation.BackButtonListener;
import com.bacecek.lolkek.navigation.Screen;
import com.bacecek.lolkek.navigation.command.Replace;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.NavigatorHolder;

public class MainActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;

    @BindView(R.id.sliding_layout)
    SlidingUpPanelLayout slidingLayout;

    private AppNavigator navigator;
    // ---------------------------------------- lifecycle -------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((KekApplication) getApplication()).getApplicationComponent().inject(this);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupViews();

        navigator = new AppNavigator(this, R.id.fragment_container);

        if (savedInstanceState == null) {
            navigator.applyCommand(new Replace(Screen.SCREEN_MEM, null));
        }
    }

    private void setupViews() {
        slidingLayout.setAnchorPoint(0.35f);
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
