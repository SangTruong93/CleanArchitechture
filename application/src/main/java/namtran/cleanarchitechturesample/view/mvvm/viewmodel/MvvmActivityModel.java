package namtran.cleanarchitechturesample.view.mvvm.viewmodel;


import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.subscribers.DisposableSubscriber;
import namtran.cleanarchitechturesample.Resource;
import namtran.cleanarchitechturesample.view.mvvm.core.BaseViewModel;
import namtran.cleanarchitechturesample.mapper.SoccerSeasonModelDataMapper;
import namtran.cleanarchitechturesample.model.SoccerSeasonModel;
import namtran.domain.entity.SoccerSeasonEntity;
import namtran.domain.interactor.GetSessionUseCase;

public class MvvmActivityModel extends BaseViewModel {

    private MutableLiveData<Resource<List<SoccerSeasonModel>>> results;
    private final GetSessionUseCase getDataTest;
    private final SoccerSeasonModelDataMapper dataMapper;

    @Inject
    MvvmActivityModel(Application application, GetSessionUseCase getSessionUseCase, SoccerSeasonModelDataMapper dataMapper) {
        super(application);
        this.getDataTest = getSessionUseCase;
        this.dataMapper = dataMapper;
    }

    public MutableLiveData<Resource<List<SoccerSeasonModel>>> getResults() {
        if (results != null) {
            // TODO: 2017/11/16 Memory Cache
            return results;
        } else {
            results = new MutableLiveData<>();
        }

        getDataTest.execute(new GetSoccerSeasion(),null);
        return results;
    }

    @Override
    public void detach() {
        getDataTest.dispose();
        onCleared();
    }

    private final class GetSoccerSeasion extends DisposableSubscriber<List<SoccerSeasonEntity>> {

        @Override
        protected void onStart() {
            super.onStart();
            results.setValue(Resource.<List<SoccerSeasonModel>>loading(null));
        }

        @Override
        public void onNext(List<SoccerSeasonEntity> soccerSeasons) {
            results.setValue(Resource.success(dataMapper.transform(soccerSeasons)));
        }

        @Override
        public void onError(Throwable t) {
            results.setValue(Resource.<List<SoccerSeasonModel>>error(t.getMessage(), null));
        }

        @Override
        public void onComplete() {

        }
    }
}
