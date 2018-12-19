package com.github.elwinbran.bucketlist;

import android.support.annotation.NonNull;

/**
 * Represents an item on a bucket list: has a title and a description.
 *
 * @author Elwin Slokker
 */
public class BucketListItem
{
    final private String title;

    final private String description;

    final private Boolean completed;

    public BucketListItem(@NonNull String title, @NonNull String description,  @NonNull Boolean completed)
    {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String title()
    {
        return this.title;
    }

    public String description()
    {
        return this.description;
    }

    public Boolean completed()
    {
        return this.completed;
    }
}
