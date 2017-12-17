package namtran.cleanarchitechturesample.view.mvp.presenter.iview;

import java.util.List;

import namtran.cleanarchitechturesample.view.mvp.core.MVPView;
import namtran.cleanarchitechturesample.view.mvp.core.Presenter;
import namtran.cleanarchitechturesample.model.TeamModel;

public interface ITeamFragment {

    interface IView extends MVPView {
        void onComplete(List<TeamModel> teams);
    }

    interface IPresenter extends Presenter<IView> {
        void getListTeam(int idSoccerSeason);
    }
}
