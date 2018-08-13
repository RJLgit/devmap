package com.example.android.devmap.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "stage_table")
public class Stage {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="name")
    private String mName;

    @ColumnInfo(name="summary")
    private String mSummary;

    @ColumnInfo(name="road_map_reference")
    private int mRoadMapReference;


    public Stage(String name, String summary, int road){
        this.mName = name;
        this.mSummary = summary;
        this.mRoadMapReference = road;
    }

    public String getName() { return mName; }

    public String getmSummary() { return mSummary; }

    public int getRoadMapReference() { return mRoadMapReference; }
}
