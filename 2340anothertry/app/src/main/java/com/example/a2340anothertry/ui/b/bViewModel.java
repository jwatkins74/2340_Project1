package com.example.a2340anothertry.ui.b;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class bViewModel extends ViewModel {
    private final MutableLiveData<String> bText;

    public bViewModel() {
        bText = new MutableLiveData<>();
        bText.setValue("");
    }

    public LiveData<String> getText() {
        return bText;
    }
}
