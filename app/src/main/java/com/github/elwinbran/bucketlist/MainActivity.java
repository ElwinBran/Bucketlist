package com.github.elwinbran.bucketlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * The entry point of the app.
 * The only screen of this app is the bucketlist.
 *
 * @author Elwin Slokker
 */
public class MainActivity extends AppCompatActivity
{

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

    }
}
