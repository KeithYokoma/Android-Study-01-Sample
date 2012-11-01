package jp.mixi.androidstudy01.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;

import jp.mixi.androidstudy01.MainActivity;
import jp.mixi.androidstudy01.diary.DiaryComposeActivity;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testCallMenu() {
        Activity activity = getActivity();
        // Set activity monitor to watch activity behaviour
        ActivityMonitor monitor = new ActivityMonitor(DiaryComposeActivity.class.getName(), null, false);
        getInstrumentation().addMonitor(monitor);

        // Robotium test framework
        Solo solo = new Solo(getInstrumentation(), activity);
        // Show options menu by send tapping menu key event
        solo.sendKey(Solo.MENU);
        // Search a text and tap view that contains the text
        solo.clickOnText(activity.getString(jp.mixi.androidstudy01.R.string.activity_main_menu_add));

        // Get target activity
        Activity target = getInstrumentation().waitForMonitorWithTimeout(monitor, 1000);
        // Target activity has been launched
        assertEquals(1, monitor.getHits());
        // Close the activity to proceed this test
        if (target != null) target.finish();
    }
}