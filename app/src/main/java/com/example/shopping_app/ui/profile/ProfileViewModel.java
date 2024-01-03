package com.example.shopping_app.ui.profile;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class ProfileViewModel extends ViewModel {
//    public void observe(LifecycleOwner viewLifecycleOwner, Object o) {
//    }

    private final MutableLiveData<String> mText;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Profile fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
