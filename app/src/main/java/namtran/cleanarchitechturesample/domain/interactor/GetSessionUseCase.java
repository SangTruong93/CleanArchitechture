package namtran.cleanarchitechturesample.domain.interactor;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import namtran.cleanarchitechturesample.domain.executor.SchedulerProvider;
import namtran.cleanarchitechturesample.domain.interactor.core.UseCase;
import namtran.cleanarchitechturesample.domain.repository.IAppRepository;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;

@Singleton
public class GetSessionUseCase extends UseCase<List<SoccerSeasons>,Void> {

    @Inject
    public GetSessionUseCase(IAppRepository iAppRepository, SchedulerProvider schedulerProvider) {
        super(iAppRepository, schedulerProvider);
    }

    @Override
    protected Observable<List<SoccerSeasons>> buildUseCaseObservable(Void aVoid) {
        return iAppRepository.getData();
    }
}
