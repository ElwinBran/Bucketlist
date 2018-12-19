package com.github.elwinbran.bucketlist;

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 *
 * @author Elwin Slokker
 */
public interface GenericRepository<PersistableT>
{
    /**
     *
     * @return
     */
    public LiveData<List<PersistableT>> getAllPersistables();

    /**
     *
     * @param persistable
     */
    public void insert(PersistableT persistable);

    /**
     *
     * @param persistable
     */
    public void update(PersistableT persistable);

    /**
     *
     * @param persistable
     */
    public void delete(PersistableT persistable);
}
