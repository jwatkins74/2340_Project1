package com.example.a2340anothertry.ui.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class cViewModel extends ViewModel {
    private final MutableLiveData<String> bText;

    public cViewModel() {
        bText = new MutableLiveData<>();
        bText.setValue("");
    }

    public LiveData<String> getText() {
        return bText;
    }
}
