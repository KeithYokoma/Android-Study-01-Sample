package jp.mixi.androidstudy01.test.diary;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import jp.mixi.androidstudy01.R;
import jp.mixi.androidstudy01.diary.DiaryComposeActivity;
import jp.mixi.androidstudy01.diary.entity.DiaryEntity;

/**
 * A functionality test for {@link DiaryComposeActivity}.
 * @author keishin.yokomaku
 */
public class DiaryComposeActivityTest extends ActivityInstrumentationTestCase2<DiaryComposeActivity> {
    public DiaryComposeActivityTest() {
        super(DiaryComposeActivity.class);
    }

    /**
     * Test method name should start with "test".
     * This is because android test framework is based on JUnit3.
     */
    public void testInputTitle() {
        final Activity activity = getActivity();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getInstrumentation().callActivityOnStart(activity);
            }
        });
        getInstrumentation().waitForIdleSync();

        final EditText title = (EditText) activity.findViewById(R.id.ComposeDiaryTitleInput);
        final TextView length = (TextView) activity.findViewById(R.id.ComposeDiaryTitleLength);
        assertEquals("", title.getText().toString());
        assertEquals("0 / 20", length.getText().toString());

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                title.setText("test");
            }
        });
        getInstrumentation().waitForIdleSync();

        assertEquals("test", title.getText().toString());
        assertEquals("4 / 20", length.getText().toString());
    }

    public void testInputBody() {
        final Activity activity = getActivity();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getInstrumentation().callActivityOnStart(activity);
            }
        });
        getInstrumentation().waitForIdleSync();

        final EditText body = (EditText) activity.findViewById(R.id.ComposeDiaryBodyInput);
        final TextView length = (TextView) activity.findViewById(R.id.ComposeDiaryBodyLength);
        assertEquals("", body.getText().toString());
        assertEquals("0 / 10000", length.getText().toString());

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                body.setText("test");
            }
        });
        getInstrumentation().waitForIdleSync();

        assertEquals("test", body.getText().toString());
        assertEquals("4 / 10000", length.getText().toString());
    }

    public void testPassIntent() {
        Intent intent = new Intent();
        DiaryEntity entity = DiaryEntity.getBuilder()
                .setTitle("test")
                .setBody("testtest")
                .create();
        intent.putExtra(DiaryComposeActivity.REQUEST_EXTRA_DIARY_ENTITY, entity);
        setActivityIntent(intent);

        final Activity activity = getActivity();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getInstrumentation().callActivityOnStart(activity);
            }
        });
        getInstrumentation().waitForIdleSync();

        final EditText body = (EditText) activity.findViewById(R.id.ComposeDiaryBodyInput);
        final TextView bodyLength = (TextView) activity.findViewById(R.id.ComposeDiaryBodyLength);
        final EditText title = (EditText) activity.findViewById(R.id.ComposeDiaryTitleInput);
        final TextView titleLength = (TextView) activity.findViewById(R.id.ComposeDiaryTitleLength);
        assertEquals("test", title.getText().toString());
        assertEquals("testtest", body.getText().toString());
        assertEquals("4 / 20", titleLength.getText().toString());
        assertEquals("8 / 10000", bodyLength.getText().toString());
    }
}