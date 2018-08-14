package com.example.android.devmap.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "road_table")
public class Road {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="name")
    private String mName;

    @ColumnInfo(name="summary")
    private String mSummary;

    public Road(String mName, String mSummary){
        this.mName = mName;
        this.mSummary = mSummary;
    }

    public String getName() { return mName; }

    public String getSummary() { return mSummary; }

    public int getId() { return id; }

    public void setId(int i) { id = i; }

}
