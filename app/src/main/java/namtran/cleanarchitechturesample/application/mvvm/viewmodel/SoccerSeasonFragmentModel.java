package namtran.cleanarchitechturesample.application.mvvm.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.domain.interactor.GetSessionUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultSubscriber;
import namtran.cleanarchitechturesample.flatform.Resource;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

public class SoccerSeasonFragmentModel extends AndroidViewModel {

    private MutableLiveData<Resource<List<SoccerSeason>>> results;
    private final GetSessionUseCase getDataTest;

    @Inject
    SoccerSeasonFragmentModel(Application application, GetSessionUseCase getSessionUseCase) {
        super(application);
        this.getDataTest = getSessionUseCase;
    }

    public MutableLiveData<Resource<List<SoccerSeason>>> getResults() {
        if (results != null) {
            // TODO: 2017/11/16 Memory Cache
            return results;
        } else {
            results = new MutableLiveData<>();
        }

        getDataTest.execute(new GetSoccerSeasionObserver(results),null);
        return results;
    }

    @Override
    protected void onCleared() {
        getDataTest.dispose();
        super.onCleared();
    }

    private final class GetSoccerSeasionObserver extends DefaultSubscriber<List<SoccerSeason>> {


        GetSoccerSeasionObserver(MutableLiveData<Resource<List<SoccerSeason>>> results) {
            super(results);
        }
    }
}
