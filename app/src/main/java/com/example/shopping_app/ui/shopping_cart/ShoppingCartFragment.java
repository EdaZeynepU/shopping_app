package com.example.shopping_app.ui.shopping_cart;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.shopping_app.R;
import com.example.shopping_app.databinding.FragmentShoppingCartBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


//Eda Zeynep Uyanık
public class ShoppingCartFragment extends Fragment {

    private FragmentShoppingCartBinding binding;

    private ImageView imageView;
    private FirebaseStorage storage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ShoppingCartViewModel shoppingCartViewModel = new ViewModelProvider(this).get(ShoppingCartViewModel.class);

        binding = FragmentShoppingCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textShoppingCart;
//        shoppingCartViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        imageView = view.findViewById(R.id.chart_img_3);
        storage = FirebaseStorage.getInstance();

        String imagePath = "products/women/women_dress_1.png";
        loadImageFromFirebase(imagePath);

        return root;
    }

    public void loadImageFromFirebase(String imagePath) {
        StorageReference storageRef = storage.getReference().child(imagePath);
        Log.d("Storage", "loadImageFromFirebase: "+ storage.getReference("products/women/women_dress_1.jpg"));
        Log.d("Storage", "loadImageFromFirebase: "+storageRef);
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(requireContext())
                        .load(uri)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                exception.printStackTrace();
                Log.d("FAILEDD", "onFailure: ");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}