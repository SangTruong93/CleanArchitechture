package namtran.cleanarchitechturesample.application.mvp.core;


import android.os.Bundle;
import android.support.annotation.CallSuper;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.application.core.BaseActivity;

public abstract class BaseActivityMvp<T extends Presenter> extends BaseActivity implements MVPView {

    @Inject
    protected T presenter;

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        presenter.onEnd();
        super.onDestroy();
    }

    @Override
    public void onShowMessageError(Throwable cause) {

    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    public void onShowLoadingDialog() {

    }

    @Override
    public void onHideLoadingDialog() {

    }
}
