package com.bacecek.lolkek.data;

import com.bacecek.lolkek.model.InfoRepo;
import com.bacecek.lolkek.view.models.Spinner;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class RoundLogic {

    public static final int prize = 10;

    private boolean started;
    private boolean ended;
    private RoundResult result;

    private final MachineLearningGod machineLearningGod;
    private final InfoRepo infoRepo;
    private String percent;
    private String title;

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    private String mem;

    private Spinner spinner;

    public Spinner getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }

    @Inject
    public RoundLogic(MachineLearningGod machineLearningGod, InfoRepo infoRepo) {
        this.machineLearningGod = machineLearningGod;
        this.infoRepo = infoRepo;
    }

    public boolean isWin(RoundResult choice) {
        return result.equals(choice);
    }

    public RoundResult getResult() {
        return result;
    }

    public void maybeNewRound() {
        if (!started) {
            generateNewResult();
            started = true;
            ended = false;
        }
    }

    private void generateNewResult() {
        this.spinner = null;
        this.result = machineLearningGod.getResult();
        this.percent = String.valueOf(machineLearningGod.getPercent());
        this.mem = machineLearningGod.getMem();
    }

    public void maybeResult() {
        if (!ended) {
            int newprize = RoundLogic.prize;
            if (spinner !=null){
                newprize = newprize * spinner.getCoeff();
            }
            infoRepo.increaseBalance(newprize);
            ended = true;
            started = false;
        }
    }

    public String getPercent() {
        return percent;
    }

    public String getTitle() {
        if (result.equals(RoundResult.LOL)) {
            return "Bad";
        } else {
            return "Lol";
        }
    }

}
