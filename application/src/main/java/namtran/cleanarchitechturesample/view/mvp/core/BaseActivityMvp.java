package namtran.cleanarchitechturesample.view.mvp.core;


import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import namtran.cleanarchitechturesample.view.core.BaseActivity;

public abstract class BaseActivityMvp<T extends Presenter> extends BaseActivity implements MVPView {

    @Inject
    protected T presenter;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        initData(savedInstanceState);
    }

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
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
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

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Data initialization
     *
     * @param savedInstanceState Bundle
     */
    public abstract void initData(Bundle savedInstanceState);
}
