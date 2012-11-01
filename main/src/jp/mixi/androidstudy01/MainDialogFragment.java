package jp.mixi.androidstudy01;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * TODO: Implement this class to show dialog that contains title, message, and yes/no buttons.
 *
 * Reference: http://developer.android.com/reference/android/app/Fragment.html
 * @author keishin.yokomaku
 */
public class MainDialogFragment extends DialogFragment {
    private static final String ARG_NEGATIVE = "negative";
    private static final String ARG_POSITIVE = "positive";
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_TITLE = "title";
    public static final String TAG = MainDialogFragment.class.getSimpleName();

    /**
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
    public static MainDialogFragment newInstance(int title, int message, int positive, int negative) {
        MainDialogFragment fragment = new MainDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TITLE, title);
        args.putInt(ARG_MESSAGE, message);
        args.putInt(ARG_POSITIVE, positive);
        args.putInt(ARG_NEGATIVE, negative);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * <blockquote>
     * onAttach(Activity) called once the fragment is associated with its activity.
     * </blockquote>
     *
     * If this fragment should call back something to the activity,
     * you should declare a listener interface and a activity that attaches this fragment
     * implement it. And store the listener object on this method like this.
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
     * Create a layout of this fragment.
     * To create a {@link Dialog} object such as progress indicator, this method should return null.
     * Reference: http://y-anz-m.blogspot.jp/2011/12/androiddialogfragment.html
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
        // TODO implement me!
        return null;
    }

    /**
     * <blockquote>
     * onActivityCreated(Bundle) tells the fragment that
     * its activity has completed its own {@link Activity#onCreate()}.
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
     * onDestroyView() allows the fragment to clean up resources associated with its View.
     * </blockquote>
     */
    @Override
    public void onDestroyView() {
        Log.v(TAG, "onDestroyView");
        super.onDestroyView();
    }

    /**
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
     * onDetach() called immediately prior to the fragment no longer being associated with its activity.
     * </blockquote>
     */
    @Override
    public void onDetach() {
        Log.v(TAG, "onDetach");
        super.onDetach();
    }

    public static interface DialogCallbacks {
        public void onPositiveClick();
        public void onNegativeClick();
    }
}