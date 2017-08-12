package com.bacecek.lolkek.data;

/**
 *
 */
public abstract class ScreenState {
    public static final int MEM = 1;
    public static final int RESULT = 2;

    public abstract int getState();
}
