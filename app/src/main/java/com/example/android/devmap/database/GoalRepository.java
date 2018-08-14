package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class GoalRepository {
    private GoalDao mGoalDao;
    private LiveData<List<Goal>> mAllGoals;

    GoalRepository(Application application){
        RoadStageGoalDatabase db = RoadStageGoalDatabase.getDatabase(application);
        mGoalDao= db.goalDao();
        mAllGoals = mGoalDao.getAllGoals();
    }

    LiveData<List<Goal>> getAllGoals() { return mAllGoals;}

    public void insert (Goal goal) { new insertAsyncTaskGoal(mGoalDao).execute(goal);}

    private static class insertAsyncTaskGoal extends AsyncTask<Goal, Void, Void> {
        private GoalDao mAsyncTaskDao;

        insertAsyncTaskGoal(GoalDao dao) { mAsyncTaskDao = dao; }

        @Override
        protected Void doInBackground(final Goal... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}