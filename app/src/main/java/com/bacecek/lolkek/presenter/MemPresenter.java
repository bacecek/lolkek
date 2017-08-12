package com.bacecek.lolkek.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.bacecek.lolkek.data.RoundResult;
import com.bacecek.lolkek.data.ScreenState;
import com.bacecek.lolkek.model.MemRepository;
import com.bacecek.lolkek.navigation.AppRouter;
import com.bacecek.lolkek.view.MemView;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
@Singleton
@InjectViewState
public class MemPresenter extends BasePresenter<MemView> {
    private final AppRouter appRouter;
    private final MemRepository memRepository;

    CompositeDisposable composite = new CompositeDisposable();
    private RoundResult result;

    @Inject
    public MemPresenter(AppRouter appRouter, MemRepository memRepository) {
        super(appRouter);
        this.appRouter = appRouter;
        this.memRepository = memRepository;
    }

    public void initMem() {
        composite.clear();
        composite.add(memRepository
                .initMem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleScreenStateSuccess, this::handleScreenStateFailure));
    }

    public void handleScreenStateSuccess(ScreenState screenState) {
        getViewState().showScreenState(screenState);
    }

    public void handleScreenStateFailure(Throwable throwable) {
        Log.d("myLogs", "handleScreenStateFailure: " + throwable);
        //Error handling on hakaton? Maybe
    }

    public void onLolClicked() {

    }

    public void onGavnoClicked() {

    }

    public void setResult(RoundResult result) {
        memRepository.setChoiceRound(result);
    }
}
