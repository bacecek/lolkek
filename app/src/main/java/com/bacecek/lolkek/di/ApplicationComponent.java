package com.bacecek.lolkek.di;

import com.bacecek.lolkek.MainActivity;
import com.bacecek.lolkek.presenter.MemPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 */
@Component(modules = {AppModule.class, NavigationModule.class})
@Singleton
public interface ApplicationComponent {
    MemPresenter getMemPresenter();

    void inject(MainActivity mainActivity);
}
