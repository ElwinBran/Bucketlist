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
    public abstract LiveData<List<ModelT>> getModels();

    /**
     *
     * @param model
     */
    public abstract void insert(ModelT model);

    /**
     *
     * @param model
     */
    public abstract void update(ModelT model);

    /**
     *
     * @param model
     */
    public abstract void delete(ModelT model);
}
