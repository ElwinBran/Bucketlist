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

    public BucketListItem(@NonNull String title, @NonNull String description)
    {
        this.title = title;
        this.description = description;
    }

    public String title()
    {
        return this.title;
    }

    public String description()
    {
        return this.description;
    }
}
