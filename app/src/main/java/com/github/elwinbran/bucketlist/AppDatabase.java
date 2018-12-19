package com.github.elwinbran.bucketlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {BucketListItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract BucketItemDAO bucketItemDAO();

    private final static String NAME_DATABASE = "bucket_list_db";

    //Static instance
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context)
    {
        if(sInstance == null)
        {
            sInstance = Room.databaseBuilder(context, AppDatabase.class,
                    NAME_DATABASE).allowMainThreadQueries().build();
        }
        return sInstance;
    }
}
