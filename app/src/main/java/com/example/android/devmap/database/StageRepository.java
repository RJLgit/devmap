package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class StageRepository {
    private StageDao mStageDao;
    private LiveData<List<Stage>> mAllStages;

    StageRepository(Application application) {
        RoadStageGoalDatabase db = RoadStageGoalDatabase.getDatabase(application);
        mStageDao = db.stageDao();
        mAllStages = mStageDao.getAllStages();

    }

    LiveData<List<Stage>> getAllStages() {
        return mAllStages;
    }

    public void insert (Stage stage) {
        new insertAsyncTaskStage(mStageDao).execute(stage);
    }

    private static class insertAsyncTaskStage extends AsyncTask<Stage, Void, Void> {

        private StageDao mAsyncTaskDao;

        insertAsyncTaskStage(StageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Stage... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
