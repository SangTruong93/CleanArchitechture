package namtran.cleanarchitechturesample.di.module.mvvm;


import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import namtran.cleanarchitechturesample.view.core.BaseFragmentModule;
import namtran.cleanarchitechturesample.view.mvvm.view.TeamMvvmFragment;
import namtran.cleanarchitechturesample.di.inject.PerFragment;

/**
 * Provides main fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class
})
public abstract class TeamFragmentMvvmModule {

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
    abstract Fragment fragment(TeamMvvmFragment fragment);
}
