package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CategoryPage extends AppCompatActivity {
    private static TextView categoryName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        categoryName = findViewById(R.id.CategoryName);
    }
    public static void updateCategoryName(String categoryName_) {
        Log.d("CategoryPageActivity", "setCategoryName called with categoryName: " + categoryName_);
        // CategoryName'ı değiştir
        if (categoryName != null) {
            categoryName.setText(categoryName_);
        }
    }

}