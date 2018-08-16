package com.example.android.devmap.database;

import android.app.Application;
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
    private String mWebLink;

    @ColumnInfo(name="stage_map_reference")
    private int mStageReference;

    public Goal(String mName, String mSummary, Boolean mProgress, int mStageReference){
        this.mName = mName;
        this.mSummary = mSummary;
        this.mProgress = mProgress;
        this.mStageReference = mStageReference;
    }

    public String getName(){ return this.mName; }

    public String getSummary(){ return this.mSummary; }

    public Boolean getProgress(){ return this.mProgress; }

    public void setProgress(boolean b) { mProgress = b; }

    public int getStage(){ return this.mStageReference; }

    public String getWebLink(){ return this.mWebLink; }

    public int getStageReference() { return mStageReference; }

    public int getId() {return id;}

    public void setWebLink(String s) { mWebLink = s; }

    public void setId(int i) { id = i; }

    //public void update() { RoadStageGoalDatabase.getDatabase(getApplicationContext()).updateGoal(this); }
}
