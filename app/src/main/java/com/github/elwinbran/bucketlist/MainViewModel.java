package com.github.elwinbran.bucketlist;

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * The implementation of a view model for {@link BucketListItem}.
 *
 * @author Elwin Slokker
 */
public class MainViewModel extends GenericCRUDViewModel<BucketListItem>
{

    final private GenericRepository<BucketListItem> repository;

    final private LiveData<List<BucketListItem>> items;

    public MainViewModel(GenericRepository<BucketListItem> repository, LiveData<List<BucketListItem>> items)
    {
        this.repository = repository;
        this.items = items;
    }

    @Override
    public LiveData<List<BucketListItem>> getModels()
    {
        return items;
    }

    @Override
    public void insert(BucketListItem model)
    {
        this.repository.insert(model);
    }

    @Override
    public void update(BucketListItem model)
    {
        this.repository.update(model);
    }

    @Override
    public void delete(BucketListItem model)
    {
        this.repository.delete(model);
    }
}
