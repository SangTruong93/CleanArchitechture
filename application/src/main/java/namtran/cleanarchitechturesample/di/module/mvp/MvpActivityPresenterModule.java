package namtran.cleanarchitechturesample.di.module.mvp;


import dagger.Binds;
import dagger.Module;
import namtran.cleanarchitechturesample.view.mvp.presenter.MvpActivityPresenter;
import namtran.cleanarchitechturesample.view.mvp.presenter.iview.IMvpActivity;
import namtran.cleanarchitechturesample.di.inject.PerActivity;

@Module
public abstract class MvpActivityPresenterModule {

    @Binds
    @PerActivity
    abstract IMvpActivity.IPresenter mainPresenter(MvpActivityPresenter mainMvpActivityPresenter);
}
