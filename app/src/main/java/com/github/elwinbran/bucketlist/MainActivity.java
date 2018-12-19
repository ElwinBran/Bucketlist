package com.github.elwinbran.bucketlist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * The entry point of the app.
 * The only screen of this app is the bucketlist.
 *
 * @author Elwin Slokker
 */
public class MainActivity extends AppCompatActivity
{

    private List<BucketListItem> bucketItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView bucketListView = findViewById(R.id.recycler_view_bucket_list);
        bucketListView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        BucketListAdapter adapter = new BucketListAdapter(null);
        bucketListView.setAdapter(adapter);

        FloatingActionButton addItemButton = findViewById(R.id.add_item_button);
        GenericRepository<BucketListItem> repository = null;
        GenericCRUDViewModel<BucketListItem> viewModel = null;
        viewModel.getReminders().observe(this, new Observer<List<BucketListItem>>()
        {
            @Override
            public void onChanged(@Nullable List<BucketListItem> items)
            {
                bucketItems = items;
                updateUI();
            }
        });

    }

    private void updateUI()
    {

    }
}
