package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class StageViewModel extends AndroidViewModel {
    private StageRepository mRepository;
    private LiveData<List<Stage>> mAllStages;
    private List<Stage> mListStages;

    public StageViewModel(Application application) {
        super(application);
        mRepository = new StageRepository((application));
        mAllStages = mRepository.getAllStages();
        mListStages = mRepository.getListStages();
    }

    public LiveData<List<Stage>> getmAllStages() {
        return mAllStages;
    }

    public List<Stage> getListStages() {return mListStages; }

    public void insert(Stage stage) { mRepository.insert(stage); }
}
