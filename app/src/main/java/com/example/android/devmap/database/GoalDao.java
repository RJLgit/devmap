package com.example.android.devmap.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface GoalDao {
    @Insert
    void insert(Goal goal);

    @Query("DELETE FROM goal_table")
    void deleteAll();


    @Query("SELECT * from goal_table WHERE stage_map_reference = :id ORDER BY id ASC")
    LiveData<List<Goal>> getStageGoals(int id);

    @Query("SELECT * from goal_table WHERE stage_map_reference = :id ORDER BY id ASC")
    List<Goal> getListGoals(int id);


    //check id and column info. May have to manually assign id
    @Query("UPDATE goal_table SET progress = :mProgress WHERE id = :id")
    void updateGoal(Boolean mProgress, int id);

    @Update
    void update(Goal g);

}
