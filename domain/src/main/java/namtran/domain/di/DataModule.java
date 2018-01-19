package namtran.domain.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import namtran.domain.executor.AppSchedulerProvider;
import namtran.domain.executor.SchedulerProvider;
import namtran.domain.repository.AppRepository;
import namtran.domain.repository.IAppRepository;
import namtran.flatform.di.DbModule;
import namtran.flatform.di.NetModule;

@Module(includes = {NetModule.class , DbModule.class})
public abstract class DataModule {

    @Binds
    @Singleton
    abstract IAppRepository provideDataManager(AppRepository repository);

    @Binds
    @Singleton
    abstract SchedulerProvider provideSchedulerProvider(AppSchedulerProvider schedulerProvider);
}
