package tv.mtube.ui.MyUser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyUserViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyUserViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is myuser fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}