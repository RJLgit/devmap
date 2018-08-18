package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

class StageRepository {
    private final StageDao mStageDao;
    private final LiveData<List<Stage>> mAllStages;
    private final List<Stage> mListStages;

    StageRepository(Application application) {
        RoadStageGoalDatabase db = RoadStageGoalDatabase.getDatabase(application);
        mStageDao = db.stageDao();
        mAllStages = mStageDao.getAllStages();
        mListStages = mStageDao.getListStages();

    }

    LiveData<List<Stage>> getAllStages() {
        return mAllStages;
    }
    List<Stage> getListStages() { return mListStages; }

    public void insert (Stage stage) {
        new insertAsyncTaskStage(mStageDao).execute(stage);
    }

    private static class insertAsyncTaskStage extends AsyncTask<Stage, Void, Void> {

        private final StageDao mAsyncTaskDao;

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
