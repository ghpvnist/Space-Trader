package edu.gatech.cs2340.spacetrader.view;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

public final class ViewFormatUtil {

    public static SpannableStringBuilder formatCargoCapacity(int available, int max, boolean addSpace) {

        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString availSpace = new SpannableString(String.valueOf(available));
        if (((double)available)/max < 0.1) {
            availSpace.setSpan(new ForegroundColorSpan(Color.rgb(224, 15, 24)), 0, availSpace.length(), 0);
        } else if (((double)available)/max < 0.33) {
            availSpace.setSpan(new ForegroundColorSpan(Color.rgb(250, 100, 0)), 0, availSpace.length(), 0);
        }
        builder.append(availSpace);

        SpannableString sep = new SpannableString(addSpace ? " / " : "/");
        builder.append(sep);

        SpannableString maxSpace = new SpannableString(String.valueOf(max));
        builder.append(maxSpace);

        return builder;
    }
}
