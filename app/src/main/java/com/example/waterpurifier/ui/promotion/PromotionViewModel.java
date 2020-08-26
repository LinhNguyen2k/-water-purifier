package com.example.waterpurifier.ui.promotion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PromotionViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PromotionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
