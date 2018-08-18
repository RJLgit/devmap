package com.example.android.devmap.activities;

import com.example.android.devmap.database.Goal;

import java.util.List;

interface OnTaskCompleted {


     void onTaskCompleted(List<Goal> g, int i);

}
