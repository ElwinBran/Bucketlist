package com.github.elwinbran.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author Elwin Slokker
 */
public class AddActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstances)
    {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_add);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_item_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSave(view);
            }
        });
    }


    private void handleSave(View view)
    {
        TextView titleInput = findViewById(R.id.title_edit_text);
        TextView descriptionInput = findViewById(R.id.description_edit_text);
        String title = titleInput.getText().toString();
        String description = descriptionInput.getText().toString();

        if(title == null || title.isEmpty())
        {
            Toast.makeText(this, "Cannot save without title!", Toast.LENGTH_SHORT).show();
            titleInput.requestFocus();
        }
        else
        {
            if (description == null || description.isEmpty())
            {
                Toast.makeText(this, "Cannot save without description!", Toast.LENGTH_SHORT).show();
                descriptionInput.requestFocus();
            }
            else
            {
                persistData(title, description);
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
            }
        }
    }

    private void persistData(@NonNull String title, @NonNull String description)
    {
        BucketListItem newItem = new BucketListItem();
        newItem.setTitle(title);
        newItem.setDescription(description);
        newItem.setCompleted(false);
        AppDatabase db = AppDatabase.getInstance(this);
        BucketItemDAO dao = db.bucketItemDAO();
        dao.insertEntry(newItem);
    }
}
