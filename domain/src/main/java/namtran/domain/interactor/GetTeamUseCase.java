package namtran.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import namtran.domain.entity.TeamEntity;
import namtran.domain.executor.SchedulerProvider;
import namtran.domain.interactor.core.UseCase;
import namtran.domain.repository.IAppRepository;
import namtran.flatform.remote.response.team.Team;

public class GetTeamUseCase extends UseCase<List<TeamEntity>,Integer> {

    @Inject
    GetTeamUseCase(IAppRepository iAppRepository, SchedulerProvider schedulerProvider) {
        super(iAppRepository, schedulerProvider);
    }

    @Override
    protected Flowable<List<TeamEntity>> buildUseCaseFlowable(Integer integer) {
        return iAppRepository.getListTeam(integer);
    }

    @Override
    protected Observable<List<TeamEntity>> buildUseCaseObserve(Integer integer) {
        return null;
    }
}
