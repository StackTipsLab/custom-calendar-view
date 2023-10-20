# Custom-Calendar-View

To use the CustomCalendarView in your application, you first need to add the library to your
application. You can do this either from Gradle, or Maven or by directly downloading the source code
from GitHub.

If you enjoy this library, don’t forget to follow me on
Twitter [@asknilan](https://www.twitter.com/asknilan) or visit my [stacktips.com](https://stacktips.com/).

![Alt text](/screenshot.001.jpeg "Custom Calendar View Library in Android")

## Features

Currently, it supports the following features:

* Next and previous month's navigation
* Allow various customization including background color for day, week, and title
* Set custom typeface using setCustomTypeFace() method.
* Show hide next previous month's overflow days
* Set custom day options for the start day of the week. By default, it is set to Calendar.SUNDAY
* Unlimited customizations for a day of the month using custom Decorators.
* Allow you to handle events when the user changes month and day selection.

### Gradle

Add it to your root `build.gradle` at the end of repositories:

```groovy
 dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
   mavenCentral()
   maven { url 'https://jitpack.io' }
  }
 }
```

Step 2: Add the dependency

```groovy
 dependencies {
         implementation 'com.github.StackTipsLab:custom-calendar-view:1.2.0'
 }
```


### Maven

```xml

<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
 </repositories>

```

**Step 2** Add the dependency in the form

```xml

 <dependency>
     <groupId>com.github.StackTipsLab</groupId>
     <artifactId>custom-calendar-view</artifactId>
     <version>1.2.0</version>
 </dependency>
```

## Using CustomCalendarView Library

The GitHub project source includes a sample application, that is used for demonstrating the various
features currently supported by this library. Once the library is added to your project, you can
include the CustomCalendarView into your activity/fragment layout using the following code snippets.

```xml

<com.stacktips.view.CustomCalendarView 
    android:id="@+id/calendar_view"
    android:layout_width="match_parent" 
    android:layout_height="wrap_content"
    android:background="#ffffff">
</com.stacktips.view.CustomCalendarView>
```

The above code snippet will show the simple Calendar View with the default design. Now, you can use the
following attributes, to customize the appearance of the calendar.

```xml

<com.stacktips.view.CustomCalendarView 
        android:id="@+id/calendar_view"
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"
        android:background="@color/off_white" 
        app:calendarBackgroundColor="@color/off_white"
        app:calendarTitleTextColor="@color/black" 
        app:currentDayOfMonthColor="@color/blue"
        app:dayOfMonthTextColor="@color/black" 
        app:dayOfWeekTextColor="@color/black"
        app:disabledDayBackgroundColor="@color/off_white" 
        app:disabledDayTextColor="@color/grey"
        app:nextMonthNavigationIcon="@drawable/button_next_month_selector"
        app:previousMonthNavigationIcon="@drawable/button_previous_month_selector"
        app:selectedDayBackgroundColor="@color/blue" 
        app:titleLayoutBackgroundColor="@color/white"
        app:weekLayoutBackgroundColor="@color/white">
</com.stacktips.view.CustomCalendarView>
```

Let us now initialize the calendar view to control the various other appearances and behavior of
calendar using the following methods.

```java
//Initialize CustomCalendarView from layout
calendarView=(CustomCalendarView)findViewById(R.id.calendar_view);

//Initialize calendar with date
Calendar currentCalendar=Calendar.getInstance(Locale.getDefault());

//Show Monday as the first date of the week
calendarView.setFirstDayOfWeek(Calendar.MONDAY);

//Show/hide overflow days of a month
calendarView.setShowOverflowDate(false);

//call refreshCalendar to update calendar the view
calendarView.refreshCalendar(currentCalendar);

//Handling custom calendar events
calendarView.setCalendarListener(new CalendarListener(){
        @Override
        public void onDateSelected(Date date){
                SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
                Toast.makeText(MainActivity.this,df.format(date),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onMonthChanged(Date date){
                SimpleDateFormat df=new SimpleDateFormat("MM-yyyy");
                Toast.makeText(MainActivity.this,df.format(date),Toast.LENGTH_SHORT).show();
        }
});
```

## Using Custom TypeFace

```java
//Setting custom font
final Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/Arch_Rival_Bold.ttf");
if(null!=typeface){
    calendarView.setCustomTypeface(typeface);
    calendarView.refreshCalendar(currentCalendar);
}
```

Custom Calendar View Library in Android Custom Font

## Using Day Decorators

```java
//adding calendar day decorators
List decorators=new ArrayList<>();
        decorators.add(new ColorDecorator());
        calendarView.setDecorators(decorators);
        calendarView.refreshCalendar(currentCalendar);
        Custom Calendar View Library in Android Decorator
```
