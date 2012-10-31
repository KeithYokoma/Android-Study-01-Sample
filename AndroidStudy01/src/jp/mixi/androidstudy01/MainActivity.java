package jp.mixi.androidstudy01;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * TODO: implement this class to show data lists.
 *
 * Reference: http://developer.android.com/reference/android/app/Activity.html
 * @author keishin.yokomaku
 */
public class MainActivity extends FragmentActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Starting the entire lifetime of this {@link Activity} with this method.
     * Usually, this method should initialize of components such as views,
     * data that will be bound with list, and threads, etc.
     * Also, you should restore the activity's previously frozen state from {@link Bundle} object,
     * if there was one.
     *
     * @param savedInstanceState saved fragment state before the fragment destroyed.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // TODO implement me!
    }

    /**
     * Called after your activity has been stopped, prior to it being started again.
     * Always followed by onStart().
     */
    @Override
    public void onRestart() {
        Log.v(TAG, "onRestart");
        super.onRestart();
    }

    /**
     * Starting the visible lifetime of this {@link Activity} with this method.
     * The user can see the activity on-screen,
     * though it may not be in the foreground and interacting with the user.
     * You should maintain resources that are needed to show the activity to the user, such as
     * registering {@link BroadcastReceiver}, etc.
     */
    @Override
    public void onStart() {
        Log.v(TAG, "onStart");
        super.onStart();

        // TODO implement me!
    }

    /**
     * Starting the foreground lifetime of this {@link Activity} with this method.
     * The {@link Activity} comes in front of all other activities and interacting with the user.
     * An activity can frequently go between the resumed and paused states, so
     * the code in these methods should be fairly lightweight.
     */
    @Override
    public void onResume() {
        Log.v(TAG, "onResume");
        super.onResume();
    }

    /**
     * You should restore the activity's previously frozen state from {@link Bundle} object,
     * if there was one.
     *
     * @param savedInstanceState saved fragment state before the fragment destroyed.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.v(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);

        // TODO implement me!
    }

    /**
     * To save temporary states of this fragment,
     * put them into a {@link Bundle} object.
     * You can restore this state at {@link Activity#onCreate(Bundle)}, or
     * {@link Activity#onRestoreInstanceState(Bundle)}.
     * Both methods accept {@link Bundle} object argument and it contains the state.
     *
     * @param outState to save this activity's states
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.v(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

        // TODO implement me!
    }

    /**
     * Finishing the foreground lifetime of this {@link Activity}.
     * Commit unsaved state to persistent data, like put draft data into a {@link SharedPreferences} or
     * {@link ContentProvider}, or something may consuming CPU.
     * Implementations of this method must be very quick
     * because the next activity will not be resumed until this method returns.
     */
    @Override
    public void onPause() {
        Log.v(TAG, "onPause");
        super.onPause();
    }

    /**
     * Finishing the visible lifetime of this {@link Activity}.
     * This time the {@link Activity} is no longer visible to the user.
     * You should release resources from this {@link Activity}, such like
     * unregistering {@link BroadcastReceiver} or some listener objects.
     */
    @Override
    public void onStop() {
        Log.v(TAG, "onStop");
        super.onStop();

        // TODO implement me!
    }

    /**
     * Finishing the entire lifetime of this {@link Activity}.
     * Make sure all remaining resources is released, or stop running threads, etc.
     *
     * Note that this method is not always called by android framework. This can be occurred
     * when the application process is killed because other applications needs memory.
     */
    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");
        super.onDestroy();
    }

    /**
     * Creates context menu(long click menu).
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        Log.v(TAG, "onCreateContextMenu");
        super.onCreateContextMenu(menu, v, menuInfo);

        // TODO implement me!
    }

    /**
     * Dispatches functionality bound with each context menu item.
     *
     * @param item selected context menu object
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.v(TAG, "onContextItemSelected");
        return super.onContextItemSelected(item);

        // TODO implement me!
    }

    /**
     * Prepares menu items to show up options menu,
     * such like switching enable/disable menu items.
     * Options menu will be displayed when the "menu" key has been tapped.
     *
     * @param menu
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.v(TAG, "onPrepareOptionsMenu");
        return super.onPrepareOptionsMenu(menu);

        // TODO implement me!
    }

    /**
     * Displays options menu.
     *
     * @param menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v(TAG, "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);

        // TODO implement me!
    }

    /**
     * Dispatches functionality bound with each options menu item.
     *
     * @param item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v(TAG, "onOptionsItemSelected");
        return super.onOptionsItemSelected(item);

        // TODO implement me!
    }
}