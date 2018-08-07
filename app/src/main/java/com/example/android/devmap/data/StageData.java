package com.example.android.devmap.data;

import com.example.android.devmap.data.GoalsData;

import java.io.Serializable;
import java.util.ArrayList;

public class StageData implements Serializable{
    private GoalsData goal1;
    private GoalsData goal2;
    private GoalsData goal3;
    private GoalsData goal4;
    private GoalsData goal5;
    private String stageName;

    public StageData(String a, GoalsData b, GoalsData c, GoalsData d, GoalsData e, GoalsData f) {
        stageName = a;
        goal1 = b;
        goal2 = c;
        goal3 = d;
        goal4 = e;
        goal5 = f;
    }

    public ArrayList<GoalsData> getGoals() {
        ArrayList<GoalsData> result = new ArrayList<>();
        if (goal1 != null) {
            result.add(goal1);
        }
        if (goal2 != null) {
            result.add(goal2);
        }
        if (goal3 != null) {
            result.add(goal3);
        }
        if (goal4 != null) {
            result.add(goal4);
        }
        if (goal5 != null) {
            result.add(goal5);
        }

        return result;

    }

    public String getStageName() {
        return stageName;
    }

}
