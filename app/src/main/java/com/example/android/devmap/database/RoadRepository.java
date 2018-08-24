package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class RoadRepository {
    private RoadDao mRoadDao;
    private LiveData<List<Road>> mALlRoads;

    RoadRepository(Application application) {
        RoadStageGoalDatabase db = RoadStageGoalDatabase.getDatabase(application);
        mRoadDao = db.roadDao();
        mALlRoads = mRoadDao.getLiveAllMaps();
    }

    LiveData<List<Road>> getAllMaps() { return mALlRoads; }
}


