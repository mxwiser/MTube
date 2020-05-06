package com.qvqol.mtube.ui.FengLei;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FengLeiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FengLeiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fl fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}