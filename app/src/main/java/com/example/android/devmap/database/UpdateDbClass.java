package com.example.android.devmap.database;

import android.content.Context;
import android.os.AsyncTask;

public class UpdateDbClass extends AsyncTask<Goal, Void, Void> {
    Context c;

    public UpdateDbClass(Context context) {
        c = context;
    }


    @Override
    protected Void doInBackground(Goal... goals) {
        Goal g = goals[0];
        RoadStageGoalDatabase.updateGoal(g, RoadStageGoalDatabase.getDatabase(c));
        return null;
    }
}
