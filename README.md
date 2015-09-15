# Custom-Calendar-View
To use the CustomCalendarView in your application, you first need to add the library to your application. You can do this by either from Gradle, Maven or by directly downloading the source code form GitHub.


## Features
Currently it supports the following features:
* Next and previous month navigation
* Allow various customization including background color for day, week and title
* Set custom typeface using setCustomTypeFace() method.
* Show hide next previous month overflow days
* Set custom day options for start day of week. By default it is set to Calendar.SUNDAY
* Unlimited customizations for day of the month using custom Decorators.
* Allow you to handle event when user changes month and day selection.

![alt text][logo]

[logo]: http://javatechig.com/wp-content/uploads/2015/09/Custom-Calendar-View-Android.png "Custom Calendar View Library in Android"

### Gradle
**Step 1** Add the JitPack repository to your build file. Add it in your build.gradle at the end of repositories.

```
  repositories {
    maven { url "https://jitpack.io" }
  }
```

**Step-2** Add the dependency in the form

```
dependencies {
    compile 'com.github.npanigrahy:Custom-Calendar-View:v1.0'
}
```
### Maven
```
<repository>
     <id>jitpack.io</id>
     <url>https://jitpack.io</url>
</repository>
```
**Step 2** Add the dependency in the form
```
<dependency>
     <groupId>com.github.npanigrahy</groupId>
     <artifactId>Custom-Calendar-View</artifactId>
     <version>v1.0</version>
</dependency>
```
### Sbt
**Step-1** Add it in your build.sbt at the end of resolvers:
```
resolvers += "jitpack" at "https://jitpack.io"
```
**Step-2** Add the dependency in the form
```
libraryDependencies += "com.github.npanigrahy" % "Custom-Calendar-View" % "v1.0"
```

## Using CustomCalendarView Library
The GitHub project source includes a sample application, that is used for demonstrating the various features currently supported by this library. Once the library is added to your project, you can include the CustomCalendarView into your activity/fragment layout using the following code snippets.

```
<com.imanoweb.calendarview.CustomCalendarView
	android:id="@+id/calendar_view"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"
	android:background="#ffffff">
</com.imanoweb.calendarview.CustomCalendarView>
```
The above code snippet will show the simple Calendar View with default design. Now, you can use the following attributes, to customize the appearance of calendar.
```
<com.imanoweb.calendarview.CustomCalendarView
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
        app:selectedDayBackgroundColor="@color/blue"
        app:titleLayoutBackgroundColor="@color/white"
        app:weekLayoutBackgroundColor="@color/white">
</com.imanoweb.calendarview.CustomCalendarView>
```
Let us now, initialize the calendar view to control the various other appearance and behavior of calendar using the following methods.
```
//Initialize CustomCalendarView from layout
calendarView = (CustomCalendarView) findViewById(R.id.calendar_view);

//Initialize calendar with date
Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

//Show Monday as first date of week
calendarView.setFirstDayOfWeek(Calendar.MONDAY);

//Show/hide overflow days of a month
calendarView.setShowOverflowDate(false);

//call refreshCalendar to update calendar the view
calendarView.refreshCalendar(currentCalendar);

//Handling custom calendar events
calendarView.setCalendarListener(new CalendarListener() {
    @Override
    public void onDateSelected(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Toast.makeText(MainActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMonthChanged(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
        Toast.makeText(MainActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
    }
});
```

## Using Custom TypeFace

```
//Setting custom font
final Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Arch_Rival_Bold.ttf");
if (null != typeface) {
    calendarView.setCustomTypeface(typeface);
    calendarView.refreshCalendar(currentCalendar);
}
```
Custom Calendar View Library in Android Custom Font

## Using Day Decorators
```
//adding calendar day decorators
List decorators = new ArrayList<>();
decorators.add(new ColorDecorator());
calendarView.setDecorators(decorators);
calendarView.refreshCalendar(currentCalendar);
Custom Calendar View Library in Android Decorator
```
<img src="http://javatechig.com/wp-content/uploads/2015/09/Custom-Calendar-View-Library-in-Android-Decorator.png" height="350">


If you enjoy this library, don’t forget to follow us on our twitter handle @javatechig.
