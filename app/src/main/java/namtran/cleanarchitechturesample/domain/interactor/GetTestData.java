package namtran.cleanarchitechturesample.domain.interactor;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import namtran.cleanarchitechturesample.domain.executor.SchedulerProvider;
import namtran.cleanarchitechturesample.domain.interactor.core.UseCase;
import namtran.cleanarchitechturesample.domain.repository.IAppRepository;
import namtran.cleanarchitechturesample.flatform.model.Test;

public class GetTestData extends UseCase<List<Test>,Void> {

    @Inject
    GetTestData(IAppRepository iAppRepository, SchedulerProvider schedulerProvider) {
        super(iAppRepository,schedulerProvider);
        this.iAppRepository = iAppRepository;
    }

    @Override
    protected Flowable<List<Test>> buildUseCaseObservable(Void aVoid) {
        return iAppRepository.getData();
    }
}
