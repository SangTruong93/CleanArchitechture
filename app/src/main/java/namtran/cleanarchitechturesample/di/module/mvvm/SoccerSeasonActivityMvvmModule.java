package namtran.cleanarchitechturesample.di.module.mvvm;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import namtran.cleanarchitechturesample.application.core.BaseActivity;
import namtran.cleanarchitechturesample.application.core.BaseActivityModule;
import namtran.cleanarchitechturesample.application.mvvm.view.SoccerSeasonMvvmActivity;
import namtran.cleanarchitechturesample.application.mvvm.view.SoccerSeasonMvvmFragment;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.cleanarchitechturesample.di.inject.PerFragment;

/**
 * Provides example 1 activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class
})
public abstract class SoccerSeasonActivityMvvmModule {

    /**
     * Provides the injector for the {@link SoccerSeasonMvvmFragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = SoccerSeasonFragmentMvvmModule.class)
    abstract SoccerSeasonMvvmFragment soccerSeasonMvpFragmentInjector();

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link AppCompatActivity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link BaseActivity}.
     *
     * @param activity the example 1 activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract Activity activity(SoccerSeasonMvvmActivity activity);
}
