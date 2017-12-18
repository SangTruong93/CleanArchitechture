package namtran.cleanarchitechturesample.view.mvvm.viewmodel;


import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.subscribers.DisposableSubscriber;
import namtran.cleanarchitechturesample.view.mvvm.core.BaseViewModel;
import namtran.cleanarchitechturesample.Resource;
import namtran.cleanarchitechturesample.mapper.TeamModelDataMapper;
import namtran.cleanarchitechturesample.model.TeamModel;
import namtran.domain.entity.TeamEntity;
import namtran.domain.interactor.GetTeamUseCase;

public class TeamFragmentModel extends BaseViewModel {

    private MutableLiveData<Resource<List<TeamModel>>> results;
    private final GetTeamUseCase getTeamUseCase;
    private final TeamModelDataMapper dataMapper;

    @Inject
    TeamFragmentModel(Application application, GetTeamUseCase getTeamUseCase, TeamModelDataMapper dataMapper) {
        super(application);
        this.getTeamUseCase = getTeamUseCase;
        this.dataMapper = dataMapper;
    }

    public MutableLiveData<Resource<List<TeamModel>>> getResults(int idSeason) {
        if (results != null) {
            // TODO: 2017/11/16 Memory Cache
            return results;
        } else {
            results = new MutableLiveData<>();
        }

        getTeamUseCase.execute(new GetTeam(),idSeason);
        return results;
    }

    @Override
    public void detach() {
        getTeamUseCase.dispose();
        onCleared();
    }

    private final class GetTeam extends DisposableSubscriber<List<TeamEntity>> {

        @Override
        protected void onStart() {
            super.onStart();
            results.setValue(Resource.<List<TeamModel>>loading(null));
        }

        @Override
        public void onNext(List<TeamEntity> teams) {
            results.setValue(Resource.success(dataMapper.transform(teams)));
        }

        @Override
        public void onError(Throwable t) {
            results.setValue(Resource.<List<TeamModel>>error(t.getMessage(), null));
        }

        @Override
        public void onComplete() {

        }
    }
}
