package com.stacktips.view.utils;

import android.content.Context;
import android.util.DisplayMetrics;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nilanchala Panigrahy on 8/24/16.
 */

public class Utils {
    public static final String DAY_OF_THE_MONTH = "dayOfMonthText";
    public static final String WEEK_OF_MONTH_CONTAINER = "weekOfMonthContainer";

    public static final String ROBOTO_CALENDAR_WEK = "roboto_calendar_week";
    public static final String DAY_OF_WEEK = "dayOfWeek";

    //private static final String DAY_OF_WEEK = "dayOfWeek";
    //private static final String DAY_OF_MONTH_TEXT = "dayOfMonthText";
    //private static final String DAY_OF_MONTH_CONTAINER = "dayOfMonthContainer";

    public static int dpToPx(Context context, float dp) {
        int px = Math.round(dp * getPixelScaleFactor(context));
        return px;
    }

    public static int pxToDp(Context context, int px) {
        int dp = Math.round(px / getPixelScaleFactor(context));
        return dp;
    }

    private static float getPixelScaleFactor(Context context) {
        if (null != context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT);
        } else {
            return (1.0f / DisplayMetrics.DENSITY_DEFAULT) * DisplayMetrics.DENSITY_XHIGH;
        }
    }

    public boolean isSameMonth(Calendar c1, Calendar c2) {
        if (c1 == null || c2 == null)
            return false;
        return (c1.get(Calendar.ERA) == c2.get(Calendar.ERA)
                && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH));
    }

    /**
     * <p>Checks if a calendar is today.</p>
     *
     * @param calendar the calendar, not altered, not null.
     * @return true if the calendar is today.
     * @throws IllegalArgumentException if the calendar is <code>null</code>
     */
    public static boolean isToday(Calendar calendar) {
        return isSameDay(calendar, Calendar.getInstance());
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null)
            throw new IllegalArgumentException("The dates must not be null");
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    public static int getTotalWeeks(Calendar calendar) {
        if (null == calendar) return 0;
        int maxWeeks = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
        return maxWeeks;

    }

    public static int getTotalWeeks(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getTotalWeeks(cal);
    }

}
