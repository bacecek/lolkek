package com.bacecek.lolkek.model;

import android.util.Log;

import com.bacecek.lolkek.data.MemFactory;
import com.bacecek.lolkek.data.MemState;
import com.bacecek.lolkek.data.ResultState;
import com.bacecek.lolkek.data.ScreenState;

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

    @Inject
    public MemRepository(MemFactory memFactory) {
        this.memFactory = memFactory;
    }

    public Observable<ScreenState> initMem() {
        return Observable
                .timer(1000, TimeUnit.MILLISECONDS)
                .retry()
                .map(this::getTimeStamp)
                .map(this::getScreenState);
    }

    private long getTimeStamp(Long l) {
        return System.currentTimeMillis();
    }

    private int getCurrentSecond(Long timestamp) {
        return (int) (timestamp % 20);
    }

    private ScreenState getScreenState(long timestamp) {
        int currentSecond = getCurrentSecond(timestamp);
        Log.d("myLogs", "getScreenState() called with: currentSecond = [" + currentSecond + "]");
        if (currentSecond < 16) {
            return createMemState(currentSecond, timestamp);
        } else {
            return createResultState();
        }
    }

    private MemState createMemState(int currentSecond, long timestamp){
        String memUrl = memFactory.getMemOfTime(timestamp);

        return new MemState(memUrl, currentSecond);
    }

    private ResultState createResultState(){
        return new ResultState();
    }

}
