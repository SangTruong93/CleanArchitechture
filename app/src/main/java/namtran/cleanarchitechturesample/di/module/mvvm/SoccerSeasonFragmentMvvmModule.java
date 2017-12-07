package namtran.cleanarchitechturesample.di.module.mvvm;

import android.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import namtran.cleanarchitechturesample.application.core.BaseFragmentModule;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.IISoccerSeasonFragment;
import namtran.cleanarchitechturesample.application.mvp.view.SoccerSeasonMvpFragment;
import namtran.cleanarchitechturesample.application.mvvm.view.SoccerSeasonMvvmFragment;
import namtran.cleanarchitechturesample.di.inject.PerFragment;
import namtran.cleanarchitechturesample.di.module.mvp.SoccerSeasonFragmentPresenterModule;

/**
 * Provides main fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class
})
public abstract class SoccerSeasonFragmentMvvmModule {

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
    abstract Fragment fragment(SoccerSeasonMvvmFragment fragment);
}
