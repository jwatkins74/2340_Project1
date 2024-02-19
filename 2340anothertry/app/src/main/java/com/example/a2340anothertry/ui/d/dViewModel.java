package com.example.a2340anothertry.ui.d;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class dViewModel extends ViewModel {
    private final MutableLiveData<String> bText;

    public dViewModel() {
        bText = new MutableLiveData<>();
        bText.setValue("");
    }

    public LiveData<String> getText() {
        return bText;
    }
}
