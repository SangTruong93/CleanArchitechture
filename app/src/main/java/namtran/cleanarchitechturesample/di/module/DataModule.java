package namtran.cleanarchitechturesample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import namtran.cleanarchitechturesample.domain.executor.AppSchedulerProvider;
import namtran.cleanarchitechturesample.domain.executor.SchedulerProvider;
import namtran.cleanarchitechturesample.domain.repository.AppRepository;
import namtran.cleanarchitechturesample.domain.repository.IAppRepository;

@Module
public class DataModule {

    @Provides
    @Singleton
    IAppRepository provideDataManager(AppRepository repository) {
        return repository;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
