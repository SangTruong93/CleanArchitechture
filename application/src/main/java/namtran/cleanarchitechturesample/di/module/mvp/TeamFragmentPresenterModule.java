package namtran.cleanarchitechturesample.di.module.mvp;

import dagger.Binds;
import dagger.Module;
import namtran.cleanarchitechturesample.view.mvp.presenter.TeamFragmentPresenter;
import namtran.cleanarchitechturesample.view.mvp.presenter.iview.ITeamFragment;
import namtran.cleanarchitechturesample.di.inject.PerFragment;

/**
 * Provides example 1 presenter dependencies.
 */
@Module
public abstract class TeamFragmentPresenterModule {

    @Binds
    @PerFragment
    abstract ITeamFragment.IPresenter example1Presenter(TeamFragmentPresenter presenter);
}
