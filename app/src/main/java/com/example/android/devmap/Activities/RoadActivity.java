package com.example.android.devmap.Activities;

import android.app.Notification;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.android.devmap.R;
import com.example.android.devmap.adapters.RoadAdapter;
import com.example.android.devmap.database.Road;
import com.example.android.devmap.database.RoadViewModel;
import com.example.android.devmap.notifications.NotificationHelper;
import com.example.android.devmap.settings.SettingsActivity;
import com.example.android.devmap.settings.ThemeUtils;

import java.util.List;

public class RoadActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener, RoadAdapter.ListItemClickListener {
    RecyclerView mRecyclerView;
    private static final String TAG = "RoadMapActivity";
    private RoadViewModel mRoadViewModel;
    private RoadAdapter mAdapter;
    //notification Ids
    private static final int NOTI_DAILY1 = 1100;
    private static final int NOTI_DAILY2 = 1101;
    private static final int NOTI_SECONDARY1 = 1200;
    private static final int NOTI_SECONDARY2 = 1201;

    // notification helper
    private NotificationHelper noti;

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals(getString(R.string.pref_theme_key))) {

            ThemeUtils.changeTheme(this, sharedPreferences.getString(s, getResources().getString(R.string.pref_theme_light_value)));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpSharedPreferences();
        // assign notification helper
        noti = new NotificationHelper(this);

        mRoadViewModel = ViewModelProviders.of(this).get(RoadViewModel.class);
        mRoadViewModel.getmALlMaps().observe(this, new Observer<List<Road>>() {
            @Override
            public void onChanged(@Nullable List<Road> roads) {
                mAdapter.setRoads (roads);
            }
        });
        setContentView(R.layout.activity_main2);
        mRecyclerView = findViewById(R.id.roadmap_recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new RoadAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.roadmap_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Intent startSettingsActivity = new Intent(this, SettingsActivity.class);
            startActivity(startSettingsActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void setUpSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String s = sharedPreferences.getString(getString(R.string.pref_theme_key), getString(R.string.pref_theme_light_value));
        ThemeUtils.changeTheme(this, s);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onListItemCLick(int index) {
        //test notification
        sendNotification(NOTI_DAILY1, "Test");
        Intent i = new Intent(this, StagesActivity.class);
        Intent intent = i.putExtra("Road", index);
        startActivity(intent);
    }

    /**
     * Send activity notifications.
     *
     * @param id The ID of the notification to create
     * @param title The title of the notification
     */
    public void sendNotification(int id, String title) {
        Notification.Builder nb = null;
        switch (id) {
            case NOTI_DAILY1:
                nb = noti.getDailyNotification(title, getString(R.string.dailyNoti_1_body));
                break;
            case NOTI_DAILY2:
                nb = noti.getDailyNotification(title, getString(R.string.dailyNoti_2_body));
                break;
            case NOTI_SECONDARY1:
                nb = noti.getSecondaryNotification(title, getString(R.string.secondNoti_1_body));
                break;
            case NOTI_SECONDARY2:
                nb = noti.getSecondaryNotification(title, getString(R.string.secondNoti_2_body));
                break;
        }
        if (nb != null) {
            noti.notify(id, nb);
        }
    }

    /**
     * Send Intent to load system Notification Settings for this app.
     */
    public void goToNotificationSettings() {
        Intent i = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
        i.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
        startActivity(i);
    }


}
