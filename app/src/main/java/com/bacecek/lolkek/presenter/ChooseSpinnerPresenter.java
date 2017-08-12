package com.bacecek.lolkek.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.bacecek.lolkek.model.InfoRepo;
import com.bacecek.lolkek.model.MemRepository;
import com.bacecek.lolkek.navigation.AppRouter;
import com.bacecek.lolkek.view.choose_spinner.ChooseSpinnerView;
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
    private final InfoRepo infoRepo;

    @Inject
    public ChooseSpinnerPresenter(AppRouter appRouter,MemRepository memRepository, InfoRepo infoRepo) {
        super(appRouter);
        this.appRouter = appRouter;
        this.memRepository = memRepository;
        this.infoRepo = infoRepo;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        int countSpinner1 = infoRepo.getSpinner(2);
        int countSpinner2 = infoRepo.getSpinner(3);
        int countSpinner3 = infoRepo.getSpinner(5);
        int countSpinner4 = infoRepo.getSpinner(10);

        Spinner spinner1 = new Spinner(100, 2, countSpinner1);
        Spinner spinner2 = new Spinner(200, 3, countSpinner2);
        Spinner spinner3 = new Spinner(300, 5, countSpinner3);
        Spinner spinner4 = new Spinner(400, 10, countSpinner4);

        List<Spinner> dataset = new ArrayList<>();
        dataset.add(spinner1);
        dataset.add(spinner2);
        dataset.add(spinner3);
        dataset.add(spinner4);

        getViewState().setSpinners(dataset);
    }

    public void onChooseSpinner(Spinner spinner) {
        memRepository.setSpinner(spinner);
        getViewState().dismiss();
    }
}
