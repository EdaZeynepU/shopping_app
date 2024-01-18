package com.example.shopping_app.ui.tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.shopping_app.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class PersonaltyTestActivity extends AppCompatActivity {
//    private FragmentTestsBinding binding;
    ListView mListView;
    CustomAdapter adapter;
    private List<QuestionItem> sampleItems;
    Button submitBtn;
    private MutableLiveData<List<QuestionItem>> questionItemsLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalty_test);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submitBtn = findViewById(R.id.submit_test_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitTest();
            }
        });

        loadSampleQuestionItems();
    }

    public void loadSampleQuestionItems() {
        Log.d("loadSampleQuestionItems", "loadSampleQuestionItems: I start");

        questionItemsLiveData = new MutableLiveData<>();
        mListView = findViewById(R.id.personalTestListView);

        List<QuestionItem> sampleItems = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        String collectionPath = "personalty_tests";

        db.collection(collectionPath)
                .get()
                .addOnCompleteListener(task -> {
                    Log.d("firebase", "loadSampleQuestionItems: fetchy");
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            List<String> lst = (List<String>) document.get("answers");
                            Log.d("TESTVIEWMODEL", "loadSampleQuestionItems: "+lst.toString());
                            QuestionItem question1 = new QuestionItem(document.getString("question"), lst);
                            sampleItems.add(question1);
                            Log.d("TESTVIEWMODEL", "loadSampleQuestionItems: "+sampleItems);
                        }

                        // Set the value of questionItemsLiveData after successfully fetching the data
//                        questionItemsLiveData.setValue(sampleItems);
                        adapter = new CustomAdapter(PersonaltyTestActivity.this,sampleItems);
                        Log.d("before adapter", "loadSampleQuestionItems: "+sampleItems);
                        mListView.setAdapter(adapter);
                        updateQuestionItemsLiveData();
                        Log.d("after adapter", "loadSampleQuestionItems: "+sampleItems);

                    } else {
                        Log.w("y", "Error getting documents.", task.getException());
                    }
                })
                .addOnFailureListener(e -> {
                    Log.d("Firebase List Failed", "onFailure: ");
                });

    }

    private void submitTest() {
        List<QuestionItem> questionItems = adapter.getQuestionItems();
        Map<Integer, Integer> ResultRate = new HashMap<>();
        int mostRepeated=0;
        int mostRepeatedTime=0;
        float testResultPerc;

        for (QuestionItem questionItem : questionItems) {
            int selectedAnswerIndex = questionItem.getSelectedAnswerIndex();
            ResultRate.put(selectedAnswerIndex, ResultRate.getOrDefault(selectedAnswerIndex, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : ResultRate.entrySet()) {
            if (entry.getValue() > mostRepeatedTime) {
                mostRepeatedTime= entry.getValue();
                mostRepeated= entry.getKey();
            }
        }
        String[] personalities = {
            "Sweet",
                    "Chill",
                    "Elegant",
                    "Baddie",
            "Athletic"
        };

        int a = (int)  mostRepeatedTime * 100;
        int testResultPercExtra = Integer.divideUnsigned(a, questionItems.size());
        Intent intent = new Intent(PersonaltyTestActivity.this,PersonaltyTestResultActivity.class);
        intent.putExtra("result", personalities[mostRepeated]);
        intent.putExtra("result_percentage",testResultPercExtra);
        startActivity(intent);
        Toast.makeText(this, "Test submitted successfully!", Toast.LENGTH_SHORT).show();
    }

    private void updateQuestionItemsLiveData() {
        questionItemsLiveData.setValue(sampleItems);
    }
}