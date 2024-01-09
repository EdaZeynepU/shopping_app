package com.example.shopping_app.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopping_app.LoginPage;
import com.example.shopping_app.R;
import com.example.shopping_app.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;

//Eda Zeynep Uyanık
public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    private FirebaseAuth firebaseAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        ProfileViewModel ProfileViewModel =new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Button btnLogout= view.findViewById(R.id.btnLogout);
        firebaseAuth = FirebaseAuth.getInstance();


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
                Log.d("logout", "onClick: in");
            }
        });


        return root;
    }

    public void logout() {
        firebaseAuth.signOut();
        Intent intent = new Intent(requireContext(), LoginPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}