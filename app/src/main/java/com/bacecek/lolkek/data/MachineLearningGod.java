package com.bacecek.lolkek.data;

import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * 
 */
@Singleton
public class MachineLearningGod   {

    @Inject
    public MachineLearningGod() {
    }

    public RoundResult getResult() {
        int answer = new Random().nextInt(4);
        if (answer<2){
        return RoundResult.BAD;
        } else {
            return RoundResult.LOL;
        }
    }
}
