package namtran.cleanarchitechturesample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import namtran.domain.executor.AppSchedulerProvider;
import namtran.domain.executor.SchedulerProvider;
import namtran.domain.repository.AppRepository;
import namtran.domain.repository.IAppRepository;

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
