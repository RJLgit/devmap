package com.example.android.devmap.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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
                            RoadStageGoalDatabase.class, "roadMap_database").addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback()

    {

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }


    };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final StageDao mDao;
        private final GoalDao mGDao;
        private final RoadDao mRDao;

        PopulateDbAsync(RoadStageGoalDatabase db) {
            mDao = db.stageDao();
            mGDao = db.goalDao();
            mRDao = db.roadDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mRDao.deleteAll();
            mGDao.deleteAll();
            mDao.deleteAll();
            Road r = new Road("Android", "Android Dev pathway");
            mRDao.insert(r);
            Stage s = new Stage("Stage 1", "Do xyz", 0);
            Stage s1 = new Stage("Stage 2", "Do abc", 0);
            Stage s2 = new Stage("Stage 3", "Do efg", 0);
            mDao.insert(s);
            mDao.insert(s1);
            mDao.insert(s2);
            Goal g1 = new Goal("Goal 1","Goal 1 for stage 1", true, 0);
            Goal g2 = new Goal("Goal 2","Goal 2 for stage 1", false, 0);
            Goal g3 = new Goal("Goal 3","Goal 3 for stage 1", true, 0);
            Goal g4 = new Goal("Goal 4","Goal 4 for stage 1", false, 0);
            mGDao.insert(g1);
            mGDao.insert(g2);
            mGDao.insert(g3);
            mGDao.insert(g4);


            Goal g5 = new Goal("Goal 5","Goal 1 for stage 2", true, 1);
            Goal g6 = new Goal("Goal 6","Goal 1 for stage 2", true, 1);
            Goal g7 = new Goal("Goal 7","Goal 1 for stage 2", false, 1);
            mGDao.insert(g5);
            mGDao.insert(g6);
            mGDao.insert(g7);


            Goal g8 = new Goal("Goal 8","Goal 1 for stage 3", true, 2);
            Goal g9 = new Goal("Goal 9","Goal 2 for stage 3", true, 2);
            Goal g10 = new Goal("Goal 10","Goal 3 for stage 3", true, 2);
            mGDao.insert(g8);
            mGDao.insert(g9);
            mGDao.insert(g10);

            return null;

        }

    }

}
