package namtran.cleanarchitechturesample.application.mvp.presenter;

import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.application.mvp.core.BasePresenter;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.IMvpActivity;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.cleanarchitechturesample.domain.interactor.GetSessionUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultMvpObserve;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultMvpSubscriber;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

@PerActivity
public class MvpActivityPresenter extends BasePresenter<IMvpActivity.IView> implements IMvpActivity.IPresenter {

    private final GetSessionUseCase mSessionUseCase;

    @Inject
    MvpActivityPresenter(IMvpActivity.IView IView, GetSessionUseCase mSessionUseCase) {
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

    private final class GetData extends DefaultMvpSubscriber<List<SoccerSeason>,IMvpActivity.IView> {

        public GetData(IMvpActivity.IView iView) {
            super(iView);
        }

        @Override
        public void onNext(List<SoccerSeason> soccerSeasons) {
            //view.onComplete(soccerSeasons);
        }
    }
}
