package com.bacecek.lolkek.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.bacecek.lolkek.data.ScreenState;

/**
 *
 */
public interface MemView extends BaseView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showScreenState(ScreenState screenState);
}
