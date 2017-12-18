package namtran.cleanarchitechturesample.view.mvp.presenter;


import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.base.DefaultMvpSubscriber;
import namtran.cleanarchitechturesample.view.mvp.core.BasePresenter;
import namtran.cleanarchitechturesample.view.mvp.presenter.iview.ISoccerSeasonFragment;
import namtran.cleanarchitechturesample.di.inject.PerFragment;
import namtran.cleanarchitechturesample.mapper.SoccerSeasonModelDataMapper;
import namtran.domain.entity.SoccerSeasonEntity;
import namtran.domain.interactor.GetSessionUseCase;

@PerFragment
public class SoccerSeasonFragmentPresenter extends BasePresenter<ISoccerSeasonFragment.IView> implements ISoccerSeasonFragment.IPresenter {

    private final GetSessionUseCase mSessionUseCase;
    private SoccerSeasonModelDataMapper dataMapper;

    @Inject
    SoccerSeasonFragmentPresenter(ISoccerSeasonFragment.IView IView, GetSessionUseCase mSessionUseCase, SoccerSeasonModelDataMapper dataMapper) {
        super(IView);
        this.mSessionUseCase = mSessionUseCase;
        this.dataMapper = dataMapper;
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

    private final class GetData extends DefaultMvpSubscriber<List<SoccerSeasonEntity>,ISoccerSeasonFragment.IView> {

        GetData(ISoccerSeasonFragment.IView iView) {
            super(iView);
        }

        @Override
        public void onNext(List<SoccerSeasonEntity> soccerSeasons) {
            super.onNext(soccerSeasons);
            view.onComplete(dataMapper.transform(soccerSeasons));
        }
    }
}
