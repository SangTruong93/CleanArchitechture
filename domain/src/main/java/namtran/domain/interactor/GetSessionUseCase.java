package namtran.domain.interactor;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import namtran.domain.entity.SoccerSeasonEntity;
import namtran.domain.executor.SchedulerProvider;
import namtran.domain.interactor.core.UseCase;
import namtran.domain.repository.IAppRepository;
import namtran.flatform.remote.response.session.SoccerSeason;

public class GetSessionUseCase extends UseCase<List<SoccerSeasonEntity>,Void> {

    @Inject
    GetSessionUseCase(IAppRepository iAppRepository, SchedulerProvider schedulerProvider) {
        super(iAppRepository, schedulerProvider);
    }

    @Override
    protected Flowable<List<SoccerSeasonEntity>> buildUseCaseFlowable(Void aVoid) {
        return iAppRepository.getListSeason();
    }

    @Override
    protected Observable<List<SoccerSeasonEntity>> buildUseCaseObserve(Void aVoid) {
        return null;
    }
}
