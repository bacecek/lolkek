package com.bacecek.lolkek;

import android.content.Context;
import android.support.v4.content.ContextCompat;

/**
 *
 */
public class Utils {
    public static int getSpinnerColorFilter(int type, Context context) {
        switch (type) {
            default:
            case 2: {
                return ContextCompat.getColor(context, R.color.spinner1);
            }
            case 3: {
                return ContextCompat.getColor(context, R.color.spinner2);
            }
            case 5: {
                return ContextCompat.getColor(context, R.color.spinner3);
            }
            case 10: {
                return ContextCompat.getColor(context, R.color.spinner4);
            }
        }
    }
}
