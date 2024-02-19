package com.example.a2340anothertry.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        String x = "";
        mText.setValue(x);
    }

    public LiveData<String> getText() {
        return mText;
    }
}