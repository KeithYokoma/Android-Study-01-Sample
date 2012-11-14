package jp.mixi.androidstudy01.diary.entity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import jp.mixi.androidstudy01.entity.ComposeEntity;

import java.io.FileDescriptor;

/**
 * 日記のコンテンツを表現するEntityクラスです。
 *
 * Intentのextraオブジェクトや、Bundleにこのクラスのオブジェクトを入れたり、
 * IPCでやり取りされるメッセージにこのクラスのオブジェクトを含めるためには、Parcelableインタフェースを実装する必要があります。
 *
 * An entity class of diary content.
 *
 * For the convenience to send message through {@link Intent} or {@link Bundle}, or do some IPC request,
 * the object that is put into the message should implement {@link Parcelable} interface.
 *
 * @author keishin.yokomaku
 */
public class DiaryEntity implements ComposeEntity {
    /**
     * Parcleableインタフェースを実装したクラスでは、Creator<T>オブジェクトの定数として、CREATORを定義する必要があります。
     * この定数は、Parcelableオブジェクトをインスタンス化するためにフレームワークが使用します。
     *
     * {@link Parcelable} classes must have a public static {@link Parcelable.Creator} constant.
     * This constant is used to generate an instance of this {@link Parcelable} object.
     */
    public static final Creator<DiaryEntity> CREATOR = new Creator<DiaryEntity>() {
        @Override
        public DiaryEntity[] newArray(int size) {
            return new DiaryEntity[size];
        }

        public DiaryEntity createFromParcel(Parcel source) {
            return new DiaryEntity(source);
        }
    };
    /**
     * Androidのコーディングガイドラインでは、private変数には接頭辞として"m"をつけます。
     *
     * Add "m" prefix to a private member according to android code style guideline.
     */
    private String mTitle;
    private String mBody;
    private long mPostDate;

    /**
     * Parcelオブジェクトからメンバ変数を初期化します。
     *
     * Read the member back in from a {@link Parcel}.
     * @param in {@link Parcel} object contains saved member data
     */
    public DiaryEntity(Parcel in) {
        mTitle = in.readString();
        mBody = in.readString();
        mPostDate = in.readLong();
    }

    private DiaryEntity() {}

    public static final DiaryEntity.Builder getBuilder() {
        return new DiaryEntity.Builder();
    }

    /**
     * 大抵の場合、このメソッドは0を返して問題ありません。
     * {@link FileDescriptor}を使用する場合には、{@link Parcelable#CONTENTS_FILE_DESCRIPTOR}を返す必要があります。
     *
     * Usually, this method should always return 0.
     * When you put a {@link FileDescriptor}, this method should return
     * {@link Parcelable#CONTENTS_FILE_DESCRIPTOR}.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * このクラスのメンバ変数をParcelオブジェクトに書き出します。
     * 書きだす順番と、読みだす順番は同じである必要があります。
     *
     * Write all members of this class to a {@link Parcel} object.
     * It doesn't matter which order you write the objects,
     * so long as you read them back in in the same order.
     *
     * @param dest {@link Parcel} object to save members.
     * @param flags Additional flags about how the object should be written.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mBody);
        dest.writeLong(mPostDate);
    }

    public String getTitle() {
        return mTitle;
    }

    public String getBody() {
        return mBody;
    }

    public long getPostDate() {
        return mPostDate;
    }

    public static class Builder {
        private DiaryEntity mEntity;

        public Builder() {
            mEntity = new DiaryEntity();
        }

        public Builder setTitle(String value) {
            mEntity.mTitle = value;
            return this;
        }

        public Builder setBody(String value) {
            mEntity.mBody = value;
            return this;
        }

        public Builder setPostTime(long value) {
            mEntity.mPostDate = value;
            return this;
        }

        public DiaryEntity create() {
            return mEntity;
        }
    }
}