package namtran.cleanarchitechturesample.application.mvvm.viewmodel;


import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.application.mvvm.core.BaseViewModel;
import namtran.cleanarchitechturesample.domain.interactor.GetTeamUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultSubscriber;
import namtran.cleanarchitechturesample.flatform.Resource;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

public class TeamFragmentModel extends BaseViewModel {

    private MutableLiveData<Resource<List<Team>>> results;
    private final GetTeamUseCase getTeamUseCase;

    @Inject
    TeamFragmentModel(Application application, GetTeamUseCase getTeamUseCase) {
        super(application);
        this.getTeamUseCase = getTeamUseCase;
    }

    public MutableLiveData<Resource<List<Team>>> getResults(int idSeason) {
        if (results != null) {
            // TODO: 2017/11/16 Memory Cache
            return results;
        } else {
            results = new MutableLiveData<>();
        }

        getTeamUseCase.execute(new GetTeam(results),idSeason);
        return results;
    }

    @Override
    public void detach() {
        getTeamUseCase.dispose();
        onCleared();
    }

    private final class GetTeam extends DefaultSubscriber<List<Team>> {

        GetTeam(MutableLiveData<Resource<List<Team>>> results) {
            super(results);
        }
    }
}
