package com.example.android.devmap.data;

import java.io.Serializable;

public class GoalsData implements Serializable{
    private String goal;
    private Boolean progress;

    public GoalsData(String goalString, Boolean b){
        goal = goalString;
        progress = b;
    }

    public String getGoal(){return goal;}

    public Boolean getProgress(){
        return progress;
    }

    public void setProgress(Boolean b){
        progress = b;
    }
}
