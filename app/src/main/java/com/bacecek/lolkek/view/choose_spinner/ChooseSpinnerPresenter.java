package com.bacecek.lolkek.view.choose_spinner;

import com.arellomobile.mvp.InjectViewState;
import com.bacecek.lolkek.model.MemRepository;
import com.bacecek.lolkek.navigation.AppRouter;
import com.bacecek.lolkek.presenter.BasePresenter;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by macbookpro on 12.08.17.
 */

@Singleton
@InjectViewState
public class ChooseSpinnerPresenter extends BasePresenter<ChooseSpinnerView> {
    private final AppRouter appRouter;
    private final MemRepository memRepository;

    @Inject
    public ChooseSpinnerPresenter(AppRouter appRouter,MemRepository memRepository) {
        super(appRouter);
        this.appRouter = appRouter;
        this.memRepository = memRepository;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        List<Spinner> dataset = new ArrayList<>();
        dataset.add(new Spinner(1,100, 2, 2));
        dataset.add(new Spinner(2,100, 3, 5));
        dataset.add(new Spinner(3,100, 10, 5));
        getViewState().setSpinners(dataset);
    }

    public void onChooseSpinner(Spinner spinner) {
        memRepository.setSpinner(spinner);
    }
}
