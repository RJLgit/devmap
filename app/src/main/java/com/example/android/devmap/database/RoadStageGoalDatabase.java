package com.example.android.devmap.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {Goal.class, Stage.class, Road.class}, version = 1)
public abstract class RoadStageGoalDatabase extends RoomDatabase{
    public abstract GoalDao goalDao();
    public abstract StageDao stageDao();
    public abstract RoadDao roadDao();
    private static RoadStageGoalDatabase INSTANCE = null;
    public static Road r = new Road("Android", "Android Dev pathway");
    public static Stage s = new Stage(1,"Stage 1", "Do xyz", 0);
    public static Stage s1 = new Stage(2,"Stage 2", "Do abc", 0);
    public static Stage s2 = new Stage(3,"Stage 3", "Do efg", 0);
    public static List<Goal> goals = new ArrayList<>();
    public static Goal g1 = new Goal("Goal 1","Goal 1 for stage 1", true, 1);
    public static Goal g2 = new Goal("Goal 2","Goal 2 for stage 1", false, 1);
    public static Goal g3 = new Goal("Goal 3","Goal 3 for stage 1", true, 1);
    public static Goal g4 = new Goal("Goal 4","Goal 4 for stage 1", false, 1);
    public static Goal g5 = new Goal("Goal 5","Goal 1 for stage 2", true, 2);
    public static Goal g6 = new Goal("Goal 6","Goal 2 for stage 2", true, 2);
    public static Goal g7 = new Goal("Goal 7","Goal 3 for stage 2", false, 2);
    public static Goal g8 = new Goal("Goal 8","Goal 1 for stage 3", true, 3);
    public static Goal g9 = new Goal("Goal 9","Goal 2 for stage 3", true, 3);
    public static Goal g10 = new Goal("Goal 10","Goal 3 for stage 3", true, 3);

    public static RoadStageGoalDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoadStageGoalDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoadStageGoalDatabase.class, "roadMap_database").addCallback(sRoomDatabaseCallback).allowMainThreadQueries()
                            .build();

                }
            }
        }
        return INSTANCE;
    }



    public static void updateGoal(Goal goal) {
       INSTANCE.goalDao().update(goal);
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
            if (mRDao.getAllMaps().size() == 0) {

                mRDao.deleteAll();
                mGDao.deleteAll();
                mDao.deleteAll();

                mRDao.insert(r);

                mDao.insert(s);
                mDao.insert(s1);
                mDao.insert(s2);

                mGDao.insert(g1);
                mGDao.insert(g2);
                mGDao.insert(g3);
                mGDao.insert(g4);


                mGDao.insert(g5);
                mGDao.insert(g6);
                mGDao.insert(g7);


                mGDao.insert(g8);
                mGDao.insert(g9);
                mGDao.insert(g10);

                goals.add(g1);
                goals.add(g2);
                goals.add(g3);

                goals.add(g4);
                goals.add(g5);
                goals.add(g6);
                goals.add(g7);
                goals.add(g8);
                goals.add(g9);
                goals.add(g10);
            }

            return null;

        }

    }

}
