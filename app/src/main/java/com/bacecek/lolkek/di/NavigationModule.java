package com.bacecek.lolkek.di;


import com.bacecek.lolkek.navigation.AppRouter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;

/**
 *
 */
@Module
public abstract class NavigationModule {
    @Provides
    @Singleton
    public static NavigatorHolder provideNavigatorHolder(Cicerone<AppRouter> cicerone){
        return cicerone.getNavigatorHolder();
    }

    @Provides
    @Singleton
    public static Cicerone<AppRouter> provideCicerone(AppRouter appRouter){
        return Cicerone.create(appRouter);
    }
}
