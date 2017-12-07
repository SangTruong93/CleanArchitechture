package namtran.cleanarchitechturesample.application.mvp.presenter.iview;

import namtran.cleanarchitechturesample.application.mvp.core.MVPView;
import namtran.cleanarchitechturesample.application.mvp.core.Presenter;

public interface ISoccerSeasonActivity {
    interface IView extends MVPView {

    }

    interface IPresenter extends Presenter<IView> {
        void getSession();
    }
}
