package com.github.elwinbran.bucketlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * The adapter for the bucket list element.
 *
 * @author Elwin Slokker
 */
public class BucketListAdapter extends RecyclerView.Adapter<ItemViewHolder>
{

    final private List<BucketListItem> items;

    public BucketListAdapter(@NonNull List<BucketListItem> items)
    {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View item = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.bucket_list_item, viewGroup, false);
        return new ItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i)
    {
        itemViewHolder.setItem(this.items.get(i));
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }
}
