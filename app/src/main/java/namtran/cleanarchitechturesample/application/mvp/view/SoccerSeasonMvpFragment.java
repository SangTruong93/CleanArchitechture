package namtran.cleanarchitechturesample.application.mvp.view;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.adapter.SoccerSeasonAdapter;
import namtran.cleanarchitechturesample.application.mvp.core.BaseFragmentMvp;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.ISoccerSeasonFragment;
import namtran.cleanarchitechturesample.application.mvp.view.callback.SoccerSeasonMvpFragmentCallback;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

public class SoccerSeasonMvpFragment extends BaseFragmentMvp<ISoccerSeasonFragment.IPresenter> implements ISoccerSeasonFragment.IView, SoccerSeasonAdapter.OnSoccerSeasonItemClick {

    @BindView(R.id.rv_soccer_season)
    RecyclerView mRv;

    @Inject
    SoccerSeasonAdapter mAdapter;
    @Inject
    SoccerSeasonMvpFragmentCallback listener;

    @Override
    protected int setLayoutContainId() {
        return R.layout.fragment_mvp_soccer_season;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mAdapter.setOnSoccerSeasonItemClick(this);
        mRv.setLayoutManager(new LinearLayoutManager(getThis()));
        mRv.addItemDecoration(new DividerItemDecoration(getThis(), DividerItemDecoration.VERTICAL));
        mRv.setHasFixedSize(true);
        mRv.setAdapter(mAdapter);
        presenter.getSession();
    }

    @Override
    public void onComplete(List<SoccerSeason> soccerSeason) {
        if (mAdapter != null)
            mAdapter.updateData(soccerSeason);
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onSoccerSeasonMvpFragmentCallback();
    }

    @Override
    public void onSoccerSeasonItemClick(SoccerSeason data) {
        addFragment(R.id.contain_main,TeamMvpFragment.getInstance(data.id,data.league));
    }

    @Override
    protected void detach() {
        presenter.detach();
    }
}
