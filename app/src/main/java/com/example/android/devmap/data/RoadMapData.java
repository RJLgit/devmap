package com.example.android.devmap.data;

import java.util.ArrayList;
import java.util.List;

public class RoadMapData {
    private static List<StageData> stages;

    public RoadMapData() {

    }

    public void populateData() {
        // dummy data for stage 1
        GoalsData goal1 = new GoalsData("learn Git Commands", true);
        GoalsData goal2 = new GoalsData("Learn how to use branches", false);
        GoalsData goal3 = new GoalsData("Learn to collaborate on Github", false);
        // dummy data for stage 2
        GoalsData goal4 = new GoalsData("Learn how to set up activities", false);
        GoalsData goal5 = new GoalsData("Learn how to use intents", false);
        GoalsData goal6 = new GoalsData("Learn how to send extra data in intents", false);
        GoalsData goal7 = new GoalsData("Learn how to issue implicit intents", false);
        //dummy data for stage 3
        GoalsData goal8 = new GoalsData("Learn what notifications are", false);
        GoalsData goal9 = new GoalsData("Learn how to issue a notification", false);
        GoalsData goal10 = new GoalsData("Add actions to notifications", false);
        GoalsData goal11 = new GoalsData("Issue notifications when certain conditions met", false);
        GoalsData goal12 = new GoalsData("Learn to put notification code off the main thread", false);
        // dummy data for road map
        StageData stage1 = new StageData("Learn to use git", goal1, goal2, goal3, null, null);
        StageData stage2 = new StageData("Learn about activities", goal4, goal5, goal6, goal7, null);
        StageData stage3 = new StageData("Learn how to use Notifications", goal8, goal9, goal10, goal11, goal12);
        stages = new ArrayList<StageData>();
        stages.add(stage1);
        stages.add(stage2);
        stages.add(stage3);
    }

    public List<StageData> getStages() {
        return stages;
    }

}
