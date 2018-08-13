package com.example.android.devmap.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;
import android.support.annotation.NonNull;

@Entity(tableName = "goal_table")
public class Goal {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="name")
    private String mName;

    @ColumnInfo(name="summary")
    private String mSummary;


    @ColumnInfo(name="progress")
    private Boolean mProgress;

    @ColumnInfo(name="webUrl")
    private Uri mWebLink;

    @ColumnInfo(name="stage_map_reference")
    private int mStageReference;

    public Goal(String name, String summary, Boolean progress, int stage){
        this.mName = name;
        this.mSummary = summary;
        this.mProgress = progress;
        this.mStageReference = stage;
    }

    public String getName(){ return this.mName; }

    public String getSummary(){ return this.mSummary; }

    public Boolean getProgress(){ return this.mProgress; }

    public int getStage(){ return this.mStageReference; }

    public Uri getWebLink(){ return this.mWebLink; }

    public int getmStageReference() { return mStageReference; }
}
