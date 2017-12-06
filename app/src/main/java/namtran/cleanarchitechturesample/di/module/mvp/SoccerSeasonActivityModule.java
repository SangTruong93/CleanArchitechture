package namtran.cleanarchitechturesample.di.module.mvp;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import namtran.cleanarchitechturesample.application.core.BaseActivity;
import namtran.cleanarchitechturesample.application.core.BaseActivityModule;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.ISoccerSeasonActivity;
import namtran.cleanarchitechturesample.application.mvp.view.SoccerSeasonMvpActivity;
import namtran.cleanarchitechturesample.application.mvp.view.SoccerSeasonMvpFragment;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.cleanarchitechturesample.di.inject.PerFragment;

/**
 * Provides example 1 activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class,
        SoccerSeasonActivityPresenterModule.class
})
public abstract class SoccerSeasonActivityModule {

    /**
     * Provides the injector for the {@link SoccerSeasonMvpFragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = SoccerSeasonFragmentModule.class)
    abstract SoccerSeasonMvpFragment soccerSeasonMvpFragmentInjector();

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
    abstract Activity activity(SoccerSeasonMvpActivity activity);

    @Binds
    @PerActivity
    abstract ISoccerSeasonActivity.IView mainView(SoccerSeasonMvpActivity activity);
}
