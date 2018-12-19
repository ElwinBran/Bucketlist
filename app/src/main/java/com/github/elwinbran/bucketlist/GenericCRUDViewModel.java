package com.github.elwinbran.bucketlist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 *
 *
 * @param <ModelT>
 * @author Elwin Slokker
 */
public abstract class GenericCRUDViewModel<ModelT> extends ViewModel
{
    /**
     *
     * @return
     */
    public abstract LiveData<List<ModelT>> getReminders();

    /**
     *
     * @param reminder
     */
    public abstract void insert(ModelT reminder);

    /**
     *
     * @param reminder
     */
    public abstract void update(ModelT reminder);

    /**
     *
     * @param reminder
     */
    public abstract void delete(ModelT reminder);
}
