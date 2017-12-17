package namtran.cleanarchitechturesample.view.mvp.presenter.iview;

import java.util.List;

import namtran.cleanarchitechturesample.view.mvp.core.MVPView;
import namtran.cleanarchitechturesample.view.mvp.core.Presenter;
import namtran.cleanarchitechturesample.model.SoccerSeasonModel;

public interface ISoccerSeasonFragment {

    interface IView extends MVPView {
        void onComplete(List<SoccerSeasonModel> soccerSeasonRespons);
    }

    interface IPresenter extends Presenter<IView> {
        void getSession();
    }
}
