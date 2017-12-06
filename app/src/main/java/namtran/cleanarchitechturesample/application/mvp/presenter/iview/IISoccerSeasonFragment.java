package namtran.cleanarchitechturesample.application.mvp.presenter.iview;

import java.util.List;

import namtran.cleanarchitechturesample.application.mvp.core.MVPView;
import namtran.cleanarchitechturesample.application.mvp.core.Presenter;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;

public interface IISoccerSeasonFragment {

    interface IView extends MVPView {
        void onComplete(List<SoccerSeasons> soccerSeasonsRespons);
    }

    interface IPresenter extends Presenter<IView> {
        void getSession();
    }
}
