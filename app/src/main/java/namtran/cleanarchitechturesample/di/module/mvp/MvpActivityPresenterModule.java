package namtran.cleanarchitechturesample.di.module.mvp;


import dagger.Binds;
import dagger.Module;
import namtran.cleanarchitechturesample.application.mvp.presenter.MvpActivityPresenter;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.IMvpActivity;
import namtran.cleanarchitechturesample.di.inject.PerActivity;

@Module
public abstract class MvpActivityPresenterModule {

    @Binds
    @PerActivity
    abstract IMvpActivity.IPresenter mainPresenter(MvpActivityPresenter mainMvpActivityPresenter);
}
