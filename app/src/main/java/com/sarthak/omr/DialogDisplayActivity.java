package com.sarthak.omr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DialogDisplayActivity extends AppCompatActivity {

    static String optionsType="alphabetic";
    static int questions;
    RadioGroup radioGroup;
    EditText numberOfQuestionsEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        numberOfQuestionsEt = this.findViewById(R.id.dialog_number_of_questions_et);
        radioGroup = findViewById(R.id.dialog_radio_group);
        Button dialogSubmitBtn = findViewById(R.id.dialog_submit_btn);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.alphabetic_options_rb)
                    optionsType = "alphabetic";
                else optionsType = "numeric";
            }
        });

        dialogSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberOfQuestions = numberOfQuestionsEt.getText().toString();
                if(numberOfQuestions.isEmpty()){
                    numberOfQuestionsEt.setError("required");
                    numberOfQuestionsEt.requestFocus();
                    return;
                }
                if(optionsType==null){
                    Toast.makeText(DialogDisplayActivity.this, "choose your options type", Toast.LENGTH_SHORT).show();
                    return;
                }
                questions = Integer.parseInt(numberOfQuestions);
                Intent intent = new Intent(DialogDisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
