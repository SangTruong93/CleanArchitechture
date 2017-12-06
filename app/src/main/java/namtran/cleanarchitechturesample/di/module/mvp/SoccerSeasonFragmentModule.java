package namtran.cleanarchitechturesample.di.module.mvp;

import android.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import namtran.cleanarchitechturesample.application.core.BaseFragmentModule;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.IISoccerSeasonFragment;
import namtran.cleanarchitechturesample.application.mvp.view.SoccerSeasonMvpFragment;
import namtran.cleanarchitechturesample.di.inject.PerFragment;

/**
 * Provides main fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class,
        SoccerSeasonFragmentPresenterModule.class
})
public abstract class SoccerSeasonFragmentModule {

    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     * @param fragment the main fragment
     * @return the fragment
     */
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(SoccerSeasonMvpFragment fragment);

    @Binds
    @PerFragment
    abstract IISoccerSeasonFragment.IView provideView(SoccerSeasonMvpFragment fragment);
}
