package com.example.android.devmap.Activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.android.devmap.R;
import com.example.android.devmap.settings.SettingsActivity;
import com.example.android.devmap.settings.ThemeUtils;


public class RoadMapActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    Button roadmapButton;
    private static final String TAG = "RoadMapActivity";

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
        setContentView(R.layout.activity_main);
        roadmapButton = (Button) findViewById(R.id.roadmap_button);

        roadmapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RoadMapActivity.this, StagesActivity.class);

                startActivity(i);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpSharedPreferences();
        setContentView(R.layout.activity_main);
        roadmapButton = (Button) findViewById(R.id.roadmap_button);

        roadmapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RoadMapActivity.this, StagesActivity.class);

                startActivity(i);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);

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

        if (id == R.id.contact_menu) {
            String email = "DevMap@example.com";
            String mailto = "mailto:"+ email;
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse(mailto));
            // try intent
            try {
                startActivity(emailIntent);
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, "sendEmailIntent: ", e);
            }
        }
        return super.onOptionsItemSelected(item);

    }

    private void setUpSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String s = sharedPreferences.getString(getString(R.string.pref_theme_key), getString(R.string.pref_theme_light_value));
        ThemeUtils.changeTheme(this, s);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }
}
