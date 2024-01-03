package com.example.shopping_app.ui.tests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopping_app.QuestionItem;
import com.example.shopping_app.R;
import com.example.shopping_app.databinding.FragmentTestsBinding;

import java.util.List;

public class TestsFragment extends Fragment {

    private FragmentTestsBinding binding;
    TextView question, ans1, ans2, ans3, ans4,ans5;
    List<QuestionItem> questionItemList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TestsViewModel testsViewModel =
                new ViewModelProvider(this).get(TestsViewModel.class);

        binding = FragmentTestsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textTests;
//        testsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        question = root.findViewById(R.id.question1);
        ans1 = root.findViewById(R.id.radioButton1);
        ans2 = root.findViewById(R.id.radioButton2);
        ans3 = root.findViewById(R.id.radioButton3);
        ans4 = root.findViewById(R.id.radioButton4);
        ans5 = root.findViewById(R.id.radioButton5);

//        testsViewModel.getQuestionItemList().observe(getViewLifecycleOwner(), questionItems -> {
//            updateUI(questionItems);
//        });
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}