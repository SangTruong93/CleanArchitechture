package namtran.cleanarchitechturesample.application.mvvm.viewmodel;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.VisibleForTesting;

import java.util.List;

import namtran.cleanarchitechturesample.application.mvvm.viewmodel.core.BaseViewModel;
import namtran.cleanarchitechturesample.domain.interactor.GetTestData;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultSubscriber;
import namtran.cleanarchitechturesample.flatform.Resource;
import namtran.cleanarchitechturesample.flatform.model.Test;

public class TestViewModel extends BaseViewModel {

    private MutableLiveData<Resource<List<Test>>> results;
    private final GetTestData getDataTest;

    public TestViewModel(Application application,GetTestData getDataTest) {
        super(application);
        this.getDataTest = getDataTest;
    }

    @VisibleForTesting
    public LiveData<Resource<List<Test>>> getResults() {
        return results;
    }

    public MutableLiveData<Resource<List<Test>>> getTestData() {
        if (results != null) {
            // TODO: 2017/11/16 Memory Cache
            return results;
        } else {
            results = new MutableLiveData<>();
        }

        results.setValue(Resource.<List<Test>>loading(null));
        getDataTest.execute(new GetDataTestObserver(),null);
        return results;
    }

    @Override
    protected void onCleared() {
        getDataTest.dispose();
        super.onCleared();
    }

    private final class GetDataTestObserver extends DefaultSubscriber<List<Test>> {

        @Override
        public void onNext(List<Test> tests) {
            super.onNext(tests);
            results.setValue(Resource.success(tests));
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
            results.setValue(Resource.<List<Test>>error(exception.getMessage(), null));
        }
    }
}
