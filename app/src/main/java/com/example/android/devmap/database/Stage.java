package com.example.android.devmap.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "stage_table")
public class Stage {

    @PrimaryKey
    private int id;

    @ColumnInfo(name="name")
    private final String mName;

    @ColumnInfo(name="summary")
    private final String mSummary;

    @ColumnInfo(name="road_map_reference")
    private final int mRoadMapReference;


    public Stage(int id, String mName, String mSummary, int mRoadMapReference){
        this.id = id;
        this.mName = mName;
        this.mSummary = mSummary;
        this.mRoadMapReference = mRoadMapReference;
    }

    public String getName() { return mName; }

    public String getSummary() { return mSummary; }

    public int getRoadMapReference() { return mRoadMapReference; }

    public int getId() { return id; }

    public void setId(int i) { id = i; }
}
