package com.github.elwinbran.bucketlist;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A weird hacky list wrapper that lets you swap the wrapped list.
 * Now this may just cause huge synchronization issues because it got exactly zero checks and tricks.
 *
 * @author Elwin Slokker
 */
public class ResetList implements List<BucketListItem>
{
    /**
     * The wrapped list that is currently the list that provides all behaviour.
     */
    private List<BucketListItem> currentWrappedList;

    /**
     * @param currentWrappedList The initial list to be used.
     */
    public ResetList(@NonNull List<BucketListItem> currentWrappedList)
    {
        setList(currentWrappedList);
    }

    public final void setList(@NonNull List<BucketListItem> currentWrappedList)
    {
        if(currentWrappedList == null)
        {
            this.currentWrappedList = Collections.EMPTY_LIST;
        }
        else
        {
            this.currentWrappedList = currentWrappedList;
        }
    }

    @Override
    public int size()
    {
        return this.currentWrappedList.size();
    }

    @Override
    public boolean isEmpty()
    {
        return this.currentWrappedList.isEmpty();
    }

    @Override
    public boolean contains( Object o)
    {
        return this.currentWrappedList.contains(o);
    }

    @Override
    public Iterator<BucketListItem> iterator()
    {
        return this.currentWrappedList.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return this.currentWrappedList.toArray();
    }

    @Override
    public <T> T[] toArray( T[] ts)
    {
        return this.currentWrappedList.toArray(ts);
    }

    @Override
    public boolean add(BucketListItem bucketListItem)
    {
        return this.currentWrappedList.add(bucketListItem);
    }

    @Override
    public boolean remove(Object o)
    {
        return this.currentWrappedList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection)
    {
        return this.currentWrappedList.containsAll(collection);
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends BucketListItem> collection)
    {
        return this.currentWrappedList.addAll(collection);
    }

    @Override
    public boolean addAll(int i, @NonNull Collection<? extends BucketListItem> collection)
    {
        return this.currentWrappedList.addAll(i, collection);
    }

    @Override
    public boolean removeAll( Collection<?> collection)
    {
        return this.currentWrappedList.removeAll(collection);
    }

    @Override
    public boolean retainAll( Collection<?> collection)
    {
        return this.currentWrappedList.retainAll(collection);
    }

    @Override
    public void clear()
    {
        this.currentWrappedList.clear();
    }

    @Override
    public BucketListItem get(int i)
    {
        return this.currentWrappedList.get(i);
    }

    @Override
    public BucketListItem set(int i, BucketListItem bucketListItem)
    {
        return this.currentWrappedList.set(i, bucketListItem);
    }

    @Override
    public void add(int i, BucketListItem bucketListItem)
    {
        this.currentWrappedList.add(i, bucketListItem);
    }

    @Override
    public BucketListItem remove(int i)
    {
        return this.currentWrappedList.remove(i);
    }

    @Override
    public int indexOf(Object o)
    {
        return this.currentWrappedList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return this.currentWrappedList.lastIndexOf(o);
    }

    @NonNull
    @Override
    public ListIterator<BucketListItem> listIterator()
    {
        return this.currentWrappedList.listIterator();
    }

    @NonNull
    @Override
    public ListIterator<BucketListItem> listIterator(int i)
    {
        return this.currentWrappedList.listIterator(i);
    }

    @NonNull
    @Override
    public List<BucketListItem> subList(int i, int i1)
    {
        return this.currentWrappedList.subList(i, i1);
    }
}
