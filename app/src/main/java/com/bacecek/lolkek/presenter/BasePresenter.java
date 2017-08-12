package com.bacecek.lolkek.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.bacecek.lolkek.navigation.AppRouter;
import com.bacecek.lolkek.view.BaseView;

/**
 *
 */

public abstract class BasePresenter<T extends BaseView> extends MvpPresenter<T> {
    private final AppRouter appRouter;

    public BasePresenter(AppRouter appRouter) {
        this.appRouter = appRouter;
    }

    public void onBackPressed(){
        appRouter.exit();
    }
}
