package com.example.shopping_app.ui.tests;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class QuestionItem {
    private String question;
    private List<String> options;
    private int selectedAnswerIndex = -1;

    public QuestionItem(String question, List<String> options1) {
        this.question = question;
        this.options =options1;
    }

    public int getSelectedAnswerIndex() {
        return selectedAnswerIndex;
    }

    public void setSelectedAnswerIndex(int selectedAnswerIndex) {
        this.selectedAnswerIndex = selectedAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }


    public List<String> getOptions() {
        Log.d("x", options.toString());
        return options;
    }
}