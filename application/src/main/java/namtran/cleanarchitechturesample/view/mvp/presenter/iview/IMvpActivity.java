package namtran.cleanarchitechturesample.view.mvp.presenter.iview;

import namtran.cleanarchitechturesample.view.mvp.core.MVPView;
import namtran.cleanarchitechturesample.view.mvp.core.Presenter;

public interface IMvpActivity {
    interface IView extends MVPView {

    }

    interface IPresenter extends Presenter<IView> {
        void getSession();
    }
}
