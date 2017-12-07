package namtran.cleanarchitechturesample.application.mvp.presenter;


import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.application.mvp.core.BasePresenter;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.IISoccerSeasonFragment;
import namtran.cleanarchitechturesample.di.inject.PerFragment;
import namtran.cleanarchitechturesample.domain.interactor.GetSessionUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultMvpSubscriber;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

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
        mSessionUseCase.execute(new GetData(getMvpView()),null);
    }

    @Override
    public void detach() {
        detachView();
        if (mSessionUseCase != null)
            mSessionUseCase.dispose();
    }

    private final class GetData extends DefaultMvpSubscriber<List<SoccerSeason>,IISoccerSeasonFragment.IView> {

        GetData(IISoccerSeasonFragment.IView iView) {
            super(iView);
        }

        @Override
        public void onNext(List<SoccerSeason> soccerSeasonRespons) {
            getMvpView().onComplete(soccerSeasonRespons);
            super.onNext(soccerSeasonRespons);
        }
    }
}
