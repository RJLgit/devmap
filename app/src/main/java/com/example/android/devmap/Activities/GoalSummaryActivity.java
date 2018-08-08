package com.example.android.devmap.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.android.devmap.R;
import com.example.android.devmap.data.GoalsData;


public class GoalSummaryActivity extends AppCompatActivity{
    private TextView mTextView;
    private GoalsData goal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_summary);
        mTextView = (TextView) findViewById(R.id.goals_summary_textview);

        Intent i = getIntent();
        if (i.hasExtra("Goal")){
            goal = (GoalsData) i.getSerializableExtra("Goal");
            mTextView.setText(goal.getSummary());

        }
    }
}
