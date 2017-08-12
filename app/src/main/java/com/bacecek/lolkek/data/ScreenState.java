package com.bacecek.lolkek.data;

/**
 *
 */
public abstract class ScreenState {
    public final int MEM = 1;
    public final int RESULT = 2;

    public abstract int getState();
}
