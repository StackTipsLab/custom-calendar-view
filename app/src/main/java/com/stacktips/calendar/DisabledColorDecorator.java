package com.stacktips.calendar;

import android.graphics.Color;

import com.stacktips.view.DayDecorator;
import com.stacktips.view.DayView;
import com.stacktips.view.utils.CalendarUtils;

public class DisabledColorDecorator implements DayDecorator {
    @Override
    public void decorate(DayView dayView) {
        if (CalendarUtils.isPastDay(dayView.getDate())) {
            int color = Color.parseColor("#a9afb9");
            dayView.setBackgroundColor(color);
        }
    }
}