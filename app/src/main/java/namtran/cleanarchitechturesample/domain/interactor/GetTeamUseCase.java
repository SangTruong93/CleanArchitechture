package namtran.cleanarchitechturesample.domain.interactor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import namtran.cleanarchitechturesample.domain.executor.SchedulerProvider;
import namtran.cleanarchitechturesample.domain.interactor.core.UseCase;
import namtran.cleanarchitechturesample.domain.repository.IAppRepository;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

public class GetTeamUseCase extends UseCase<List<Team>,Integer> {

    @Inject
    GetTeamUseCase(IAppRepository iAppRepository, SchedulerProvider schedulerProvider) {
        super(iAppRepository, schedulerProvider);
    }

    @Override
    protected Flowable<List<Team>> buildUseCaseFlowable(Integer integer) {
        return iAppRepository.getListTeam(integer);
    }

    @Override
    protected Observable<List<Team>> buildUseCaseObserve(Integer integer) {
        return null;
    }
}
