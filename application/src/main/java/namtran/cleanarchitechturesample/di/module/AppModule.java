package namtran.cleanarchitechturesample.di.module;

import android.app.Activity;
import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import namtran.cleanarchitechturesample.view.AppState;
import namtran.cleanarchitechturesample.view.mvp.view.MvpActivity;
import namtran.cleanarchitechturesample.view.mvvm.view.MvvmActivity;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.cleanarchitechturesample.di.module.mvp.MvpActivityModule;
import namtran.cleanarchitechturesample.di.module.mvvm.MvvmActivityMvvmModule;
import namtran.domain.di.DataModule;

/**
 * Provides application-wide dependencies.
 */
@Module(includes = {
        AndroidSupportInjectionModule.class,
        ViewModelModule.class,
        DataModule.class
})
public abstract class AppModule {

    @Binds
    @Singleton
    /*
     * Singleton annotation isn't necessary since Application instance is unique but is here for
     * convention. In general, providing Activity, Fragment, BroadcastReceiver, etc does not require
     * them to be scoped since they are the components being injected and their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    abstract Application application(AppState app);

    /**
     * Provides the injector for the {@link Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = MvpActivityModule.class)
    abstract MvpActivity soccerSeasonActivityMvpInjector();

    /**
     * Provides the injector for the {@link Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = MvvmActivityMvvmModule.class)
    abstract MvvmActivity soccerSeasonActivityMvvmInjector();
}
