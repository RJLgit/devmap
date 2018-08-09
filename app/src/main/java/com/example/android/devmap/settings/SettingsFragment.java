package com.example.android.devmap.settings;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import com.example.android.devmap.R;

public class SettingsFragment extends PreferenceFragmentCompat{


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_devmap);
    }
}
