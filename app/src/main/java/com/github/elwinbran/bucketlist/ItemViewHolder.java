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
    final private CheckBox completionChecker;
    final private TextView title;
    final private TextView description;

    public ItemViewHolder(@NonNull View itemView)
    {
        super(itemView);
        completionChecker = itemView.findViewById(R.id.checkBox);
        title = itemView.findViewById(R.id.text_view_item_title);
        description = itemView.findViewById(R.id.text_view_item_description);
        completionChecker.setOnCheckedChangeListener(statusChanged());
    }

    public void setItem(BucketListItem model)
    {
        completionChecker.setChecked(model.getCompleted());
        title.setText(model.getTitle());
        description.setText(model.getDescription());
    }
}
