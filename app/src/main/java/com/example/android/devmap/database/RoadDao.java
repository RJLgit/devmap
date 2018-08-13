package com.example.android.devmap.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RoadDao {
    @Insert
    void insert(Road roadMap);

    @Query("DELETE FROM road_table")
    void deleteAll();

    @Query("SELECT * from road_table ORDER BY id ASC")
    LiveData<List<Road>> getAllMaps();

}
