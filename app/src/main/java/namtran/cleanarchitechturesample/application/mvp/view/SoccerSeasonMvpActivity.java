package namtran.cleanarchitechturesample.application.mvp.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.mvp.core.BaseActivityMvp;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.ISoccerSeasonActivity;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;


public class SoccerSeasonMvpActivity extends BaseActivityMvp<ISoccerSeasonActivity.IPresenter> implements ISoccerSeasonActivity.IView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R   .layout.activity_main);
        ButterKnife.bind(this);

        mToolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Soccer Season ( Mvp )");

//        presenter.getSession();

        addFragment(R.id.contain_main, new SoccerSeasonMvpFragment());
    }
}
