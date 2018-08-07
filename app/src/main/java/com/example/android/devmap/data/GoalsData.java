package com.example.android.devmap.data;

import java.io.Serializable;

public class GoalsData implements Serializable{
    private String goal;

    public GoalsData(String goalString){
        goal = goalString;
    }

    public String getGoal(){return goal;}
}
