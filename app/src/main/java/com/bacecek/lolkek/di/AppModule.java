package com.bacecek.lolkek.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class AppModule {
    private Context applicationContext;

    public AppModule(Context context) {
        this.applicationContext = context.getApplicationContext();
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return applicationContext;
    }
}
