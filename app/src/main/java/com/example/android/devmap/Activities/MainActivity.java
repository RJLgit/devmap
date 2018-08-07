package com.example.android.devmap.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.devmap.R;


public class MainActivity extends AppCompatActivity {
    Button roadmapButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roadmapButton = (Button) findViewById(R.id.roadmap_button);
        roadmapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, StagesActivity.class);

                startActivity(i);
            }
        });
    }
}
