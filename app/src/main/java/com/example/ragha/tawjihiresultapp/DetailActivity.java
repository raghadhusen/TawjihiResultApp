package com.example.ragha.tawjihiresultapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.ragha.tawjihiresultapp.MainActivity.Extra_name;
import static com.example.ragha.tawjihiresultapp.MainActivity.Extra_school;
import static com.example.ragha.tawjihiresultapp.MainActivity.Extra_section;
import static com.example.ragha.tawjihiresultapp.MainActivity.Extra_year;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        int year=intent.getIntExtra(Extra_year,0);
        String name=intent.getStringExtra(Extra_name);
        String school=intent.getStringExtra(Extra_school);
        String section=intent.getStringExtra(Extra_section);

        TextView SumTextView= findViewById(R.id.Sum);
        TextView branch_LevelTextView= findViewById(R.id.branch_Level);
        TextView School_LevelTextView= findViewById(R.id.School_Level);
        TextView muhafatha_LevelTextView= findViewById(R.id.muhafatha_Level);
        SumTextView.setText(name);
        branch_LevelTextView.setText(name);
        School_LevelTextView.setText(school);
        muhafatha_LevelTextView.setText(section);
    }
}
