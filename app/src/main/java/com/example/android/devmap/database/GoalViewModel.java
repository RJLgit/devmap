package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class GoalViewModel extends AndroidViewModel{
    private GoalRepository mRepository;


    public GoalViewModel(@NonNull Application application) {
        super(application);
        mRepository =new GoalRepository(application);
    }



    public void update(Goal goal) { mRepository.update(goal); }

    public void insert(Goal goal) { mRepository.insert(goal); }

    public LiveData<List<Goal>> getGoals(int i) { return mRepository.getGoals(i); }

    public List<Goal> getListGoals(int i) { return mRepository.getListGoals(i); }
}


