package namtran.cleanarchitechturesample.di.module;

import android.app.Activity;
import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import namtran.cleanarchitechturesample.application.AppState;
import namtran.cleanarchitechturesample.application.mvp.view.SoccerSeasonMvpActivity;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.cleanarchitechturesample.di.module.mvp.SoccerSeasonActivityModule;

/**
 * Provides application-wide dependencies.
 */
@Module(includes = {
        AndroidInjectionModule.class,
        NetModule.class,
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
    @ContributesAndroidInjector(modules = SoccerSeasonActivityModule.class)
    abstract SoccerSeasonMvpActivity mainActivityInjector();
}
