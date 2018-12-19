package com.github.elwinbran.bucketlist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Represents an item on a bucket list: has a getTitle and a getDescription.
 *
 * @author Elwin Slokker
 */
@Entity(tableName = "backlogEntry")
public class BucketListItem implements Parcelable
{
    public final static Parcelable.Creator<BucketListItem> CREATOR =
        new Parcelable.Creator<BucketListItem>()
        {
            public BucketListItem createFromParcel(Parcel in) {
                return new BucketListItem(in);
            }

            public BucketListItem[] newArray(int size) {
                return new BucketListItem[size];
            }
        };

    @PrimaryKey
    @NonNull
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "completed")
    private Boolean completed;

    public BucketListItem()
    {
        this.title = "";
    }

    public BucketListItem(Parcel in)
    {
        completed = in.readByte() != 0;
        description = in.readString();
        title = in.readString();
    }

    public BucketListItem(@NonNull String title, @NonNull String description,  @NonNull Boolean completed)
    {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getDescription()
    {
        return this.description;
    }

    public Boolean getCompleted()
    {
        return this.completed;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeByte((byte) (completed ? 1 : 0));
        parcel.writeString(this.description);
        parcel.writeString(this.title);
    }
}
