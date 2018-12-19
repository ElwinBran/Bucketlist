package com.github.elwinbran.bucketlist;

import android.arch.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * The class that ties the ROOM Dao to a more generic and friendlier interface.
 *
 * @author Elwin Slokker
 */
public class BucketListRepository implements GenericRepository<BucketListItem>
{

    final private BucketItemDAO listDao;

    final private LiveData<List<BucketListItem>> bucketListItems;

    final private Executor executor;

    public BucketListRepository(BucketItemDAO listDao, Executor executor)
    {
        this.listDao = listDao;
        bucketListItems = this.listDao.getAllEntries();
        this.executor = executor;
    }

    @Override
    public LiveData<List<BucketListItem>> getAllPersistables()
    {
        return this.bucketListItems;
    }

    @Override
    public void insert(final BucketListItem persistable)
    {
        this.executor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                listDao.insertEntry(persistable);
            }
        });
    }

    @Override
    public void update(final BucketListItem persistable)
    {
        this.executor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                listDao.updateEntry(persistable);
            }
        });
    }

    @Override
    public void delete(final BucketListItem persistable)
    {
        this.executor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                listDao.deleteEntry(persistable);
            }
        });
    }
}
