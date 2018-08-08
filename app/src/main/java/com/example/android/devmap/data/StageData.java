package com.example.android.devmap.data;

import com.example.android.devmap.data.GoalsData;

import java.io.Serializable;
import java.util.ArrayList;

public class StageData implements Serializable {
    private ArrayList<GoalsData> GoalsDataArray;

    private String stageName;

    public StageData(String a, ArrayList<GoalsData> ga) {
        stageName = a;
        GoalsDataArray = ga;
    }

    public ArrayList<GoalsData> getGoals() {
        return GoalsDataArray;

    }

    public String getStageName() {
        return stageName;
    }

    public String getStageProgress() {
        int result = 0;
        for (GoalsData goal : GoalsDataArray) {
            Boolean progress = goal.getProgress();
                if (progress == true) {
                result = result + 1;
                }
        }
        if (result > 0 && result < GoalsDataArray.size()) {
                return "in progress";
            }
            else if (result == GoalsDataArray.size()) {
                return "completed";
            }
        return "not started";
    }
}