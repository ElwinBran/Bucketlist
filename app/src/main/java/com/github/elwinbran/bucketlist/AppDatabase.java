package com.github.elwinbran.bucketlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * The singleton class that provides the ROOM database class.
 * At the same time it contains the interface of the database class.
 *
 */
@Database(entities = {BucketListItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    /**
     * @return Retrieves a DAO that provides access to the ROOM database entities.
     */
    public abstract BucketItemDAO bucketItemDAO();

    /**
     * Name of the Database.
     */
    private final static String NAME_DATABASE = "bucket_list_db";

    //Static instance
    private static AppDatabase sInstance;

    /**
     * Use this method to retrieve the only Database object.
     *
     * @param context ?
     * @return A fully functional {@code AppDatabase} object.
     */
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
