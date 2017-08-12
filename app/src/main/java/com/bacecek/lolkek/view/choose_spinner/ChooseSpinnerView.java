package com.bacecek.lolkek.view.choose_spinner;

import com.bacecek.lolkek.view.BaseView;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.List;

/**
 * Created by macbookpro on 12.08.17.
 */

public interface ChooseSpinnerView extends BaseView {
    void setSpinners(List<Spinner> spinners);
}
