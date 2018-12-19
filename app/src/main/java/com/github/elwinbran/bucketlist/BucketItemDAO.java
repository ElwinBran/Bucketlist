package com.github.elwinbran.bucketlist;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 *
 * @author Elwin Slokker
 */
@Dao
public interface BucketItemDAO
{
    @Query("SELECT * FROM bucketListItem")
    public LiveData<List<BucketListItem>> getAllEntries();

    @Insert
    public void insertEntry(BucketListItem entry);

    @Delete
    public void deleteEntry(BucketListItem entry);

    @Update
    public void updateEntry(BucketListItem entry);
}
