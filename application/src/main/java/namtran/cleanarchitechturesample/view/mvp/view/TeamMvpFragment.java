package namtran.cleanarchitechturesample.view.mvp.view;


import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.view.adapter.TeamAdapter;
import namtran.cleanarchitechturesample.view.mvp.core.BaseFragmentMvp;
import namtran.cleanarchitechturesample.view.mvp.presenter.iview.ITeamFragment;
import namtran.cleanarchitechturesample.view.mvp.view.callback.TeamMvpFragmentCallback;
import namtran.cleanarchitechturesample.model.TeamModel;

public class TeamMvpFragment extends BaseFragmentMvp<ITeamFragment.IPresenter> implements ITeamFragment.IView {

    @BindView(R.id.rvTeam)
    RecyclerView mRvTeam;

    @Inject
    TeamAdapter mAdapter;

    @Inject
    TeamMvpFragmentCallback listener;

    private String mSeasionName;

    public static TeamMvpFragment getInstance(int seasion,String seasionName) {
        TeamMvpFragment fragment = new TeamMvpFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Seasion ID", seasion);
        bundle.putString("Seasion Name", seasionName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int setLayoutContainId() {
        return R.layout.fragment_mvp_team;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mRvTeam.setLayoutManager(new LinearLayoutManager(getThis()));
        mRvTeam.addItemDecoration(new DividerItemDecoration(getThis(), DividerItemDecoration.VERTICAL));
        mRvTeam.setHasFixedSize(true);
        mRvTeam.setAdapter(mAdapter);

        if (getArguments() != null) {
            int seasion = getArguments().getInt("Seasion ID");
            mSeasionName = getArguments().getString("Seasion Name");
            presenter.getListTeam(seasion);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onTeamMvpFragmentCallback(mSeasionName);
    }

    @Override
    public void onComplete(List<TeamModel> teams) {
        if (mAdapter != null)
            mAdapter.updateData(teams);
    }

    @Override
    protected void detach() {
        presenter.detach();
    }
}
