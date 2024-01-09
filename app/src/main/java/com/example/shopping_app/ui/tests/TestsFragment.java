package com.example.shopping_app.ui.tests;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopping_app.R;
import com.example.shopping_app.databinding.FragmentTestsBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Eda Zeynep Uyanık
public class TestsFragment extends Fragment {

    private FragmentTestsBinding binding;
    ListView mListView;
    CustomAdapter adapter;
    private Button endButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TestsViewModel testsViewModel =
                new ViewModelProvider(this).get(TestsViewModel.class);

        binding = FragmentTestsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mListView = root.findViewById(R.id.personalTestListView);
        adapter = new CustomAdapter(requireContext(), new ArrayList<>());
        mListView.setAdapter(adapter);

        testsViewModel.getQuestionItems().observe(getViewLifecycleOwner(), questionItems -> {
            // When the adapter changes
            adapter.clear();
            adapter.addAll(questionItems);
            adapter.notifyDataSetChanged();
        });

        endButton = root.findViewById(R.id.end_button);
        endButton.setOnClickListener(view -> {
            Toast.makeText(requireContext(), "End of List Button Clicked", Toast.LENGTH_SHORT).show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}