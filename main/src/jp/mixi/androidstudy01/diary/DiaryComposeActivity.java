package jp.mixi.androidstudy01.diary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import jp.mixi.androidstudy01.R;
import jp.mixi.androidstudy01.diary.entity.DiaryEntity;

public class DiaryComposeActivity extends FragmentActivity implements TextWatcher {
    public static final String RESULT_EXTRA_DIARY_ENTITY =
            "jp.mixi.androidstudy01.diary.resultExtraDiaryEntity";
    public static final String REQUEST_EXTRA_DIARY_ENTITY = 
            "jp.mixi.androidstudy01.diary.requestExtraDiaryEntity";
    public static final int TITLE_MAX_LENGTH = 20;
    public static final int BODY_MAX_LENGTH = 10000;
    private EditText mTitle;
    private EditText mBody;
    private TextView mTitleLength;
    private TextView mBodyLength;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_diary);

        mTitle = (EditText) findViewById(R.id.ComposeDiaryTitleInput);
        mBody = (EditText) findViewById(R.id.ComposeDiaryBodyInput);
        mTitleLength = (TextView) findViewById(R.id.ComposeDiaryTitleLength);
        mBodyLength = (TextView) findViewById(R.id.ComposeDiaryBodyLength);

        setTitleLengthIndicator(0);
        setBodyLengthIndicator(0);
    }

    @Override
    public void onStart() {
        super.onStart();
        // TODO add listener resources for the edit text views
    }

    @Override
    public void onStop() {
        // TODO release listener resources for the edit text views
        super.onStop();
    }

    @Override
    public void afterTextChanged(Editable s) {}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO update text length indicator text views' text
    }

    public void onSaveClick(View v) {
        Intent intent = new Intent();
        // TODO build composed result as DiaryEntity and put it into the intent.
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onCancelClick(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    private void setTitleLengthIndicator(int length) {
        mTitleLength.setText(getString(
                R.string.activity_compose_length, length, TITLE_MAX_LENGTH));
    }

    private void setBodyLengthIndicator(int length) {
        mBodyLength.setText(getString(
                R.string.activity_compose_length, length, BODY_MAX_LENGTH));
    }
}