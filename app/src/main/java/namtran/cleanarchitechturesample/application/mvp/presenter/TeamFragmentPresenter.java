package namtran.cleanarchitechturesample.application.mvp.presenter;


import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.application.mvp.core.BasePresenter;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.ITeamFragment;
import namtran.cleanarchitechturesample.domain.interactor.GetTeamUseCase;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultMvpObserve;
import namtran.cleanarchitechturesample.domain.interactor.core.DefaultMvpSubscriber;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

public class TeamFragmentPresenter extends BasePresenter<ITeamFragment.IView> implements ITeamFragment.IPresenter {

    private final GetTeamUseCase getTeamUseCase;

    @Inject
    TeamFragmentPresenter(ITeamFragment.IView viewRef, GetTeamUseCase getTeamUseCase) {
        super(viewRef);
        this.getTeamUseCase = getTeamUseCase;
    }

    @Override
    public void getListTeam(int idSoccerSeason) {
        getTeamUseCase.execute(new GetData(getMvpView()),idSoccerSeason);
    }

    @Override
    public void detach() {
        detachView();
        if (getTeamUseCase != null)
            getTeamUseCase.dispose();
    }

    private final class GetData extends DefaultMvpSubscriber<List<Team>,ITeamFragment.IView>{

        GetData(ITeamFragment.IView iView) {
            super(iView);
        }

        @Override
        public void onNext(List<Team> teams) {
            super.onNext(teams);
            view.onComplete(teams);
        }
    }
}
