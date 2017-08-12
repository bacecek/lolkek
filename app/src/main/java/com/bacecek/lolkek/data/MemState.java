package com.bacecek.lolkek.data;

/**
 *
 */
public class MemState extends ScreenState{

    private final String memUrl;
    private final int time;


    public MemState(String memUrl, int time) {
        this.memUrl = memUrl;
        this.time = time;
    }



    @Override
    public int getState() {
        return MEM;
    }

    public String getMem() {
        return memUrl;
    }
}
