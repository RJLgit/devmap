package com.example.android.devmap.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.devmap.R;
import com.example.android.devmap.adapters.StagesAdapter;
import com.example.android.devmap.database.Goal;
import com.example.android.devmap.database.GoalViewModel;
import com.example.android.devmap.database.Stage;
import com.example.android.devmap.database.StageViewModel;
import com.example.android.devmap.settings.ThemeUtils;

import java.util.ArrayList;
import java.util.List;

public class StagesActivity extends AppCompatActivity implements StagesAdapter.ListItemClickListener {
    private StagesAdapter myAdapter;
    private RecyclerView myRecyclerView;
    private StageViewModel mStageViewModel;
    private GoalViewModel mGoalViewModel;
    private static final String TAG = "StagesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStageViewModel = ViewModelProviders.of(this).get(StageViewModel.class);
        mGoalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);
        mStageViewModel.getmAllStages().observe(this, new Observer<List<Stage>>() {
            @Override
            public void onChanged(@Nullable List<Stage> stages) {
                myAdapter.setStages(stages);
                myAdapter.setListOfLists(getListGoal());
            }
        });


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String s = sharedPreferences.getString(getString(R.string.pref_theme_key), getString(R.string.pref_theme_light_value));
        ThemeUtils.changeTheme(this, s);

        setContentView(R.layout.activity_stages);
        myRecyclerView = findViewById(R.id.stages_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);

        myAdapter = new StagesAdapter(this, this);

        myRecyclerView.setAdapter(myAdapter);



    }


    @Override
    public void onListItemClick(int index) {
        Intent i = new Intent(this, GoalsActivity.class);
        Intent intent = i.putExtra("Stage", index);
        startActivity(intent);
    }

    private List<List<Goal>> getListGoal() {
        List<Stage> listStage = mStageViewModel.getListStages();
        List<List<Goal>> listOfLists = new ArrayList<>();
        for (Stage stage : listStage) {
            int stageId = stage.getId();
            List<Goal> goalList = mGoalViewModel.getListGoals(stageId);
            listOfLists.add(goalList);
        }
        Log.d(TAG, "getListGoal: " + listOfLists);
        return listOfLists;
    }
}
