package namtran.cleanarchitechturesample.application.mvp.presenter.iview;

import java.util.List;

import namtran.cleanarchitechturesample.application.mvp.core.MVPView;
import namtran.cleanarchitechturesample.application.mvp.core.Presenter;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

public interface ITeamFragment {

    interface IView extends MVPView {
        void onComplete(List<Team> teams);
    }

    interface IPresenter extends Presenter<IView> {
        void getListTeam(int idSoccerSeason);
    }
}
