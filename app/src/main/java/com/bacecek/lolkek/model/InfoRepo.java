package com.bacecek.lolkek.model;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ringov on 12.08.17.
 */

@Singleton
public class InfoRepo {

    private static final String SP_KEY = "info_prefs";
    private static final String SPINNER_KEY = "spinner";
    private static final String BALANCE = "balance";

    private static final int DEFAULT_BALANCE = 1000;

    private SharedPreferences sp;

    @Inject
    public InfoRepo(Context context) {
        sp = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
    }

    public int getSpinner(int type) {
        return sp.getInt(SPINNER_KEY + type, 1);
    }

    public int getBalance() {
        return sp.getInt(BALANCE, DEFAULT_BALANCE);
    }

    public void increaseBalance(int plus) {
        int crt = sp.getInt(BALANCE, DEFAULT_BALANCE);
        sp.edit().putInt(BALANCE, crt + plus).apply();
    }

    public void increaseSpinnerCount(int type, int plus) {
        int crt = sp.getInt(SPINNER_KEY + type, 0);
        sp.edit().putInt(SPINNER_KEY + type, crt + plus).apply();
    }
}
