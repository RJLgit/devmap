package com.example.android.devmap.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.devmap.adapters.GoalsAdapter;
import com.example.android.devmap.R;
import com.example.android.devmap.data.StageData;

import java.util.List;

public class GoalsActivity extends AppCompatActivity implements GoalsAdapter.ListItemClickListener {
    private GoalsAdapter myAdapter;
    RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        myRecyclerView = findViewById(R.id.goals_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);

        Intent i = getIntent();
        //Need to add a check to check this is not null
        if (i.hasExtra("Stage")) {
            StageData stage = (StageData) i.getSerializableExtra("Stage");
            myAdapter = new GoalsAdapter(this, this, stage);
            myRecyclerView.setAdapter(myAdapter);
        }
    }

    @Override
    public void onListItemClick(int index) {
        Toast.makeText(this, "intent for goal details here", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(GoalsActivity.this, GoalSummaryActivity.class);

        startActivity(i);
    }
}
