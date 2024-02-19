package com.example.a2340anothertry.ui.classes;

import androidx.lifecycle.LiveData;
        import androidx.lifecycle.MutableLiveData;
        import androidx.lifecycle.ViewModel;

public class ClassesViewModel extends ViewModel {

    private final MutableLiveData<String> lText;

    public ClassesViewModel() {
        lText = new MutableLiveData<>();
        lText.setValue("");
    }

    public LiveData<String> getText() {
        return lText;
    }
}