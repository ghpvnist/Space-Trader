package edu.gatech.cs2340.spacetrader.view;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

/**
 * Class that helps to format the banners on views in the application
 */
public final class ViewFormatUtil {

    public static final double URGENT_LOW_CARGO_THRESH = 0.1;
    public static final int URGENT_LOW_CARGO_COLOR = Color.rgb(224, 15, 24);

    public static final double LOW_CARGO_THRESH = 0.33;
    public static final int LOW_CARGO_COLOR = Color.rgb(250, 100, 0);

    /**
     * Creates the string representation of the player's cargo capacity
     * @param available the player's available cargo space
     * @param max the player's maximum cargo space
     * @param addSpace boolean that helps to format the resultant string
     * @return the string that corresponds to the player's cargo capacity
     */
    public static SpannableStringBuilder formatCargoCapacity(int available, int max, boolean addSpace) {

        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString availSpace = new SpannableString(String.valueOf(available));
        if (((double) available) / max < URGENT_LOW_CARGO_THRESH) {
            availSpace.setSpan(new ForegroundColorSpan(URGENT_LOW_CARGO_COLOR), 0, availSpace.length(), 0);
        } else if (((double) available) / max < LOW_CARGO_THRESH) {
            availSpace.setSpan(new ForegroundColorSpan(LOW_CARGO_COLOR), 0, availSpace.length(), 0);
        }
        builder.append(availSpace);

        SpannableString sep = new SpannableString(addSpace ? " / " : "/");
        builder.append(sep);

        SpannableString maxSpace = new SpannableString(String.valueOf(max));
        builder.append(maxSpace);

        return builder;
    }
}
