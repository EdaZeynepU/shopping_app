package com.example.shopping_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopping_app.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Kategori düğmelerini ve arama düğmelerini bağla
        Button btnWomen = binding.btnWomen;
        Button btnMen = binding.btnMen;
        Button btnUnisex = binding.btnUnisex;
        Button btnBaby = binding.btnBaby;

        SearchView searchView = binding.searchView;
        Button btnSearch = binding.btnSearch;

        // Resim düğmelerini bağla
        ImageButton btnCampaign = binding.btncampaign;
        ImageButton btnTest = binding.btnTest;
        ImageButton btnDiscount1 = binding.btnDiscount1;
        ImageButton btnDiscount2 = binding.btnDiscount2;

        // Kategori düğmelerine tıklama dinleyicileri ekle (Örnek olarak Toast mesajı gösterilmiştir)
        btnWomen.setOnClickListener(v -> showToast("Women Category Clicked"));
        btnMen.setOnClickListener(v -> showToast("Men Category Clicked"));
        btnUnisex.setOnClickListener(v -> showToast("Unisex Category Clicked"));
        btnBaby.setOnClickListener(v -> showToast("Baby Category Clicked"));

        // Arama düğmelerine tıklama dinleyicileri ekle (Örnek olarak Toast mesajı gösterilmiştir)
        btnSearch.setOnClickListener(v -> showToast("Search Button Clicked"));

        // Resim düğmelerine tıklama dinleyicileri ekle (Örnek olarak Toast mesajı gösterilmiştir)
        btnCampaign.setOnClickListener(v -> showToast("Campaign Image Button Clicked"));
        btnTest.setOnClickListener(v -> showToast("Test Image Button Clicked"));
        btnDiscount1.setOnClickListener(v -> showToast("Discount Image Button 1 Clicked"));
        btnDiscount2.setOnClickListener(v -> showToast("Discount Image Button 2 Clicked"));


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SearchView'dan metni al
                String searchText = searchView.getQuery().toString();

                // Alınan metni kullanarak arama işlemini başlat
                performSearch(searchText);
            }
        });

        return root;
    }
    // Yardımcı metot: Toast mesajı gösterme
    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
    // Yardımcı metot: Arama işlemini gerçekleştirme
    private void performSearch(String query) {
        // Burada alınan metinle yapılacak işlemleri gerçekleştirin
        // Örneğin, bir fragment başlatma, arama sonuçlarını gösterme, vb.

        // Şu anda sadece konsola çıktı vereceğiz
        System.out.println("Performing search for: " + query);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }





}