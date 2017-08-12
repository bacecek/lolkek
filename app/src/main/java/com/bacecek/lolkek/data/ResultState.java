package com.bacecek.lolkek.data;


import com.bacecek.lolkek.view.models.Spinner;

/**
 *
 */
public class ResultState extends ScreenState {

    private final String title;
    private final String newCoins;
    private final Spinner spinner;
    private String percent;

    public Spinner getSpinner() {
        return spinner;
    }

    public String getPercent() {
        return percent;
    }

    public ResultState(String title, String newCoins, Spinner spinner, String percent) {
        this.title = title;
        this.newCoins = newCoins;
        this.spinner = spinner;
        this.percent = percent;
    }

    @Override
    public int getState() {
        return RESULT;
    }

    public String getTitle() {
        return title;
    }

    public String getNewCoins() {
        return newCoins;
    }

}
