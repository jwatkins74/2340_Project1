package com.example.a2340anothertry.ui.a;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class aViewModel extends ViewModel {
    private final MutableLiveData<String> bText;

    public aViewModel() {
        bText = new MutableLiveData<>();
        bText.setValue("");
    }

    public LiveData<String> getText() {
        return bText;
    }
}
