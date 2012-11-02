package jp.mixi.androidstudy01.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.EditText;

import com.jayway.android.robotium.solo.Solo;

import jp.mixi.androidstudy01.MainActivity;
import jp.mixi.androidstudy01.R;
import jp.mixi.androidstudy01.diary.DiaryComposeActivity;

/**
 * A functionality test for main activity.
 * @author keishin.yokomaku
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testAddAndDeleteEntry() throws Exception {
        Activity activity = getActivity();

        // Set up activity monitor to watch activity behaviour
        ActivityMonitor monitor = new ActivityMonitor(DiaryComposeActivity.class.getName(), null, false);
        getInstrumentation().addMonitor(monitor);

        // Robotium test framework
        Solo soloMain = new Solo(getInstrumentation(), activity);
        // Show options menu by emulate tapping menu key
        soloMain.sendKey(Solo.MENU);
        // Tap options menu
        soloMain.clickOnText(activity.getString(R.string.activity_main_menu_add));

        // Get starting activity
        Activity compose = getInstrumentation().waitForMonitorWithTimeout(monitor, 1000);
        // Should be hit once
        assertEquals(1, monitor.getHits());
        if (compose == null) fail("did not start compose activity. unexpected situation.");

        // Control compose activity
        Solo soloCompose = new Solo(getInstrumentation(), compose);
        // Emulate tapping edit text
        soloCompose.clickOnEditText(0);
        // Tapping soft keyboard emulation
        soloCompose.sendKey(KeyEvent.KEYCODE_T);
        soloCompose.sendKey(KeyEvent.KEYCODE_S);
        EditText title = soloCompose.getEditText(0);
        assertEquals("ts", title.getText().toString());

        // Move to the next edit text
        soloCompose.clickOnEditText(1);
        soloCompose.sendKey(KeyEvent.KEYCODE_T);
        soloCompose.sendKey(KeyEvent.KEYCODE_S);
        soloCompose.sendKey(KeyEvent.KEYCODE_T);
        EditText body = soloCompose.getEditText(1);
        assertEquals("tst", body.getText().toString());

        // Save the diary, and returning it to main activity
        soloCompose.clickOnButton(compose.getString(R.string.activity_compose_diary_save));
        assertTrue(compose.isFinishing());

        // Find body text to prove the entity is actually added to the list.
        assertTrue(soloMain.searchText("tst"));

        // Tap the inserted entity
        soloMain.clickLongInList(0);
        // Context menu will be displayed
        assertTrue(soloMain.searchText(activity.getString(R.string.activity_main_context_menu_delete)));
        soloMain.clickOnText(activity.getString(R.string.activity_main_context_menu_delete));
        // Confirmation dialog will be displayed after tapping delete context menu
        assertTrue(soloMain.searchText(activity.getString(R.string.activity_main_context_menu_delete_title)));
        assertTrue(soloMain.searchText(activity.getString(R.string.activity_main_context_menu_delete_message)));
        // Negative button will do nothing
        soloMain.clickOnText(activity.getString(R.string.activity_main_context_menu_delete_negative));

        // Tap the inserted entity
        soloMain.clickLongInList(0);
        // Context menu will be displayed
        assertTrue(soloMain.searchText(activity.getString(R.string.activity_main_context_menu_delete)));
        soloMain.clickOnText(activity.getString(R.string.activity_main_context_menu_delete));
        // Confirmation dialog will be displayed after tapping delete context menu
        assertTrue(soloMain.searchText(activity.getString(R.string.activity_main_context_menu_delete_title)));
        assertTrue(soloMain.searchText(activity.getString(R.string.activity_main_context_menu_delete_message)));
        // Positive button will delete the entity
        soloMain.clickOnText(activity.getString(R.string.activity_main_context_menu_delete_positive));
        // Nothing is in the list, so empty view will be visible
        soloMain.searchText(activity.getString(R.string.activity_main_listview_empty));

        soloMain.finishOpenedActivities();
    }
}