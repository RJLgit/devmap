package com.example.android.devmap;

import java.util.ArrayList;
import java.util.List;

public class StageData {
    private String goal1;
    private String goal2;
    private String goal3;
    private String goal4;
    private String goal5;
    private String stageName;

    public StageData(String a, String b, String c, String d, String e, String f) {
        stageName = a;
        goal1 = b;
        goal2 = c;
        goal3 = d;
        goal4 = e;
        goal5 = f;
    }

    public ArrayList<String> getGoals() {
        ArrayList<String> result = new ArrayList<String>();
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
