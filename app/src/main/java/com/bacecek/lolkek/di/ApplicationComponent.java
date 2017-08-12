package com.bacecek.lolkek.di;

import com.bacecek.lolkek.MainActivity;
import com.bacecek.lolkek.presenter.CatPresenter;
import com.bacecek.lolkek.presenter.MemPresenter;
import com.bacecek.lolkek.presenter.ChooseSpinnerPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 */
@Component(modules = {AppModule.class, NavigationModule.class})
@Singleton
public interface ApplicationComponent {
    MemPresenter getMemPresenter();
    ChooseSpinnerPresenter getChooseSpinnerPresenter();
    CatPresenter getCatPresenter();

    void inject(MainActivity mainActivity);
}
