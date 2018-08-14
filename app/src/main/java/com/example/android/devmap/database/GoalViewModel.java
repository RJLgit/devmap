package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class GoalViewModel extends AndroidViewModel{
    private GoalRepository mRepository;
    private LiveData<List<Goal>> mAllGoals;


    public GoalViewModel(@NonNull Application application) {
        super(application);
        mRepository =new GoalRepository(application);
        mAllGoals = mRepository.getAllGoals();
    }

    public LiveData<List<Goal>> getmAllGoals() { return mAllGoals; }

    public void insert(Goal goal) { mRepository.insert(goal); }
}


