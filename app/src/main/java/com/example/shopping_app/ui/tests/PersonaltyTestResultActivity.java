package com.example.shopping_app.ui.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shopping_app.R;

public class PersonaltyTestResultActivity extends AppCompatActivity {
    String testResult;
    int testResultPercentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalty_test_result);
        ProgressBar progressBar = findViewById(R.id.testResultProgressBar);

        Intent intent = getIntent();
        testResult = intent.getStringExtra("result");
        testResultPercentage = intent.getIntExtra("result_percentage",50);
        TextView textViewResult = findViewById(R.id.testResultExplaination);
        textViewResult.setText(String.format("You are %s", testResult));
        Log.d("testResultPercentage", "onCreate: "+testResultPercentage);
        progressBar.setProgress(testResultPercentage);

    }
}