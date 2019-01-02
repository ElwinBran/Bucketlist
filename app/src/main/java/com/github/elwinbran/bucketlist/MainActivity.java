package com.github.elwinbran.bucketlist;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * The entry point of the app.
 * The only screen of this app is the bucketlist.
 *
 * @author Elwin Slokker
 */
public class MainActivity extends AppCompatActivity
{

    static AppDatabase db;

    private List<BucketListItem> bucketItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getInstance(this);
        setContentView(R.layout.activity_main);
        final RecyclerView bucketListView = findViewById(R.id.recycler_view_bucket_list);
        bucketListView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Executor databaseThread = Executors.newSingleThreadExecutor();
        //int total = db.query("SELECT * FROM bucketListItem", null).getCount();
        //Log.d("none", Integer.toString(total));
        BucketItemDAO dao = db.bucketItemDAO();
        FloatingActionButton addItemButton = findViewById(R.id.add_item_button);
        GenericRepository<BucketListItem> repository = new BucketListRepository(dao, databaseThread);
        final GenericCRUDViewModel<BucketListItem> viewModel =
                new MainViewModel(repository, repository.getAllPersistables());
        //BucketListItem dingetjes =
        //       new BucketListItem("Vliegen", "Een klein vliegtuigje mogen besturen.",false);
        //viewModel.insert(dingetjes);
        //repository.insert(dingetjes);
        final ResetList dynamicItems = new ResetList(repository.getAllPersistables().getValue());
        viewModel.getModels().observe(this, new Observer<List<BucketListItem>>()
        {
            @Override
            public void onChanged(@Nullable List<BucketListItem> items)
            {
                bucketItems = items;
                dynamicItems.setList(items);
                bucketListView.getAdapter().notifyDataSetChanged();
                updateUI();
            }
        });
        //Log.d("none", viewModel.getModels().getValue().get(0).getTitle());

        BucketListAdapter adapter = new BucketListAdapter(dynamicItems, viewModel);
        bucketListView.setAdapter(adapter);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateUI()
    {

    }
}
