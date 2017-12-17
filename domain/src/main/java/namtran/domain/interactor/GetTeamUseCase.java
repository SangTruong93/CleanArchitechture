package namtran.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import namtran.domain.executor.SchedulerProvider;
import namtran.domain.interactor.core.UseCase;
import namtran.domain.repository.IAppRepository;
import namtran.flatform.remote.response.team.Team;

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
