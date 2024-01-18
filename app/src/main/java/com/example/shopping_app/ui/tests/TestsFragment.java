package com.example.shopping_app.ui.tests;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopping_app.LoginPage;
import com.example.shopping_app.R;
import com.example.shopping_app.databinding.FragmentTestsBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Eda Zeynep Uyanık
public class TestsFragment extends Fragment {

    private FragmentTestsBinding binding;
    ListView mListView;
    CustomAdapter adapter;
    private Button endButton;
    private Button startButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TestsViewModel testsViewModel = new ViewModelProvider(this).get(TestsViewModel.class);

        binding = FragmentTestsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        startButton = binding.startNewTestBtn;
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(requireContext() ,PersonaltyTestActivity.class);
                startActivity(intent);
            }
        });


//        TODO: uncomment this -its working and we need it, just not important for now ( firebase reasons )
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String collectionPath = "users";
//        db.collection(collectionPath)
//                .get()
//                .addOnCompleteListener(task -> {
//                    Log.d("firebase", "loadSampleQuestionItems: fetchy");
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String firebase_test_result = (String) document.get("test_result");
//                            binding.lastTestResult.setText(firebase_test_result);
//                        }
//                    } else {
//                        Log.w("y", "Error getting documents.", task.getException());
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        binding.lastTestResult.setText("Not Found");
//                    }
//                });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}