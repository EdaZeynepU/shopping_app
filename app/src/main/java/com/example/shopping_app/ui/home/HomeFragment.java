package com.example.shopping_app.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopping_app.CategoryPage;
import com.example.shopping_app.Comment;
import com.example.shopping_app.R;
import com.example.shopping_app.databinding.FragmentHomeBinding;

//Ayberk Anayurtdan
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Kategori düğmelerini ve arama düğmelerini bağla
        Button btnWomen = binding.btnWomen;
        Button btnMen = binding.btnMen;
        Button btnUnisex = binding.btnUnisex;
        Button btnBaby = binding.btnBaby;

        SearchView searchView = binding.searchView;
        Button btnSearch = binding.btnSearch;

//        ImageButton btnCampaign = binding.btncampaign;
//        Button btnTest = binding.btnTest;
//        ImageButton btnDiscount1 = binding.btnDiscount1;
//        ImageButton btnDiscount2 = binding.btnDiscount2;


        btnMen = root.findViewById(R.id.btnMen);

        btnMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryPage.updateCategoryName("Men");


                startActivity(new Intent(getActivity(), CategoryPage.class));
            }

        });


        btnWomen = root.findViewById(R.id.btnWomen);
        btnWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryPage.updateCategoryName("Women");
                startActivity(new Intent(getActivity(), CategoryPage.class));
            }
        });


        btnUnisex = root.findViewById(R.id.btnUnisex);

        btnUnisex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoryPage.updateCategoryName("Unisex");
                startActivity(new Intent(getActivity(), CategoryPage.class));
            }
        });

        btnBaby = root.findViewById(R.id.btnBaby);

        btnBaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryPage.updateCategoryName("Baby");
                startActivity(new Intent(getActivity(), CategoryPage.class));
            }
        });


        btnSearch.setOnClickListener(v -> showToast("Search Button Clicked"));


//        btnCampaign.setOnCdOnClickListener(v -> showToast("Discount Image Button 2 Clicked"));


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Comments Sayfasını kontrol etmek için. SİLİNECEK!!!
                btnSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startComment();
                        System.out.println("Comments");
                    }
                });
                //Comments Sayfasını kontrol etmek için. SİLİNECEK!!!


 /*               // SearchView'dan metni al
                String searchText = searchView.getQuery().toString();


                // Alınan metni kullanarak arama işlemini başlat
                performSearch(searchText);
*/            }
        });

        return root;
    }
    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
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



    // Yardımcı metot: CategoryPage'e geçiş yapma
    private void startCategoryPage() {
        Intent intent= new Intent(getActivity(), CategoryPage.class);

        startActivity(intent);
    }

    private void startComment() {
        startActivity(new Intent(getActivity(), Comment.class));
    }



}