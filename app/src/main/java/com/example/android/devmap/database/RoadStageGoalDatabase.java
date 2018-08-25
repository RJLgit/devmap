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
    public static Road r = new Road(0,"Front-End Web Development: Basics", "Learn the basics of front-end web development");
    public static Road r1 = new Road(1,"Back-end Web Development: Basics", "Learn the basics of back-end web development");
    public static Road r2 = new Road(2,"DevOps: Basics", "Learn the basics of DevOps");

    // RoadMap 0
    public static Stage s = new Stage(1,"HTML", "Basics of HTML", 0, "not started");
    public static Stage s1 = new Stage(2,"CSS", "Basics of CSS", 0, "not started");
    public static Stage s2 = new Stage(3,"JavaScript", "Basics of JavaScript", 0, "not started");
    public static Stage s3 = new Stage(4,"Test yourself", "Test your knowledge", 0, "not started");
    // RoadMap 1
    public static Stage s4 = new Stage(5,"Python", "Basics of Python", 1, "not started");
    public static Stage s5 = new Stage(6,"Java", "Basics of Java", 1, "not started");
    public static Stage s6 = new Stage(7,"GoLang", "Basics of Golang", 1, "not started");
    public static Stage s7 = new Stage(8,"Test yourself", "Test your knowledge", 1, "not started");
    // RoadMap 2
    public static Stage s8 = new Stage(9,"Programming Language", "Get some programming knowledge", 2, "not started");
    public static Stage s9 = new Stage(10,"OS concepts", "Learn about OS concepts", 2, "not started");
    public static Stage s10 = new Stage(11,"Servers", "Learn about managing servers", 2, "not started");
    public static Stage s11 = new Stage(12,"Test yourself", "Test your knowledge", 2, "not started");

    // RoadMAP 0
    // stage 1
    public static Goal g1 = new Goal("Goal 1","Learn the basics and how to write semantic HTML", false, 1);
    public static Goal g2 = new Goal("Goal 2","Dividing page into sections and how to structure the DOM properly", false, 1);
    public static Goal g3 = new Goal("Goal 3","Make at least 5 HTML pages - focus on structure", false, 1);
    //stage 2
    public static Goal g4 = new Goal("Goal 4","Learn the basics of CSS", false, 2);
    public static Goal g5 = new Goal("Goal 5","Learn how to use Grid and FlexBox", false, 2);
    public static Goal g6 = new Goal("Goal 6","Media Queries and Responsive websites", false, 2);
    public static Goal g7 = new Goal("Goal 7","Style the HTML Pages that you made in the last step", false, 2);
    //stage 3
    public static Goal g8 = new Goal("Goal 8","Learn the syntax and basic constructs", false, 3);
    public static Goal g9 = new Goal("Goal 9","Learn how to manipulate the DOM", false, 3);
    public static Goal g10 = new Goal("Goal 10","Understand the concepts such as hoisting, event bubbling, prototype etc", false, 3);
    public static Goal g11 = new Goal("Goal 11","Learn Ajax (XHR)", false, 3);
    public static Goal g12 = new Goal("Goal 12","Learn ES6+ new features and writing modular JavaScript", false, 3);
    //stage 4
    public static Goal g13 = new Goal("Goal 13","Make some responsive website and add some interactivity with JavaScript", false, 4);
    public static Goal g14 = new Goal("Goal 14","Search projects on github and open a few PRs", false, 4);
    public static Goal g15 = new Goal("Goal 15","Enhance the UI, make any demo pages responsive or improve the design", false, 4);
    public static Goal g16 = new Goal("Goal 16","Look for any open issues that you can solve", false, 4);
    public static Goal g17 = new Goal("Goal 17","Refactor any of the code or implement the best practices that you learn on the way", false, 4);
    // RoadMap 1
    // stage 5
    public static Goal g18 = new Goal("Goal 14","Make some responsive website and add some interactivity with JavaScript", false, 5);
    public static Goal g19 = new Goal("Goal 15","Make some responsive website and add some interactivity with JavaScript", false, 5);
    public static Goal g20 = new Goal("Goal 16","Make some responsive website and add some interactivity with JavaScript", false, 5);
    // stage 6
    public static Goal g21 = new Goal("Goal 17","Make some responsive website and add some interactivity with JavaScript", false, 6);
    public static Goal g22 = new Goal("Goal 18","Make some responsive website and add some interactivity with JavaScript", false, 6);
    public static Goal g23 = new Goal("Goal 19","Make some responsive website and add some interactivity with JavaScript", false, 6);
    // stage 7
    public static Goal g24 = new Goal("Goal 20","Make some responsive website and add some interactivity with JavaScript", false, 7);
    public static Goal g25 = new Goal("Goal 21","Make some responsive website and add some interactivity with JavaScript", false, 7);
    public static Goal g26 = new Goal("Goal 22","Make some responsive website and add some interactivity with JavaScript", false, 7);
    // stage 8
    public static Goal g27 = new Goal("Goal 23","Make some responsive website and add some interactivity with JavaScript", false, 8);
    public static Goal g28 = new Goal("Goal 24","Make some responsive website and add some interactivity with JavaScript", false, 8);
    public static Goal g29 = new Goal("Goal 25","Make some responsive website and add some interactivity with JavaScript", false, 8);
    // RoadMap 2
    // stage 9
    public static Goal g30 = new Goal("Goal 26","Make some responsive website and add some interactivity with JavaScript", false, 9);
    public static Goal g31 = new Goal("Goal 27","Make some responsive website and add some interactivity with JavaScript", false, 9);
    public static Goal g32 = new Goal("Goal 28","Make some responsive website and add some interactivity with JavaScript", false, 9);
    // stage 10
    public static Goal g33 = new Goal("Goal 29","Make some responsive website and add some interactivity with JavaScript", false, 10);
    public static Goal g34 = new Goal("Goal 29","Make some responsive website and add some interactivity with JavaScript", false, 10);
    public static Goal g35 = new Goal("Goal 29","Make some responsive website and add some interactivity with JavaScript", false, 10);
    // stage 11
    public static Goal g36 = new Goal("Goal 32","Make some responsive website and add some interactivity with JavaScript", false, 11);
    public static Goal g37 = new Goal("Goal 32","Make some responsive website and add some interactivity with JavaScript", false, 11);
    public static Goal g38 = new Goal("Goal 32","Make some responsive website and add some interactivity with JavaScript", false, 11);


    public static RoadStageGoalDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoadStageGoalDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),

                            RoadStageGoalDatabase.class, "roadMap_database").addCallback(sRoomDatabaseCallback)
                            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                            .build();

                }
            }
        }
        return INSTANCE;
    }


// It doesnt assign the correct stage on second load. Probably because the stage references get messed up. How does the update db method work in sql?
    public static void updateGoal(Goal goal, RoadStageGoalDatabase db) {
       db.goalDao().update(goal);
       // db.goalDao().updateGoal();
       int stageId = goal.getStageReference();
       //Stage res = null;
     /*  for (Stage ss: stages) {
           if (ss.getId() == stageId) {
               res = ss;
           }
       }*/
       int result = 0;
       String prog = "in progress";
       List<Goal> lg = db.goalDao().getListGoals(stageId);
       for (Goal g: lg) {
           if (g.getProgress()) {
               result = result + 1;
           }
       }
       if (result == 0) {
           prog = "not started";
       } else if (result == lg.size()) {
           prog = "completed";
       }

      // if (res != null) {
           //res.setProgress(prog);
      // }

      // if (res != null) {
           db.stageDao().updateStage(prog, stageId);
      // }
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
                // road map
                mRDao.insert(r);
                mRDao.insert(r1);
                mRDao.insert(r2);
                // stages
                mDao.insert(s);
                mDao.insert(s1);
                mDao.insert(s2);
                mDao.insert(s3);
                mDao.insert(s4);
                mDao.insert(s5);
                mDao.insert(s5);
                mDao.insert(s6);
                mDao.insert(s7);
                mDao.insert(s8);
                mDao.insert(s9);
                mDao.insert(s10);
                mDao.insert(s11);
                // road 0 stage 1
                mGDao.insert(g1);
                mGDao.insert(g2);
                mGDao.insert(g3);
                // road 0 stage 2
                mGDao.insert(g4);
                mGDao.insert(g5);
                mGDao.insert(g6);
                mGDao.insert(g7);
                // road 0 stage 3
                mGDao.insert(g8);
                mGDao.insert(g9);
                mGDao.insert(g10);
                mGDao.insert(g11);
                mGDao.insert(g12);
                // road 0 stage 4
                mGDao.insert(g13);
                mGDao.insert(g14);
                mGDao.insert(g15);
                mGDao.insert(g16);
                mGDao.insert(g17);
                // road 1 stage 5
                mGDao.insert(g18);
                mGDao.insert(g19);
                mGDao.insert(g20);
                // road 1 stage 6
                mGDao.insert(g21);
                mGDao.insert(g22);
                mGDao.insert(g23);
                // road 1 stage 7
                mGDao.insert(g24);
                mGDao.insert(g25);
                mGDao.insert(g26);
                // road 1 stage 8
                mGDao.insert(g27);
                mGDao.insert(g28);
                mGDao.insert(g29);
                // road 2 stage 9
                mGDao.insert(g30);
                mGDao.insert(g31);
                mGDao.insert(g32);
                // road 2 stage 10
                mGDao.insert(g33);
                mGDao.insert(g34);
                mGDao.insert(g35);
                // road 2 stage 11
                mGDao.insert(g36);
                mGDao.insert(g37);
                mGDao.insert(g38);

            }

            return null;

        }

    }


    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            database.execSQL(null);
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(null);

        }
    };

}
