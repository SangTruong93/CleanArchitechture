package namtran.cleanarchitechturesample.di.module.mvp;


import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import namtran.cleanarchitechturesample.application.core.BaseFragmentModule;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.ISoccerSeasonFragment;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.ITeamFragment;
import namtran.cleanarchitechturesample.application.mvp.view.SoccerSeasonMvpFragment;
import namtran.cleanarchitechturesample.application.mvp.view.TeamMvpFragment;
import namtran.cleanarchitechturesample.di.inject.PerFragment;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

/**
 * Provides main fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class,
        TeamFragmentPresenterModule.class
})
public abstract class TeamFragmentMvpModule {

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
    abstract Fragment fragment(TeamMvpFragment fragment);

    @Binds
    @PerFragment
    abstract ITeamFragment.IView provideView(TeamMvpFragment fragment);
}
