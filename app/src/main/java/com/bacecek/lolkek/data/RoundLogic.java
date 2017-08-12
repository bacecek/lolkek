package com.bacecek.lolkek.data;

import java.util.Random;

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
    private String percent;
    private String title;

    @Inject
    public RoundLogic(MachineLearningGod machineLearningGod) {
        this.machineLearningGod = machineLearningGod;
    }

    public boolean isWin(RoundResult choice) {
        return choice.equals(result);
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
        this.result = machineLearningGod.getResult();
        this.percent = String.valueOf(new Random().nextInt(100));
    }

    public void maybeResult() {
        if (!ended) {
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
