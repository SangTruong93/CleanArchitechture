package namtran.cleanarchitechturesample.view.mvp.presenter;

import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.base.DefaultMvpSubscriber;
import namtran.cleanarchitechturesample.view.mvp.core.BasePresenter;
import namtran.cleanarchitechturesample.view.mvp.presenter.iview.IMvpActivity;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.domain.interactor.GetSessionUseCase;
import namtran.flatform.remote.response.session.SoccerSeason;

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

        GetData(IMvpActivity.IView iView) {
            super(iView);
        }

        @Override
        public void onNext(List<SoccerSeason> soccerSeasons) {
            //view.onComplete(soccerSeasons);
        }
    }
}
