package com.AbdShammout.UBV.util;

import android.content.Context;

public class Utils {
    public static int convertDpToPx(Context context, int dps){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dps * scale + 0.5f);
    }
}
