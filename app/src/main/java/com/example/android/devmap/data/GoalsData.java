package com.example.android.devmap.data;

import java.io.Serializable;

public class GoalsData implements Serializable{
    private String goal;
    private Boolean progress;
    private String summary;

    public GoalsData(String goalString, Boolean b, String summaryString){
        goal = goalString;
        progress = b;
        summary = summaryString;
    }

    public String getGoal(){return goal;}

    public Boolean getProgress(){
        return progress;
    }

    public String getSummary() { return summary;}

    public void setProgress(Boolean b){
        progress = b;
    }
}
