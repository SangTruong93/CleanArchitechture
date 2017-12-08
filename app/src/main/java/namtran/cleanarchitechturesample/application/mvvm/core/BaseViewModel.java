package namtran.cleanarchitechturesample.application.mvvm.core;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public abstract class BaseViewModel extends AndroidViewModel{

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public abstract void detach();
}
