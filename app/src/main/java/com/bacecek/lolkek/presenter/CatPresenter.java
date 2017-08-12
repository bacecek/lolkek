package com.bacecek.lolkek.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.bacecek.lolkek.data.ScreenState;
import com.bacecek.lolkek.model.InfoRepo;
import com.bacecek.lolkek.model.MemRepository;
import com.bacecek.lolkek.navigation.AppRouter;
import com.bacecek.lolkek.view.MemView;
import com.bacecek.lolkek.view.cat.CatView;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ringov on 12.08.17.
 */

@Singleton
@InjectViewState
public class CatPresenter extends BasePresenter<CatView> {
    private final AppRouter appRouter;

    InfoRepo infoRepo;

    @Inject
    public CatPresenter(AppRouter appRouter, InfoRepo infoRepo) {
        super(appRouter);
        this.appRouter = appRouter;
        this.infoRepo = infoRepo;
    }

    public void initCat() {
    }

    public void handleScreenStateSuccess(ScreenState screenState) {
        Log.d("myLogs", "handleScreenStateSuccess: " + screenState.getState());
    }

    public void handleScreenStateFailure(Throwable throwable) {
        Log.d("myLogs", "handleScreenStateFailure: " + throwable);
        //Error handling on hakaton? Maybe
    }

    public void gladitCat() {
        infoRepo.increaseBalance(1);
        getViewState().showPlusBalance(1);
    }
}