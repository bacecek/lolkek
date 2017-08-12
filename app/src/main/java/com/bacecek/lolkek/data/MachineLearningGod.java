package com.bacecek.lolkek.data;

import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class MachineLearningGod {

    private final MemFactory memFactory;

    @Inject
    public MachineLearningGod(MemFactory memFactory) {
        this.memFactory = memFactory;
    }

    public RoundResult getResult() {
        int answer = new Random().nextInt(4);
        if (answer < 2) {
            return RoundResult.BAD;
        } else {
            return RoundResult.LOL;
        }
    }

    public int getPercent() {
        int answer = 50 + new Random().nextInt(50);
        return answer;
    }

    public String getMem(){
        return memFactory.getMemOfTime(new Random().nextInt(34));
    }
}
