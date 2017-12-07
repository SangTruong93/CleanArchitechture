package namtran.cleanarchitechturesample.application.mvp.presenter;

import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.application.mvp.core.BasePresenter;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.ISoccerSeasonActivity;
import namtran.cleanarchitechturesample.di.inject.PerActivity;
import namtran.cleanarchitechturesample.domain.interactor.GetSessionUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultMvpSubscriber;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

@PerActivity
public class SoccerSeasonActivityPresenter extends BasePresenter<ISoccerSeasonActivity.IView> implements ISoccerSeasonActivity.IPresenter {

    private final GetSessionUseCase mSessionUseCase;

    @Inject
    SoccerSeasonActivityPresenter(ISoccerSeasonActivity.IView IView, GetSessionUseCase mSessionUseCase) {
        super(IView);
        this.mSessionUseCase = mSessionUseCase;
    }

    @Override
    public void getSession() {
//        mSessionUseCase.execute(new GetData(),null);
    }

    @Override
    public void detach() {
        detachView();
        if (mSessionUseCase != null)
            mSessionUseCase.dispose();
    }

//    private final class GetData extends DefaultMvpSubscriber<List<SoccerSeason>> {
//
//        @Override public void onComplete() {
//            getMvpView().onHideLoading();
//        }
//
//        @Override public void onError(Throwable e) {
//            getMvpView().onHideLoading();
//            getMvpView().onShowMessageError(e);
//        }
//
//        @Override
//        public void onNext(List<SoccerSeason> soccerSeasonRespons) {
//            //todo
//        }
//    }
}
