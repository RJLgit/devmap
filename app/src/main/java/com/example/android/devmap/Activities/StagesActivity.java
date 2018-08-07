package com.example.android.devmap.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.devmap.R;
import com.example.android.devmap.data.RoadMapData;
import com.example.android.devmap.adapters.StagesAdapter;

public class StagesActivity extends AppCompatActivity implements StagesAdapter.ListItemClickListener {
    private StagesAdapter myAdapter;
    RecyclerView myRecyclerView;
    private RoadMapData roadMapData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages);
        myRecyclerView = findViewById(R.id.stages_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);

        roadMapData = new RoadMapData();
        roadMapData.populateData();


        myAdapter = new StagesAdapter(this, this, roadMapData.getStages());

        myRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onListItemClick(int index) {
        Intent i = new Intent(this, GoalsActivity.class);
        Intent intent = i.putExtra("Stage", roadMapData.getStages().get(index));
        startActivity(intent);
    }
}
