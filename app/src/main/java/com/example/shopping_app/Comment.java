package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.shopping_app.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class Comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);


        Button btnSubmit=findViewById(R.id.btnSubmit);
        EditText comment=findViewById(R.id.txtEditComment);
        ListView listView = findViewById(R.id.listViewComments);

        ArrayList<String> dataList;
        ArrayAdapter<String> adapter;

        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentToString=comment.getText().toString();
                dataList.add(commentToString);
                adapter.notifyDataSetChanged();

                comment.getText().clear();
            }
        });
    }



}