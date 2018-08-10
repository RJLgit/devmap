package com.example.android.devmap.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.android.devmap.R;
import com.example.android.devmap.data.GoalsData;
import com.example.android.devmap.settings.ThemeUtils;


public class GoalSummaryActivity extends AppCompatActivity{
    private TextView mTextView;
    private GoalsData goal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String s = sharedPreferences.getString(getString(R.string.pref_theme_key), getString(R.string.pref_theme_light_value));
        ThemeUtils.changeTheme(this, s);
        setContentView(R.layout.activity_goal_summary);
        mTextView = (TextView) findViewById(R.id.goals_summary_textview);

        Intent i = getIntent();
        if (i.hasExtra("Goal")){
            goal = (GoalsData) i.getSerializableExtra("Goal");
            mTextView.setText(goal.getSummary());

        }

    }
}
