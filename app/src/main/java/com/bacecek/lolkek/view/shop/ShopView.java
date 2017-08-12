package com.bacecek.lolkek.view.shop;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.bacecek.lolkek.view.BaseView;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ShopView extends BaseView {

    void onSpinnerBought(Spinner item);

    void updateItems(List<Spinner> list);

    void initRv();

    void showError();
}
