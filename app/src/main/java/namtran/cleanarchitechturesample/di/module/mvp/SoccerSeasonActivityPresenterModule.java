package namtran.cleanarchitechturesample.di.module.mvp;


import dagger.Binds;
import dagger.Module;
import namtran.cleanarchitechturesample.application.mvp.presenter.SoccerSeasonActivityPresenter;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.ISoccerSeasonActivity;
import namtran.cleanarchitechturesample.di.inject.PerActivity;

@Module
public abstract class SoccerSeasonActivityPresenterModule {

    @Binds
    @PerActivity
    abstract ISoccerSeasonActivity.IPresenter mainPresenter(SoccerSeasonActivityPresenter mainSoccerSeasonActivityPresenter);
}
