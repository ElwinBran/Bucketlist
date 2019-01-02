package com.github.elwinbran.bucketlist;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

    private final CompoundButton.OnCheckedChangeListener statusChanged()
    {
        return new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                updateState(b);
            }
        };
    }

    private void updateState(Boolean newCompletionValue)
    {
        //TODO feedback to database
        if(newCompletionValue)
        {
            title.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            description.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        else
        {
            title.setPaintFlags(0);
            description.setPaintFlags(0);
        }
    }
}
