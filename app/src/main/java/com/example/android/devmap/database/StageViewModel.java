package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class StageViewModel extends AndroidViewModel {
    private StageRepository mRepository;
    private LiveData<List<Stage>> mAllStages;

    public StageViewModel(Application application) {
        super(application);
        mRepository = new StageRepository((application));
        mAllStages = mRepository.getAllStages();
    }

    public LiveData<List<Stage>> getmAllStages() {
        return mAllStages;
    }

    public LiveData<List<Stage>> getRoadStages(int i) { return mRepository.getRoadStages(i); }


    public void insert(Stage stage) { mRepository.insert(stage); }
}
