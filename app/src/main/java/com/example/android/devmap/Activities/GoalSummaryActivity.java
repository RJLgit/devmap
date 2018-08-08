package com.example.android.devmap.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.android.devmap.R;


public class GoalSummaryActivity extends AppCompatActivity{
    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_summary);
        mTextView = (TextView) findViewById(R.id.goals_summary_textview);
        mTextView.setText("dummytext");
    }
}
