package com.example.android.devmap.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.devmap.adapters.GoalsAdapter;
import com.example.android.devmap.R;
import com.example.android.devmap.database.Goal;
import com.example.android.devmap.database.GoalViewModel;
import com.example.android.devmap.settings.ThemeUtils;

import java.util.List;

public class GoalsActivity extends AppCompatActivity implements GoalsAdapter.ListItemClickListener, OnTaskCompleted {
    private GoalsAdapter myAdapter;
    RecyclerView myRecyclerView;
    private GoalViewModel mGoalViewModel;
    private int stageId;
    List<Goal> lg;

    @Override
    public void onTaskCompleted(List<Goal> goalss, int in) {
        this.lg = goalss;
        Intent i = new Intent(GoalsActivity.this, GoalSummaryActivity.class);
        Intent intent = i.putExtra("Goal", lg.get(in).getSummary());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //Need to add a check to check this is not null
        if (intent.hasExtra("Stage")) {
            stageId = intent.getIntExtra("Stage", 1);
        }

        mGoalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);

        mGoalViewModel.getGoals(stageId).observe(this, new Observer<List<Goal>>() {
            @Override
            public void onChanged(@Nullable List<Goal> goals) {
                myAdapter.setGoals(goals);
            }
        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String s = sharedPreferences.getString(getString(R.string.pref_theme_key), getString(R.string.pref_theme_light_value));
        ThemeUtils.changeTheme(this, s);
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

        new QueryDBClass(this, index).execute(stageId);

    }

    public class QueryDBClass extends AsyncTask<Integer, Void, List<Goal>> {
        private OnTaskCompleted listener;
        private int ind;

        public QueryDBClass(OnTaskCompleted l, int index) {
            this.listener = l;
            this.ind = index;
        }

        @Override
        protected List<Goal> doInBackground(Integer... integers) {
            return mGoalViewModel.getListGoals(integers[0]);

        }

        @Override
        protected void onPostExecute(List<Goal> goals) {
            super.onPostExecute(goals);
            listener.onTaskCompleted(goals, ind);
        }
    }
}
