package namtran.cleanarchitechturesample.application.mvvm.viewmodel;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.VisibleForTesting;

import java.util.List;

import namtran.cleanarchitechturesample.application.mvvm.viewmodel.core.BaseViewModel;
import namtran.cleanarchitechturesample.domain.interactor.GetSessionUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultSubscriber;
import namtran.cleanarchitechturesample.flatform.Resource;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;

public class TestViewModel extends BaseViewModel {

    private MutableLiveData<Resource<List<SoccerSeasons>>> results;
    private final GetSessionUseCase getDataTest;

    public TestViewModel(Application application,GetSessionUseCase getDataTest) {
        super(application);
        this.getDataTest = getDataTest;
    }

    @VisibleForTesting
    public LiveData<Resource<List<SoccerSeasons>>> getResults() {
        return results;
    }

    public MutableLiveData<Resource<List<SoccerSeasons>>> getTestData() {
        if (results != null) {
            // TODO: 2017/11/16 Memory Cache
            return results;
        } else {
            results = new MutableLiveData<>();
        }

        results.setValue(Resource.<List<SoccerSeasons>>loading(null));
        getDataTest.execute(new GetDataTestObserver(),null);
        return results;
    }

    @Override
    protected void onCleared() {
        getDataTest.dispose();
        super.onCleared();
    }

    private final class GetDataTestObserver extends DefaultSubscriber<List<SoccerSeasons>> {

        @Override
        public void onNext(List<SoccerSeasons> tests) {
            super.onNext(tests);
            results.setValue(Resource.success(tests));
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
            results.setValue(Resource.<List<SoccerSeasons>>error(exception.getMessage(), null));
        }
    }
}
