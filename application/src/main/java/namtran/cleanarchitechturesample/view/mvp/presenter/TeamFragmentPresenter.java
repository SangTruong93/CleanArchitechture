package namtran.cleanarchitechturesample.view.mvp.presenter;


import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.base.DefaultMvpSubscriber;
import namtran.cleanarchitechturesample.view.mvp.core.BasePresenter;
import namtran.cleanarchitechturesample.view.mvp.presenter.iview.ITeamFragment;
import namtran.cleanarchitechturesample.mapper.TeamModelDataMapper;
import namtran.domain.interactor.GetTeamUseCase;
import namtran.flatform.remote.response.team.Team;

public class TeamFragmentPresenter extends BasePresenter<ITeamFragment.IView> implements ITeamFragment.IPresenter {

    private final GetTeamUseCase getTeamUseCase;
    private final TeamModelDataMapper dataMapper;

    @Inject
    TeamFragmentPresenter(ITeamFragment.IView viewRef, GetTeamUseCase getTeamUseCase, TeamModelDataMapper dataMapper1) {
        super(viewRef);
        this.getTeamUseCase = getTeamUseCase;
        this.dataMapper = dataMapper1;
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

    private final class GetData extends DefaultMvpSubscriber<List<Team>,ITeamFragment.IView> {

        GetData(ITeamFragment.IView iView) {
            super(iView);
        }

        @Override
        public void onNext(List<Team> teams) {
            super.onNext(teams);
            view.onComplete(dataMapper.transform(teams));
        }
    }
}
