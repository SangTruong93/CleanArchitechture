package namtran.cleanarchitechturesample.application.mvp.presenter;


import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.application.mvp.core.BasePresenter;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.IISoccerSeasonFragment;
import namtran.cleanarchitechturesample.di.inject.PerFragment;
import namtran.cleanarchitechturesample.domain.interactor.GetSessionUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultSubscriber;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;

@PerFragment
public class SoccerSeasonFragmentPresenter extends BasePresenter<IISoccerSeasonFragment.IView> implements IISoccerSeasonFragment.IPresenter {

    private final GetSessionUseCase mSessionUseCase;

    @Inject
    SoccerSeasonFragmentPresenter(IISoccerSeasonFragment.IView IView, GetSessionUseCase mSessionUseCase) {
        super(IView);
        this.mSessionUseCase = mSessionUseCase;
    }

    @Override
    public void getSession() {
        getMvpView().onShowLoading();
        mSessionUseCase.execute(new GetData(),null);
    }

    @Override
    public void detach() {
        detachView();
        if (mSessionUseCase != null)
            mSessionUseCase.dispose();
    }

    private final class GetData extends DefaultSubscriber<List<SoccerSeasons>> {

        @Override public void onComplete() {
            getMvpView().onHideLoading();
        }

        @Override public void onError(Throwable e) {
            getMvpView().onHideLoading();
            getMvpView().onShowMessageError(e);
        }

        @Override
        public void onNext(List<SoccerSeasons> soccerSeasonsRespons) {
            getMvpView().onComplete(soccerSeasonsRespons);
        }
    }
}
