package com.example.android.devmap;

import java.util.ArrayList;
import java.util.List;

public class AppData {
    private static List<StageData> stages;

    public AppData() {

    }

    public void populateData() {
        StageData stage1 = new StageData("Learn to use Git", "Learn Git commands", "Learn how to use branches", "Learn to collaraborate on Github", null, null);
        StageData stage2 = new StageData("Learn about activities", "Learn how to set up activities", "Learn how to use intents", "Learn how to send extra data in intents", "Learn how to issue implicit intents", null);
        StageData stage3 = new StageData("Learn how to use Notifications", "Learn what notifications are", "Learn how to issue a notification", "Add actions to notifications", "Issue notifications when certain conditions met", "Learn to put notification code off the main thread");
        stages = new ArrayList<StageData>();
        stages.add(stage1);
        stages.add(stage2);
        stages.add(stage3);
    }

    public List<StageData> getStages() {
        return stages;
    }

}
