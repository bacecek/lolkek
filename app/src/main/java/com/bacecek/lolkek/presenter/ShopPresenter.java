package com.bacecek.lolkek.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.bacecek.lolkek.model.InfoRepo;
import com.bacecek.lolkek.navigation.AppRouter;
import com.bacecek.lolkek.view.models.Spinner;
import com.bacecek.lolkek.view.shop.ShopView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@InjectViewState
public class ShopPresenter extends BasePresenter<ShopView> {

    private final InfoRepo infoRepo;
    private final AppRouter appRouter;

    @Override
    public void attachView(ShopView view) {
        super.attachView(view);
    }

    @Inject
    public ShopPresenter(AppRouter appRouter, InfoRepo infoRepo) {
        super(appRouter);
        this.appRouter = appRouter;
        this.infoRepo = infoRepo;
    }

    public void initShop(){
        int countSpinner1 = infoRepo.getSpinner(2);
        int countSpinner2 = infoRepo.getSpinner(3);
        int countSpinner3 = infoRepo.getSpinner(5);
        int countSpinner4 = infoRepo.getSpinner(10);

        Spinner spinner1 = new Spinner(2, 100, 2, countSpinner1);
        Spinner spinner2 = new Spinner(3, 200, 3, countSpinner2);
        Spinner spinner3 = new Spinner(5, 300, 5, countSpinner3);
        Spinner spinner4 = new Spinner(10, 400, 10, countSpinner4);

        List<Spinner> dataset = new ArrayList<>();
        dataset.add(spinner1);
        dataset.add(spinner2);
        dataset.add(spinner3);
        dataset.add(spinner4);

        getViewState().updateItems(dataset);
    }


    public void onItemBought(Spinner item) {
        Log.e("ShopRepo", String.valueOf(infoRepo.getBalance()));
        Log.e("ShopRepo", String.valueOf(item.getPrice()));
        if(infoRepo.getBalance() >= item.getPrice()){
            infoRepo.increaseSpinnerCount(item.getCoeff(), 1);
            infoRepo.increaseBalance(-item.getPrice());
            initShop();
        }
        else{
            getViewState().showError();
        }

    }
}
