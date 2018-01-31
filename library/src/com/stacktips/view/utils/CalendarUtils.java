package com.stacktips.view.utils;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_YEAR;
import static java.util.Calendar.ERA;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.WEEK_OF_MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

/**
 * Created by Nilanchala Panigrahy on 8/24/16.
 */
public class CalendarUtils {

    public static boolean isSameMonth(Calendar calendar1, Calendar calendar2) {
        return calendar1 != null &&
                calendar2 != null &&
                compare(calendar1, calendar2, ERA, YEAR, MONTH);
    }

    /**
     * <p>Checks if a calendar is today.</p>
     *
     * @param calendar the calendar, not altered, not null.
     * @return true if the calendar is today.
     * @throws IllegalArgumentException if the calendar is <code>null</code>
     */
    public static boolean isToday(Calendar calendar) {
        return isSameDay(calendar, getInstance());
    }

    public static boolean isSameDay(Calendar calendar1, Calendar calendar2) {
        requireNotNull(calendar1);
        requireNotNull(calendar2);
        return compare(calendar1, calendar2, ERA, YEAR, DAY_OF_YEAR);
    }

    public static int getTotalWeeks(Calendar calendar) {
        if (null == calendar) {
            return 0;
        }
        return calendar.getActualMaximum(WEEK_OF_MONTH);
    }

    public static int getTotalWeeks(Date date) {
        Calendar calendar = getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        return getTotalWeeks(calendar);
    }

    public static boolean isPastDay(Date date) {
        Calendar calendar = getInstance();
        calendar.set(HOUR_OF_DAY, 0);
        calendar.set(MINUTE, 0);
        calendar.set(SECOND, 0);
        calendar.set(MILLISECOND, 0);
        return date.before(calendar.getTime());
    }

    private static boolean compare(Calendar instance1, Calendar instance2, int... fields) {
        for (int field : fields) {
            if (!compare(instance1, instance2, field)) {
                return false;
            }
        }
        return true;
    }

    private static boolean compare(Calendar instance1, Calendar instance2, int field) {
        return instance1.get(field) == instance2.get(field);
    }

    private static void requireNotNull(Calendar instance) {
        if (instance == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
    }
}
