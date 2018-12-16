package com.github.elwinbran.bucketlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * The bucket list item representation.
 *
 * @author Elwin Slokker
 */
public class ItemViewHolder extends RecyclerView.ViewHolder
{
    final private View view;

    public ItemViewHolder(@NonNull View itemView)
    {
        super(itemView);
        view = itemView;
    }

    public void setItem(BucketListItem model)
    {
        TextView title = itemView.findViewById(R.id.text_view_item_title);
        TextView description = itemView.findViewById(R.id.text_view_item_description);
        title.setText(model.title());
        title.setText(model.description());
    }
}
