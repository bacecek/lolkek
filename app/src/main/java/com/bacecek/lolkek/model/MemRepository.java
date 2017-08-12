package com.bacecek.lolkek.model;


import com.bacecek.lolkek.data.MemFactory;
import com.bacecek.lolkek.data.MemState;
import com.bacecek.lolkek.data.ResultState;
import com.bacecek.lolkek.data.RoundLogic;
import com.bacecek.lolkek.data.RoundResult;
import com.bacecek.lolkek.data.ScreenState;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 *
 */
@Singleton
public class MemRepository {

    private final MemFactory memFactory;
    private final RoundLogic roundLogic;

    private RoundResult choiceRound;

    @Inject
    public MemRepository(MemFactory memFactory, RoundLogic roundLogic) {
        this.memFactory = memFactory;
        this.roundLogic = roundLogic;
    }

    public Observable<ScreenState> initMem() {
        return Observable
                .timer(1000, TimeUnit.MILLISECONDS)
                .repeat()
                .map(this::getTimeStamp)
                .map(this::getScreenState);
    }

    private long getTimeStamp(long i) {
        return System.currentTimeMillis();
    }

    private int getCurrentSecond(Long timestamp) {
        return (int) (timestamp % 20000);
    }

    private ScreenState getScreenState(long timestamp) {
        int currentSecond = getCurrentSecond(timestamp) / 1000;
        if (currentSecond < 16) {
            roundLogic.maybeNewRound();
            return createMemState(currentSecond, timestamp);
        } else {
            roundLogic.maybeResult();
            return createResultState();
        }
    }

    private MemState createMemState(int currentSecond, long timestamp) {

        return new MemState(roundLogic.getMem(), currentSecond);
    }

    private ResultState createResultState() {
        if (roundLogic.getSpinner() != null) {
            return new ResultState(roundLogic.getTitle(), getWinCats(), roundLogic.getSpinner(), roundLogic.getPercent());
        } else {
            setChoiceRound(roundLogic.getResult());
            return new ResultState(roundLogic.getTitle(), getWinCats(), roundLogic.getSpinner(), roundLogic.getPercent());
        }
    }

    public void setChoiceRound(RoundResult choiceRound) {
        this.choiceRound = choiceRound;
    }

//--------------------------------SpinnerInteraction------------------------------------------//

    public void setSpinner(Spinner spinner) {
        this.roundLogic.setSpinner(spinner);
    }

    public String getWinCats() {
        int cats;
        if (roundLogic.isWin(choiceRound) && roundLogic.getSpinner() !=null){
            cats = RoundLogic.prize * roundLogic.getSpinner().getCoeff();
        } else {
            cats = RoundLogic.prize;
        }
        return String.valueOf(cats);
    }
}
