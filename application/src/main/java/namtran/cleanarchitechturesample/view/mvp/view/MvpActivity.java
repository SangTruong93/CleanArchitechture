package namtran.cleanarchitechturesample.view.mvp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.view.mvp.core.BaseActivityMvp;
import namtran.cleanarchitechturesample.view.mvp.presenter.iview.IMvpActivity;
import namtran.cleanarchitechturesample.view.mvp.view.callback.SoccerSeasonMvpFragmentCallback;
import namtran.cleanarchitechturesample.view.mvp.view.callback.TeamMvpFragmentCallback;


public class MvpActivity extends BaseActivityMvp<IMvpActivity.IPresenter> implements IMvpActivity.IView,SoccerSeasonMvpFragmentCallback,TeamMvpFragmentCallback {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_soccer_season_mvp;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);

//        presenter.getSession();

        addFragment(R.id.contain_main, new SoccerSeasonMvpFragment());
    }

    @Override
    public void onSoccerSeasonMvpFragmentCallback() {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("List Soccer Season ( Mvp )");
    }

    @Override
    public void onTeamMvpFragmentCallback(String seasionName) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("List Team of " + seasionName + " ( Mvp )");
    }

    @Override
    protected void detach() {
        presenter.detach();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = fragmentManager.findFragmentById(R.id.contain_main);
        if (fragment != null)
            fragment.onResume();
        else
            finish();
    }
}
