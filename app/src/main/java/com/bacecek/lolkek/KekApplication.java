package com.bacecek.lolkek;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.bacecek.lolkek.di.AppModule;
import com.bacecek.lolkek.di.ApplicationComponent;
import com.bacecek.lolkek.di.DaggerApplicationComponent;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 *
 */
public class KekApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

    }

    @NonNull
    public static KekApplication get(@NonNull Context context) {
        return (KekApplication) context.getApplicationContext();
    }

    @NonNull
    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = buildApplicationComponent().build();
        }
        return applicationComponent;
    }


    @NonNull
    protected DaggerApplicationComponent.Builder buildApplicationComponent() {
        return DaggerApplicationComponent.builder()
                .appModule(new AppModule(getApplicationContext()));
    }
}
