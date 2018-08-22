package com.example.android.devmap.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StageDao {
    @Insert
    void insert(Stage stage);

    @Query("DELETE FROM stage_table")
    void deleteAll();

    @Query("SELECT * from stage_table ORDER BY id ASC")
    LiveData<List<Stage>> getAllStages();

    @Query("SELECT * from stage_table ORDER BY id ASC")
    List<Stage> getListStages();

    @Query("SELECT * from stage_table WHERE road_map_reference = :id ORDER BY id ASC")
    LiveData<List<Stage>> getMapStages(int id);

<<<<<<< HEAD
    @Query("UPDATE stage_table SET progress = :progress WHERE id = :id")
    void updateStage(String progress, int id);

    @Update
    void update(Stage stage);
=======
>>>>>>> origin/master

}
