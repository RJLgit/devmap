package com.example.android.devmap.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Goal.class, Stage.class, Road.class}, version = 1)
public abstract class RoadStageGoalDatabase extends RoomDatabase{
    public abstract GoalDao goalDao();
    public abstract StageDao stageDao();
    public abstract RoadDao roadDao();
    private static RoadStageGoalDatabase INSTANCE;

    public static RoadStageGoalDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoadStageGoalDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoadStageGoalDatabase.class, "roadMap_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }

}
