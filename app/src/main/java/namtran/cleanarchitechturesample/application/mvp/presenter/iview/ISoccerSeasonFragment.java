package namtran.cleanarchitechturesample.application.mvp.presenter.iview;

import java.util.List;

import namtran.cleanarchitechturesample.application.mvp.core.MVPView;
import namtran.cleanarchitechturesample.application.mvp.core.Presenter;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

public interface ISoccerSeasonFragment {

    interface IView extends MVPView {
        void onComplete(List<SoccerSeason> soccerSeasonRespons);
    }

    interface IPresenter extends Presenter<IView> {
        void getSession();
    }
}
