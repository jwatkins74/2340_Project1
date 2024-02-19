package com.example.a2340anothertry.ui.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class cEditViewModel extends ViewModel {
    private final MutableLiveData<String> bText;

    public cEditViewModel() {
        bText = new MutableLiveData<>();
        bText.setValue("");
    }

    public LiveData<String> getText() {
        return bText;
    }
}
