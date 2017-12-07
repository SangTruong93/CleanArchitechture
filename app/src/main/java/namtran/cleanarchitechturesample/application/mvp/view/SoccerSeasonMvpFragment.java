package namtran.cleanarchitechturesample.application.mvp.view;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.mvp.adapter.SoccerSeasonAdapter;
import namtran.cleanarchitechturesample.application.mvp.core.BaseFragmentMvp;
import namtran.cleanarchitechturesample.application.mvp.presenter.iview.IISoccerSeasonFragment;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

public class SoccerSeasonMvpFragment extends BaseFragmentMvp<IISoccerSeasonFragment.IPresenter> implements IISoccerSeasonFragment.IView {

    @BindView(R.id.rv_soccer_season)
    RecyclerView mRv;

    @Inject
    SoccerSeasonAdapter mAdapter;

    @Override
    protected int setLayoutContainId() {
        return R.layout.fragment_mvp_soccer_season;
    }

    @Override
    protected void initData() {
        mRv.setLayoutManager(new LinearLayoutManager(getThis()));
        mRv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mRv.setHasFixedSize(true);
        mRv.setAdapter(mAdapter);
        presenter.getSession();
    }

    @Override
    public void onComplete(List<SoccerSeason> soccerSeason) {
        if (mAdapter != null)
            mAdapter.updateData(soccerSeason);
    }
}
