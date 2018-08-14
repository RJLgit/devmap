package com.example.android.devmap.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "stage_table")
public class Stage {

    @PrimaryKey
    private int id;

    @ColumnInfo(name="name")
    private String mName;

    @ColumnInfo(name="summary")
    private String mSummary;

    @ColumnInfo(name="road_map_reference")
    private int mRoadMapReference;


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
