package com.stacktips.view.calendar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.stacktips.view.utils.Utils;

/**
 * Created by npanigrahy on 09/06/2016.
 */
public class CustomWeekViewLayout extends LinearLayout {
    private Context mContext;
    int defaultMargin = 1;
    int minHeight = 35;

    public CustomWeekViewLayout(Context context) {
        this(context, null);
    }

    public CustomWeekViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomWeekViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomWeekViewLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        mContext = context;

        //setting weight sum 7
        setWeightSum(7);
        setBaselineAligned(false);
        addDayViews();
    }



    private void addDayViews() {
        int margin = Utils.dpToPx(mContext, defaultMargin);
        for (int i = 0; i < 7; i++) {
            RelativeLayout relativeLayout = new RelativeLayout(mContext);
            final LinearLayout.LayoutParams topParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            topParams.setMargins(margin, 0, margin, 0);
            topParams.weight = 1;
            topParams.gravity = Gravity.CENTER_VERTICAL;

            relativeLayout.setLayoutParams(topParams);
            relativeLayout.setTag(Utils.DAY_OF_WEEK + (i + 1));
            relativeLayout.setBackgroundColor(Color.WHITE);
            relativeLayout.setMinimumHeight(Utils.dpToPx(mContext, minHeight));
            addView(relativeLayout);
        }

    }
}
