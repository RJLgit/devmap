package com.example.android.devmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RoadMapActivity extends AppCompatActivity implements StagesAdapter.ListItemClickListener {
    private StagesAdapter myAdapter;
    RecyclerView myRecyclerView;
    private AppData appData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_map);
        myRecyclerView = (RecyclerView) findViewById(R.id.stages_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);

        appData = new AppData();
        appData.populateData();


        myAdapter = new StagesAdapter(this, this, appData.getStages());

        myRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onListItemClick(int index) {
        Intent i = new Intent(this, GoalsActivity.class);
        i.putStringArrayListExtra("Goals", appData.getStages().get(index).getGoals());
        startActivity(i);
    }
}
