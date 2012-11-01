package jp.mixi.androidstudy01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * TODO: Implement this class to show dialog that contains title, message, and yes/no buttons.
 * TODO: タイトル、メッセージ、はい／いいえボタンのあるダイアログを表示するための実装をしてください。
 *
 * Reference: http://developer.android.com/reference/android/app/Fragment.html
 * @author keishin.yokomaku
 */
public class MainDialogFragment extends DialogFragment {
    private static final String ARG_POSITION = "position";
    private static final String ARG_NEGATIVE = "negative";
    private static final String ARG_POSITIVE = "positive";
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_TITLE = "title";
    public static final String TAG = MainDialogFragment.class.getSimpleName();

    /**
     * Fragmentを継承するクラスには、空のpublicなデフォルトコンストラクタを定義する必要があります。
     *
     * <blockquote>
     * すべてのFragmentを継承する子クラスは、必ず空のpublicなコンストラクタを定義する必要があります。
     * これは、フレームワークがしばしば、Fragmentクラスを再インスタンス化する場合があるためです。特に、
     * 状態を復帰する目的で、Fragmentをインスタンス化しようとするために、このコンストラクタが必要です。
     * もし空のっコンストラクタが見つからない場合、状態を復帰しようとして実行時例外が投げられることがあります。
     * </blockquote>
     *
     * フレームワークが、破棄されたFragmentを再インスタンス化する際には、
     * {@link Fragment#instantiate(Context, String, Bundle)}を利用します。
     * このメソッドは、フラグメントをインスタンス化するために空のコンストラクタを呼び出しています。
     * このため、空のコンストラクタに引数を渡すことで、フラグメントに何かしらの値を渡すことはできません。
     * また、このメソッドの中で実施される再インスタンス化処理のプロセスでは、いかなるsetterメソッドも呼び出されない（呼び出せない）ため
     * setterメソッド経由でFragmentに値を渡して初期化することもできません。
     *
     * もしFragmentに何かしらの値を渡して初期化したい場合は、{@link Fragment#setArguments(Bundle)}を使います。
     * ここで渡す{@link Bundle}オブジェクトは、再インスタンス化の時にもFragmentに渡されます。
     *
     * We always need to declare an empty constructor in a class that extends {@link Fragment}.
     *
     * <blockquote>
     * All subclasses of Fragment must include a public empty constructor. 
     * The framework will often re-instantiate a fragment class when needed,
     * in particular during state restore,
     * and needs to be able to find this constructor to instantiate it.
     * If the empty constructor is not available,
     * a runtime exception will occur in some cases during state restore.
     * </blockquote>
     *
     * This is because android framework will re-instantiate a destroyed fragment using
     * {@link Fragment#instantiate(Context, String, Bundle)}.
     * This method will call an empty constructor of a fragment to instantiate,
     * so that we cannot pass any values to the fragment via constructors that accepts arguments.
     * Also, setter methods will not be called during re-instantiation, so do not pass any values
     * through setter methods.
     *
     * If you would like to pass some values to the fragment, use {@link Fragment#setArguments(Bundle)}.
     * The {@link Bundle} object that comes from this method will be used during fragment re-instantiation.
     *
     * Reference： http://y-anz-m.blogspot.jp/2012/04/androidfragment-setarguments.html
     */
    public MainDialogFragment() {}

    /**
     * Create a new instance of this fragment.
     *
     * @param title the title of this dialog
     * @param message the message of this dialog
     * @return {@link MainDialogFragment} instance
     */
    public static MainDialogFragment newInstance(int title, int message, int positive, int negative, int position) {
        MainDialogFragment fragment = new MainDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TITLE, title);
        args.putInt(ARG_MESSAGE, message);
        args.putInt(ARG_POSITIVE, positive);
        args.putInt(ARG_NEGATIVE, negative);
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * <blockquote>
     * onAttach(Activity) はFragmentが、Activityと紐付いた時に呼ばれます。
     * </blockquote>
     *
     * もしこのFragmentがActivityに対してコールバックする必要が有る場合には、
     * Listenerインタフェースを定義して、それをActivityに実装させます。
     * コールバックを呼ぶときは、ここで対象のActivityへの参照を保存しておいて、
     * その参照からコールバックを呼び出します。
     *
     * <blockquote>
     * onAttach(Activity) called once the fragment is associated with its activity.
     * </blockquote>
     *
     * If this fragment should call back something to the activity,
     * you should declare a listener interface and a activity that attaches this fragment
     * implement it. And store the listener object on this method like this.
     *
     * {@code}
     * try {
     *     mListener = (ListenerInterface) activity;
     * } catch (ClassCastException e) {
     *     throw new IllegalArgumentException("The activity should implement listener interface!", e);
     * }
     * {@code}
     */
    @Override
    public void onAttach(Activity activity) {
        Log.v(TAG, "onAttach");
        super.onAttach(activity);
    }

    /**
     * <blockquote>
     * システムは、Fragmentを作るときに、onCreate(Bundle)を呼び出します。
     * このコールバックメソッドでは、Fragmentに必要なコンポーネントの初期化を行います。
     * </blockquote>
     *
     * <blockquote>
     * The system calls this when creating the fragment.
     * Within your implementation, you should initialize essential components of the fragment
     * that you want to retain when the fragment is paused or stopped, then resumed.
     *
     * onCreate(Bundle) called to do initial creation of the fragment.
     * </blockquote>
     *
     * @param savedInstanceState saved fragment state before the fragment destroyed.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    /**
     * Fragmentのレイアウトを作ります。
     * DialogFragmentの場合、{@link Dialog}オブジェクトを作成するときは、このメソッドは必ずnullを返すようにします。
     * Dialogオブジェクトを使わず、単純なレイアウトを配置する場合は、このメソッドでそのレイアウトを作成して返すようにします。
     *
     * Create a layout of this fragment.
     * To create a {@link Dialog} object such as progress indicator, this method should return null.
     * Reference: http://y-anz-m.blogspot.jp/2011/12/androiddialogfragment.html
     *
     * <blockquote>
     * システムは、Fragmentが最初にUIを描画する時に、onCreateView(LayoutInflater, ViewGroup, Bundle)を呼び出します。
     * UIを描画するFragmentは、必ずこのメソッドは、Fragmentのレイアウトの一番親にあたるViewオブジェクトを返す必要があります。
     * nullを返すことで、UIを持たないFragmentを作ることもできます。
     * </blockquote>
     *
     * <blockquote>
     * The system calls this when it's time for the fragment to draw its user interface for the first time.
     * To draw a UI for your fragment, you must return a View from this method
     * that is the root of your fragment's layout.
     * You can return null if the fragment does not provide a UI.
     *
     * onCreateView(LayoutInflater, ViewGroup, Bundle) creates and returns the view hierarchy
     * associated with the fragment.
     * </blockquote>
     *
     * @param inflater the layout object creator.
     * @param container the layout that contains this dialog.
     * @param savedInstanceState saved fragment state before the fragment destroyed.
     * @return {@link View} object of this dialog.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(TAG, "onCreateView");
        return null;
    }

    /**
     * {@link Dialog}オブジェクトを作成します。Dialogオブジェクトには、例えばProgressDialogやAlertDialogなどのものがあります。
     * テーマや、中身のViewを設定するだけの単純なレイアウトであれば、このメソッドは使わずに
     * {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}を使います。
     *
     * Create a {@link Dialog} object such as progress indicator, or alert dialog and so on.
     * If you would like to create a simple layout(just set theme and content view),
     * use {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)} instead.
     *
     * @param savedInstanceState saved fragment state before the fragment destroyed.
     * @return {@link Dialog} object.
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.v(TAG, "onCreateDialog");
        Bundle args = getArguments();
        int title = args.getInt(ARG_TITLE);
        int message = args.getInt(ARG_MESSAGE);
        int positive = args.getInt(ARG_POSITIVE);
        int negative = args.getInt(ARG_NEGATIVE);
        final int position = args.getInt(ARG_POSITION);
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positive, new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DialogCallbacks host;
                        try {
                            host = (DialogCallbacks) getActivity();
                        } catch (ClassCastException e) {
                            throw new IllegalStateException("Activity should implement dialog callback interface.");
                        }
                        host.onPositiveClick(position);
                        dismiss();
                    }
                })
                .setNegativeButton(negative, new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                })
                .create();
        return dialog;
    }

    /**
     * <blockquote>
     * Fragmentが紐付いているActivityの{@link Activity#onCreate(Bundle)}の処理が終わると、
     * onActivityCreated(Bundle)が呼ばれます。(ActivityのContextを得るのはこれ以後のライフサイクルメソッドが良いです。)
     * </blockquote>
     *
     * <blockquote>
     * onActivityCreated(Bundle) tells the fragment that
     * its activity has completed its own {@link Activity#onCreate(Bundle)}.
     * Prefer to obtain activity context after this method is called.
     * </blockquote>
     *
     * @param savedInstanceState saved fragment state before the fragment destroyed.
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.v(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * <blockquote>
     * onStart()以後、Fragmentはユーザに見える状態にになります。
     * </blockquote>
     *
     * <blockquote>
     * onStart() makes the fragment visible to the user
     * (based on its containing activity being started).
     * </blockquote>
     */
    @Override
    public void onStart() {
        Log.v(TAG, "onStart");
        super.onStart();
    }

    /**
     * <blockquote>
     * onResume()以後、Fragmentはユーザの操作を受け付けることができるようになります。
     * </blockquote>
     *
     * <blockquote>
     * onResume() makes the fragment interacting with the user
     * (based on its containing activity being resumed).
     * </blockquote>
     */
    @Override
    public void onResume() {
        Log.v(TAG, "onResume");
        super.onResume();
    }

    /**
     * メモリ不足や画面回転などの理由でFragmentが破棄されても復帰可能とするために
     * Fragmentの状態を一時保存する目的でonSaveInstanceState(Bundle)が呼ばれます。
     * 保存したい状態は、引数の{@link Bundle}オブジェクトに保存します。
     * このBundleオブジェクトは、Bundleオブジェクトを受け付ける様々なライフサイクルメソッドで受け取ることができます。
     * 例えば、{@link Fragment#onCreate(Bundle)}や、
     * {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}、
     * {@link DialogFragment#onCreateDialog(Bundle)}、
     * {@link Fragment#onActivityCreated(Bundle)}が該当します。
     *
     * これらのメソッドで受け取るBundleオブジェクトには、以前onSaveInstanceState(Bundle)で保存した状態が格納されています。
     *
     * To save temporary states of this fragment,
     * put them into a {@link Bundle} object.
     * It can be restored in methods such as {@link Fragment#onCreate(Bundle)},
     * {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)},
     * {@link DialogFragment#onCreateDialog(Bundle)}, or
     * {@link Fragment#onActivityCreated(Bundle)}.
     *
     * All these methods accepts a {@link Bundle} argument
     * that contains previously saved states in this method.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.v(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    /**
     * <blockquote>
     * ユーザが画面遷移などでFragmentから去ることを最初に通知するものとして、システムはonPause()を呼び出します。
     * ただしこれは、即ちFragmentが破棄されつつあることを意味するものではありません。
     * ここでは、ActivityのContextなどを超える、永続化すべきデータを保存しておきます(ユーザが戻ってこないこともあるため)。
     *
     * onPause()が呼ばれたら、Fragmentはユーザの操作を受け付けなくなります。これは、Activity#onPause()が呼ばれた後に
     * Fragment#onPasuse()が呼ばれるため、Activityもまた操作を受け付けなくなるからです。
     * </blockquote>
     *
     * <blockquote>
     * The system calls this method as the first indication that the user is leaving the fragment
     * (though it does not always mean the fragment is being destroyed).
     * This is usually where you should commit any changes that should be persisted
     * beyond the current user session (because the user might not come back).
     *
     * onPause() fragment is no longer interacting with the user
     * either because its activity is being paused
     * or a fragment operation is modifying it in the activity.
     * </blockquote>
     */
    @Override
    public void onPause() {
        Log.v(TAG, "onPause");
        super.onPause();
    }

    /**
     * <blockquote>
     * onStop()実行後は、Fragmentがユーザから見えなくなります。
     * これはFragmentが紐付くActivityも、onStop()が実行されユーザから見えなくなるためです。
     * </blockquote>
     *
     * <blockquote>
     * onStop() fragment is no longer visible to the user
     * either because its activity is being stopped
     * or a fragment operation is modifying it in the activity.
     * </blockquote>
     */
    @Override
    public void onStop() {
        Log.v(TAG, "onStop");
        super.onStop();
    }

    /**
     * <blockquote>
     * onDestroyView()が呼ばれたら、FragmentはViewに紐付くリソースの開放を行います。
     * </blockquote>
     *
     * <blockquote>
     * onDestroyView() allows the fragment to clean up resources associated with its View.
     * </blockquote>
     */
    @Override
    public void onDestroyView() {
        Log.v(TAG, "onDestroyView");
        super.onDestroyView();
    }

    /**
     * onDestroy()が呼ばれるのは、Fragmentがもはや使われなくなる時です。
     * メモリリークを防ぐため、Listenerオブジェクトなどの参照を切る必要があります。
     *
     * <blockquote>
     * onDestroy()は、Fragmentを何時でもメモリから破棄できる状態にするための最後の処理を行う場所です。
     * </blockquote>
     *
     * This method will be called when this fragment is no longer used.
     * To avoid memory leak, you should release references such as listener object.
     *
     * <blockquote>
     * onDestroy() called to do final cleanup of the fragment's state.
     * </blockquote>
     */
    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");
        super.onDestroy();
    }

    /**
     * <blockquote>
     * onDetach()は、Activityとの紐付きがなくなったときに呼ばれます。
     * </blockquote>
     *
     * <blockquote>
     * onDetach() called immediately prior to the fragment no longer being associated with its activity.
     * </blockquote>
     */
    @Override
    public void onDetach() {
        Log.v(TAG, "onDetach");
        super.onDetach();
    }

    public static interface DialogCallbacks {
        public void onPositiveClick(int position);
        public void onNegativeClick();
    }
}