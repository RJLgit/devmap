package com.example.android.devmap.database;

import android.os.AsyncTask;

public class UpdateDbClass extends AsyncTask<Goal, Void, Void> {
    @Override
    protected Void doInBackground(Goal... goals) {
        Goal g = goals[0];
        RoadStageGoalDatabase.updateGoal(g);
        return null;
    }
}
