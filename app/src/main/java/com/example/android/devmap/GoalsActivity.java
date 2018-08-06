package com.example.android.devmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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

        myAdapter = new GoalsAdapter(this, this);
        myRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onListItemClick(int index) {
        Toast.makeText(this, "intent for goal details here", Toast.LENGTH_SHORT).show();
    }
}
