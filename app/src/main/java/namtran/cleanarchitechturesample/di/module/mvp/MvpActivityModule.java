package namtran.cleanarchitechturesample.di.module.mvp;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import namtran.cleanarchitechturesample.application.core.BaseActivity;
import namtran.cleanarchitechturesample.application.core.BaseActivityModule;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.IMvpActivity;
import namtran.cleanarchitechturesample.application.mvp.view.MvpActivity;
import namtran.cleanarchitechturesample.application.mvp.view.SoccerSeasonMvpFragment;
import namtran.cleanarchitechturesample.application.mvp.view.TeamMvpFragment;
import namtran.cleanarchitechturesample.application.mvp.view.callback.SoccerSeasonMvpFragmentCallback;
import namtran.cleanarchitechturesample.application.mvp.view.callback.TeamMvpFragmentCallback;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.cleanarchitechturesample.di.inject.PerFragment;

/**
 * Provides example 1 activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class,
        MvpActivityPresenterModule.class
})
public abstract class MvpActivityModule {

    /**
     * Provides the injector for the {@link SoccerSeasonMvpFragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = SoccerSeasonFragmentMvpModule.class)
    abstract SoccerSeasonMvpFragment soccerSeasonMvpFragmentInjector();

    /**
     * Provides the injector for the {@link TeamMvpFragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = TeamFragmentMvpModule.class)
    abstract TeamMvpFragment teamMvpFragmentInjector();

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link android.app.Activity}."
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
    abstract AppCompatActivity activity(MvpActivity activity);

    @Binds
    @PerActivity
    abstract IMvpActivity.IView mainView(MvpActivity activity);

    /**
     * The main activity listens to the events in the {@link SoccerSeasonMvpFragment}.
     *
     * @param mvpActivity the activity
     * @return the main fragment listener
     */
    @Binds
    @PerActivity
    abstract SoccerSeasonMvpFragmentCallback soccerSeasonMvpFragmentCallback(MvpActivity mvpActivity);

    /**
     * The main activity listens to the events in the {@link namtran.cleanarchitechturesample.application.mvp.view.TeamMvpFragment}.
     *
     * @param mvpActivity the activity
     * @return the main fragment listener
     */
    @Binds
    @PerActivity
    abstract TeamMvpFragmentCallback teamMvpFragmentCallback(MvpActivity mvpActivity);
}
