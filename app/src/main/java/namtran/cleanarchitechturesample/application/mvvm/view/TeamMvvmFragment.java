package namtran.cleanarchitechturesample.application.mvvm.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.adapter.TeamAdapter;
import namtran.cleanarchitechturesample.application.mvvm.core.BaseFragmentMvvm;
import namtran.cleanarchitechturesample.application.mvvm.view.callback.TeamMvvmFragmentCallback;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.TeamFragmentModel;
import namtran.cleanarchitechturesample.databinding.FragmentMvvmTeamBinding;
import namtran.cleanarchitechturesample.flatform.Resource;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

public class TeamMvvmFragment extends BaseFragmentMvvm<FragmentMvvmTeamBinding,TeamFragmentModel> {

    @Inject
    TeamAdapter mAdapter;
    @Inject
    TeamMvvmFragmentCallback listener;

    private String mSeasionName;

    public static TeamMvvmFragment getInstance(int seasion, String seasionName) {
        TeamMvvmFragment fragment = new TeamMvvmFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Seasion ID", seasion);
        bundle.putString("Seasion Name", seasionName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mvvm_team;
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(this,factory).get(TeamFragmentModel.class);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mViewDataBinding.rvTeam.addItemDecoration(new DividerItemDecoration(getThis(), DividerItemDecoration.VERTICAL));
        mViewDataBinding.rvTeam.setAdapter(mAdapter);
        if (getArguments() != null) {
            int seasion = getArguments().getInt("Seasion ID");
            mSeasionName = getArguments().getString("Seasion Name");
            mViewModel.getResults(seasion).observe(this, new Observer<Resource<List<Team>>>() {
                @Override
                public void onChanged(@Nullable Resource<List<Team>> listResource) {
                    mViewDataBinding.setResource(listResource);
                    mViewDataBinding.executePendingBindings();
                    if (listResource != null && listResource.data != null) {
                        mAdapter.updateData(listResource.data);
                    }
                }
            });
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onTeamMvvmFragmentCallback(mSeasionName);
    }

    @Override
    protected void detach() {
        mViewModel.detach();
    }
}
