package namtran.cleanarchitechturesample.application.mvvm.viewmodel;


import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.application.mvvm.core.BaseViewModel;
import namtran.cleanarchitechturesample.domain.interactor.GetSessionUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultSubscriber;
import namtran.cleanarchitechturesample.flatform.Resource;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

public class SoccerSeasonFragmentModel extends BaseViewModel {

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

        getDataTest.execute(new GetSoccerSeasion(results),null);
        return results;
    }

    @Override
    public void detach() {
        getDataTest.dispose();
        onCleared();
    }

    private final class GetSoccerSeasion extends DefaultSubscriber<List<SoccerSeason>> {

        GetSoccerSeasion(MutableLiveData<Resource<List<SoccerSeason>>> results) {
            super(results);
        }
    }
}
