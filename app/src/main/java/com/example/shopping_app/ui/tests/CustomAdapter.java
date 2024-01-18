package com.example.shopping_app.ui.tests;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shopping_app.R;

import java.util.List;

//Eda Zeynep Uyanık
public class CustomAdapter extends ArrayAdapter<QuestionItem> {
    RadioGroup radioGroup;
    private List<QuestionItem> questionItems;
    public CustomAdapter(@NonNull Context context, @NonNull List<QuestionItem> objects) {
        super(context, 0, objects);
        this.questionItems = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_question, parent, false);
                }

                QuestionItem questionItem = getItem(position);
                Log.d("tests", questionItem.toString());
                if (questionItem != null) {
                    Log.d("tests2", questionItem.toString());

                    TextView questionTextView = convertView.findViewById(R.id.questionTextView);
                    RadioGroup radioGroup = convertView.findViewById(R.id.radioGroup);


                    if (radioGroup.getChildCount() == 0) {
                        questionTextView.setText(questionItem.getQuestion());
                        List<String> options = questionItem.getOptions();
                        for (int i = 0; i < options.size(); i++) {
                            RadioButton radioButton = new RadioButton(getContext());
                            radioButton.setText(options.get(i));
                            int currentOption = i;
                            radioButton.setOnClickListener(view -> {
                                questionItem.setSelectedAnswerIndex(currentOption);
                                notifyDataSetChanged();
                            });
                            radioGroup.addView(radioButton);
                        }
                    }
                }


                return convertView;
            }
    private int getAdapterPositionForRadioButton(View view) {
        ViewParent parent = view.getParent();
        while (!(parent instanceof AdapterView)) {
            if (parent == null) {
                return AdapterView.INVALID_POSITION;
            }
            parent = parent.getParent();
        }
        return ((AdapterView) parent).getPositionForView(view);
    }
    public int getSelectedAnswerIndex(int position) {
        QuestionItem questionItem = getItem(position);
        if (questionItem != null) {
            return questionItem.getSelectedAnswerIndex();
        }
        return -1;  // Return -1 if the item is not found or no answer is selected
    }

    public List<QuestionItem> getQuestionItems() {
        return questionItems;
    }
}