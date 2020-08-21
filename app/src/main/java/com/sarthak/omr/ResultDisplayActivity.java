package com.sarthak.omr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

public class ResultDisplayActivity extends AppCompatActivity {

    ListView resultDisplayLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_display);

        resultDisplayLv = findViewById(R.id.result_display_lv);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, (HashMap<Integer, Integer>) getIntent().getSerializableExtra("result"));
        resultDisplayLv.setAdapter(listViewAdapter);
    }
}
