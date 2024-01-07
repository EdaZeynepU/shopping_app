package com.example.shopping_app.ui.tests;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class QuestionItem {
    private String question;
    private List<String> options;

    public QuestionItem(String question, List<String> options1) {
        this.question = question;
        this.options =options1;
    }

    public String getQuestion() {
        return question;
    }


    public List<String> getOptions() {
        Log.d("x", options.toString());
        return options;
    }
}