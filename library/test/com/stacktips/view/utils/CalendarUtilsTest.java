package com.stacktips.view.utils;


import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalendarUtilsTest {

    @Test
    public void should_return_false_when_comparing_month_with_null() {
        assertFalse(CalendarUtils.isSameMonth(null, null));
        assertFalse(CalendarUtils.isSameMonth(Calendar.getInstance(), null));
        assertFalse(CalendarUtils.isSameMonth(null, Calendar.getInstance()));
    }

    @Test
    public void should_return_true_comparing_calendars_with_same_month() {
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        assertTrue(CalendarUtils.isSameMonth(instance1, instance2));
    }

    @Test
    public void should_return_false_comparing_calendars_with_different_month() {
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        increase(instance2, Calendar.MONTH);
        assertFalse(CalendarUtils.isSameMonth(instance1, instance2));
    }

    @Test
    public void should_return_true_when_checking_today() {
        Calendar instance = Calendar.getInstance();
        assertTrue(CalendarUtils.isToday(instance));
    }

    @Test
    public void should_return_false_when_checking_today() {
        Calendar instance = Calendar.getInstance();
        increase(instance, Calendar.DAY_OF_YEAR);
        assertFalse(CalendarUtils.isToday(instance));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_comparing_day_with_both_null_arguments() {
        CalendarUtils.isSameDay(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_comparing_day_with_first_null_argument() {
        CalendarUtils.isSameDay(null, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_comparing_day_with_second_null_argument() {
        CalendarUtils.isSameDay(Calendar.getInstance(), null);
    }

    @Test
    public void should_return_true_comparing_days() {
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        assertTrue(CalendarUtils.isSameDay(instance1, instance2));
    }

    @Test
    public void should_return_false_comparing_days() {
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        increase(instance2, Calendar.DAY_OF_YEAR);
        assertFalse(CalendarUtils.isSameDay(instance1, instance2));
    }

    @Test
    public void should_return_zero_total_weeks_for_null_calendar_instance() {
        assertEquals(0, CalendarUtils.getTotalWeeks((Calendar) null));
    }

    @Test
    public void should_return_correct_amount_of_weeks() {
        Calendar instance = Calendar.getInstance();
        int expectedAmountOfWeeks = instance.getActualMaximum(Calendar.WEEK_OF_MONTH);
        assertEquals(expectedAmountOfWeeks, CalendarUtils.getTotalWeeks(instance));
    }

    @Test
    public void should_not_throw_null_pointer_getting_weeks_amount_with_null_date() {
        int expectedWeekAmount = Calendar.getInstance().getActualMaximum(Calendar.WEEK_OF_MONTH);
        assertEquals(expectedWeekAmount, CalendarUtils.getTotalWeeks((Date) null));
    }

    @Test
    public void should_return_true_checking_if_day_is_passed() {
        Calendar calendar = Calendar.getInstance();
        decrease(calendar, Calendar.DAY_OF_YEAR);
        assertTrue(CalendarUtils.isPastDay(calendar.getTime()));
    }

    @Test
    public void should_return_false_checking_if_day_is_passed() {
        Calendar calendar = Calendar.getInstance();
        increase(calendar, Calendar.DAY_OF_YEAR);
        assertFalse(CalendarUtils.isPastDay(calendar.getTime()));
    }

    private void increase(Calendar instance, int field) {
        int newValue = instance.get(field) + 1;
        instance.set(field, newValue);
    }

    private void decrease(Calendar instance, int field) {
        int newValue = instance.get(field) - 1;
        instance.set(field, newValue);
    }
}
