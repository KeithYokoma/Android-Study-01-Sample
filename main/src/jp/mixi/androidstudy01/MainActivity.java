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
import android.widget.ListView;

import jp.mixi.androidstudy01.MainDialogFragment.DialogCallbacks;

/**
 * TODO: リストにデータを表示するよう実装してください。
 * TODO: implement this class to show data lists.
 *
 * Reference: http://developer.android.com/reference/android/app/Activity.html
 * @author keishin.yokomaku
 */
public class MainActivity extends FragmentActivity implements DialogCallbacks {
    public static final String TAG = MainActivity.class.getSimpleName();
    private EntityAdapter mAdapter;

    /**
     * onCreate(Bundle)からActivityのライフサイクルが始まります。
     * onCreate(Bundle)では、Viewオブジェクトや、リストにバインドされるデータや、非同期処理のためのスレッドの開始などの
     * Activityに必要なコンポーネントの初期化を行います。
     * 引数のBundleオブジェクトを用いて、以前に保存したActivityの状態を復帰するのもonCreate(Bundle)で行います。
     *
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

        mAdapter = new EntityAdapter(this);
        // TODO ListViewオブジェクトをレイアウトから取得してください。

        // TODO このままだと、ListViewが空の時にだけ出すべきViewが表示されたままになるので、
        // TODO 空の時だけ表示するようにしてください。

        // TODO このままだと、ListViewにList形式のデータを表示できないので、
        // TODO Adapterを渡してListViewがList形式のデータをもとにListViewに行のViewを追加できるようにしてください。
    }

    /**
     * ActivityがonStop()を呼ばれた後に、Activityを復帰しようとした場合に呼ばれます。
     * このメソッドの後は必ずonStart()が呼ばれます。
     *
     * Called after your activity has been stopped, prior to it being started again.
     * Always followed by onStart().
     */
    @Override
    public void onRestart() {
        Log.v(TAG, "onRestart");
        super.onRestart();
    }

    /**
     * onStart()から、Activityがユーザに見えるようになります。
     * ただし、まだActivityがフォアグラウンドに来ていたり、ユーザの操作を受け付けることができたりするとは限りません。
     * ユーザにActivityを見せるにあたって必要なリソースを管理します。
     *
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

        // TODO ListViewに、行を長押しした時のメニュー(ContextMenu)を表示するハンドラを登録してください
    }

    /**
     * onResume()から、Activityがフォアグラウンドに来て、ユーザの操作ができるようになります。
     * Activityは頻繁にResume状態からPaused状態へと遷移しますので、ここに重い処理は書かないようにします。
     *
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
     * Activityが破棄される前に{@link Bundle}オブジェクトに保存した状態をここで復帰します。
     *
     * You should restore the activity's previously frozen state from {@link Bundle} object,
     * if there was one.
     *
     * @param savedInstanceState saved fragment state before the fragment destroyed.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.v(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);

        // TODO Activityが破棄される前にAdapterが持っていたリストのデータを復帰してください。
    }

    /**
     * Activityを破棄する前に、一時保存しておくべき情報を{@link Bundle}オブジェクトに保存します。
     * 復帰するときは、{@link Activity#onRestoreInstanceState(Bundle)}か、あるいは{@link Activity#onCreate(Bundle)}
     * のBundleからも復帰することができます。
     *
     * To save temporary states of this activity,
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

        // TODO Activityを破棄する前に、Adapterが持っているリストのデータを一時保存してください。
    }

    /**
     * Activityがフォアグラウンドから去るタイミングがonPause()です。
     * 未保存で永続化すべきデータを、{@link SharedPreferences}や{@link ContentProvider}へ保存するなどをします。
     * このメソッドで行われる処理の実装は高速である必要があります。なぜなら、次にフォアグラウンドに来るActivityが、
     * このメソッドから返ってくるまで待ち状態になってしまうからです。
     *
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
     * ユーザに見えなくなるタイミングがonStop()です。
     * ユーザに見えなくなるので、onStart()で準備した各種リソースをここで開放します。
     *
     * Finishing the visible lifetime of this {@link Activity}.
     * This time the {@link Activity} is no longer visible to the user.
     * You should release resources from this {@link Activity}, such like
     * unregistering {@link BroadcastReceiver} or some listener objects.
     */
    @Override
    public void onStop() {
        Log.v(TAG, "onStop");
        super.onStop();

        // TODO このままではActivityがリークします。ListViewの長押しメニューの登録を解除してください。
    }

    /**
     * onDestroy()でActivityの寿命が尽きます。
     * onCreate()で開始したスレッドを止めるなど、残りのリソースの開放を行います。
     *
     * 注意すべき点として、onDestroy()は必ず呼ばれる保証があるメソッドではないことに気をつけなければなりません。
     * 他のアプリケーションがより多くのメモリを必要とした時に、このアプリケーションのプロセスがkillされるときには、
     * onDestroy()は呼ばれません。
     *
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
     * コンテキストメニューを作ります。
     *
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

        // TODO menuのxmlからコンテキストメニューを読み込んで、MenuInflater#inflate()します。
    }

    /**
     * コンテキストメニューで選択されたメニューに対応した処理を実行します。
     *
     * Dispatches functionality bound with each context menu item.
     *
     * @param item selected context menu object
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.v(TAG, "onContextItemSelected");
        return super.onContextItemSelected(item);

        // TODO 削除メニューかどうかを判定し、削除メニューだったら確認のダイアログを表示します。
        // TODO Show confirmation dialog when "delete" has been selected.

        // TODO 実行したい処理が終わったら、return trueしてください。
        // TODO Return true if successfully dispatched method.
    }

    /**
     * メニューキーで表示するメニューを表示する直前に呼ばれ、
     * メニューを有効化／無効化したりするような処理をここで行います。
     *
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
    }

    /**
     * メニューキーで表示するメニューを表示します。
     *
     * Displays options menu.
     *
     * @param menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v(TAG, "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);

        // TODO menuのxmlからメニューキーで表示するメニューを読み込んで、MenuInflater#inflate()します。
        // TODO 基本のやり方はコンテキストメニューと同じです。
    }

    /**
     * メニューキーで表示するメニューに対応する処理を実行します
     *
     * Dispatches functionality bound with each options menu item.
     *
     * @param item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v(TAG, "onOptionsItemSelected");
        return super.onOptionsItemSelected(item);

        // TODO コンテキストメニューと同じく、どのメニューが押されたかを見て処理を振り分けます。
        // TODO コンテキストメニューと同じく、実行したい処理が実行できたら、return trueします。
    }

    @Override
    public void onPositiveClick(int position) {
        // TODO 確認ダイアログのコールバックメソッドです。はい、を選択した時の処理をここに書きます。
        // TODO 指定されたpositionにあるオブジェクトを、AdapterがもっているListから削除してください。
    }

    @Override
    public void onNegativeClick() {}
}