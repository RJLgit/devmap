package com.example.android.devmap.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class RoadViewModel extends AndroidViewModel {
    private RoadRepository mRepository;
    private LiveData<List<Road>> mALlMaps;

    public RoadViewModel(Application application) {
        super(application);
        mRepository = new RoadRepository((application));
        mALlMaps = mRepository.getAllMaps();
    }

    public LiveData<List<Road>> getmALlMaps() { return mALlMaps; }

}
