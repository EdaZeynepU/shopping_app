package com.example.shopping_app.ui.tests;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class TestsViewModel extends ViewModel {

    private MutableLiveData<List<QuestionItem>> questionItemsLiveData;


    public TestsViewModel() {
        questionItemsLiveData = new MutableLiveData<>();
        loadSampleQuestionItems();
    }

    public LiveData<List<QuestionItem>> getQuestionItems() {
        return questionItemsLiveData;
    }
    public void updateQuestionItems(List<QuestionItem> newQuestionItems) {
        questionItemsLiveData.setValue(newQuestionItems);
    }

    // Sample method to load some initial data (replace this with your logic)
    private void loadSampleQuestionItems() {

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
                                QuestionItem question1 = new QuestionItem(document.getString("question"), lst);
                                sampleItems.add(question1);
                            }
//                            questionItemsLiveData.setValue(sampleItems);
//

                        } else {
                            Log.w("y", "Error getting documents.", task.getException());
                        }
//                        sampleItems.clear();
                    });
            questionItemsLiveData.setValue(sampleItems);

    }
}