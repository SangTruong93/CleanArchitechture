package namtran.cleanarchitechturesample.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import namtran.cleanarchitechturesample.domain.executor.AppSchedulerProvider;
import namtran.cleanarchitechturesample.domain.executor.SchedulerProvider;
import namtran.cleanarchitechturesample.domain.repository.AppRepository;
import namtran.cleanarchitechturesample.domain.repository.IAppRepository;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides @Singleton
    IAppRepository provideDataManager(AppRepository repository) {
        return repository;
    }
}
