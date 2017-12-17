package namtran.cleanarchitechturesample.di.module.mvvm;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import namtran.cleanarchitechturesample.view.core.BaseActivity;
import namtran.cleanarchitechturesample.view.core.BaseActivityModule;
import namtran.cleanarchitechturesample.view.mvp.view.SoccerSeasonMvpFragment;
import namtran.cleanarchitechturesample.view.mvvm.view.MvvmActivity;
import namtran.cleanarchitechturesample.view.mvvm.view.SoccerSeasonMvvmFragment;
import namtran.cleanarchitechturesample.view.mvvm.view.TeamMvvmFragment;
import namtran.cleanarchitechturesample.view.mvvm.view.callback.SoccerSeasonMvvmFragmentCallback;
import namtran.cleanarchitechturesample.view.mvvm.view.callback.TeamMvvmFragmentCallback;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.cleanarchitechturesample.di.inject.PerFragment;

/**
 * Provides example 1 activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class
})
public abstract class MvvmActivityMvvmModule {

    /**
     * Provides the injector for the {@link SoccerSeasonMvvmFragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = SoccerSeasonFragmentMvvmModule.class)
    abstract SoccerSeasonMvvmFragment soccerSeasonMvpFragmentInjector();

    /**
     * Provides the injector for the {@link TeamFragmentMvvmModule}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = TeamFragmentMvvmModule.class)
    abstract TeamMvvmFragment teamFragmentInjector();

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
    abstract AppCompatActivity activity(MvvmActivity activity);

    /**
     * The main activity listens to the events in the {@link SoccerSeasonMvpFragment}.
     *
     * @param activity the activity
     * @return the main fragment listener
     */
    @Binds
    @PerActivity
    abstract SoccerSeasonMvvmFragmentCallback soccerSeasonMvpFragmentCallback(MvvmActivity activity);

    /**
     * The main activity listens to the events in the {@link TeamMvvmFragment}.
     *
     * @param activity the activity
     * @return the main fragment listener
     */
    @Binds
    @PerActivity
    abstract TeamMvvmFragmentCallback teamMvvmFragmentCallback(MvvmActivity activity);
}
